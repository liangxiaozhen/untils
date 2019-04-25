package com.ganjiangps.wangdaibus.common.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ganjiangps.wangdaibus.common.util.WaterMarkUtils;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;

/**
 *
* @ClassName: FastDFSUploadComponent
* @Description: TODO(fdfs 文件上传工具类)
* @author cjm
* @date 2018年5月9日 上午9:56:46
*
 */
@Component
public class FastDFSUploadComponent {

	//文件上传处理状态码&&返回描述
	public static final String FDFS_STATE ="state";//文件上传状态
	public static final String FDFS_MSG ="msg";//文件上传状态描述
	public static final String FDFS_SUCCESS_STATUS ="SUCCESS";//成功
	public static final String FDFS_FAIL_STATUS ="FAIL";//失败
  	public static final String FDFS_URL ="url";  //图片or文件路径

	//图片上传返回
	public static final String FDFS_THUMBURL ="thumburl";//图片缩略图路径
	public static final String FDFS_TITLE ="title";//图片原始名称
	public static final String FDFS_ORIGINAL ="original";//图片原始名称
	public static final String FDFS_WATERMARKURL ="watermarkurl";//水印图片路径
	public static final String DIMENSION = "dimension";//图片尺寸

	private static final String FDFS_TEMP_PATH = "watermarktemp";//临时文件目录

	@Resource
	private DefaultFastFileStorageClient defaultFastFileStorageClient;

	@Resource
    private ThumbImageConfig thumbImageConfig;

	@Value("${wdbus.fdfs.url}")
	private String hostUrl; //application.properties  配置的图片服务器域名

	@Value("${wdbus.watermarkurl}")
	private String watermarkurl;

	/**
	 * 上传原图
	 * @return
	 */
	public Map<String,String> uploadImageByurl(String urlPath) {
        Map<String, String> res = new HashMap<>();
        res.put(FDFS_STATE, FDFS_FAIL_STATUS);
        res.put(FDFS_MSG, "图片上传失败");
        InputStream inStream = null;
        CloseableHttpClient client =null;
        try{
        	//文件后缀名
			String fileExtName = urlPath.substring(urlPath.lastIndexOf(".")+1);
        	client =   HttpClients.createDefault();
        	// 发送get请求
    		HttpGet request = new HttpGet(urlPath);
    		// 设置请求和传输超时时间
    		RequestConfig requestConfig = RequestConfig.custom()
    				.setSocketTimeout(50000).setConnectTimeout(50000).build();
     		//设置请求头
    		request.setHeader( "User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.79 Safari/537.1" );
     		request.setConfig(requestConfig);
    		try {
    			CloseableHttpResponse response = client.execute(request);

    			 if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
    				  HttpEntity entity = response.getEntity();
     				  inStream = entity.getContent();
       				  Long size = entity.getContentLength();
     				  //水印图片上传
    				  StorePath storePath = defaultFastFileStorageClient.uploadFile(inStream, size, fileExtName, null);
    				  //访问图片路径
    				  String fullPath = storePath.getFullPath();
    				  if (StringUtils.isNotEmpty(fullPath)) {
    					  Map<String, String> result = new HashMap<>();
    					  result.put(FDFS_URL, fullPath);
    					  result.put(FDFS_MSG, "图片上传成功!");
    					  result.put(FDFS_STATE, FDFS_SUCCESS_STATUS);
    					  return result;
    				  }
     			 }

    		} catch (IOException e) {
    			e.printStackTrace();
    			throw new RuntimeException(e);
    		} finally {
    			if(inStream != null){
    				try {
    					inStream.close();
    				} catch (IOException e) {
     					e.printStackTrace();
    				}
    			}
    			request.releaseConnection();
     		}

   		}catch(Exception e){
			e.printStackTrace();
		}
        return res;
    }

	/**
	 * 上传原图
	 * @return
	 */
	public Map<String,String> uploadDefaultFile(MultipartFile multipartFile) {
        Map<String, String> res = new HashMap<>();
        res.put(FDFS_STATE, FDFS_FAIL_STATUS);
        res.put(FDFS_MSG, "图片上传失败");
        try {
            //获取图片尺寸
            InputStream inputStream = multipartFile.getInputStream();
            BufferedImage sourceImage = javax.imageio.ImageIO.read(inputStream);
            int height = sourceImage.getHeight();
            int width = sourceImage.getWidth();
            String dimension = height + "*" + width;
            //取文件扩展名
            String originalFilename = multipartFile.getOriginalFilename();
            StorePath storePath = defaultFastFileStorageClient.uploadFile(multipartFile.getInputStream(),
                    multipartFile.getSize(), FilenameUtils.getExtension(originalFilename), null);
            StringBuffer stringBuffer = new StringBuffer();
            //访问图片路径
            String fullPath = storePath.getFullPath();
            if (StringUtils.isNotEmpty(fullPath)) {
                Map<String, String> result = new HashMap<>();
                result.put(FDFS_URL, fullPath);
                result.put(FDFS_MSG, "图片上传成功!");
                result.put(FDFS_STATE, FDFS_SUCCESS_STATUS);
                result.put(FDFS_TITLE, originalFilename);
                result.put(DIMENSION, dimension);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return res;
        }
        return res;
    }

	/**
	 * 上传资料文件
	 * @return
	 */
	public Map<String,String> uploadDatumentFile(MultipartFile multipartFile) {
		Map<String, String> res = new HashMap<>();
		res.put(FDFS_STATE, FDFS_FAIL_STATUS);
		res.put(FDFS_MSG, "资料文件上传失败");
		try {
			//取文件扩展名
			String originalFilename = multipartFile.getOriginalFilename();

			StorePath storePath = defaultFastFileStorageClient.uploadFile(multipartFile.getInputStream(),
					multipartFile.getSize(), FilenameUtils.getExtension(originalFilename), null);
			//访问文件路径
			String fullPath = storePath.getFullPath();
			if (StringUtils.isNotEmpty(fullPath)) {
				Map<String, String> result = new HashMap<>();
				result.put(FDFS_URL, fullPath);       // 文件路径
				result.put(FDFS_MSG, "资料文件上传成功!");  // 提示信息
				result.put(FDFS_STATE, FDFS_SUCCESS_STATUS);   // 成功状态
				result.put(FDFS_TITLE, originalFilename);  // 文件名称
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return res;
		}
		return res;
	}



	/**
	 *
	* @Title: uploadImageAndCrtThumbImage
	* @Description: TODO(上传原图片&&缩略图)
	* @param @param multipartFile
	* @param @return    设定文件
	* @return Map<String,Object>    返回类型
	* @throws
	 */
	public Map<String,Object> uploadImageAndCrtThumbImage(MultipartFile multipartFile){
		Map<String,Object> res = new HashMap<>();
		res.put(FDFS_STATE, FDFS_FAIL_STATUS);
		res.put(FDFS_MSG, "图片上传失败");
  		try{
 			String originalFilename = multipartFile.getOriginalFilename();
   			StorePath storePath =  defaultFastFileStorageClient.uploadImageAndCrtThumbImage(multipartFile.getInputStream(),
					multipartFile.getSize(), FilenameUtils.getExtension(multipartFile.getOriginalFilename()), null);
			if(storePath != null){
  				//缩略图路径
				String thumburl = thumbImageConfig.getThumbImagePath(storePath.getFullPath());
				String url = storePath.getFullPath();
				res.put(FDFS_URL, url);
				res.put(FDFS_STATE, FDFS_SUCCESS_STATUS);
				res.put(FDFS_TITLE, originalFilename);
				res.put(FDFS_ORIGINAL, originalFilename);
				res.put(FDFS_THUMBURL, thumburl);
  				return res;
			}
			return res;
		}catch(Exception e){
			e.printStackTrace();
			return res;
		}
	}

	/**
	 *
	* @Title: uploadImageAndCrtThumbImage
	* @Description: TODO(上传原图片&&缩略图&&水印图)
	* @param @param multipartFile
	* @param @return    设定文件
	* @return Map<String,Object>    返回类型
	* @throws
	 */
	public Map<String,Object> uploadImageAndCrtThumbAndWaterImage(MultipartFile multipartFile){
		Map<String,Object> res = new HashMap<>();
		res.put(FDFS_STATE, FDFS_FAIL_STATUS);
		res.put(FDFS_MSG, "图片上传失败");
  		try{

 			String originalFilename = multipartFile.getOriginalFilename();
   			StorePath storePath =  defaultFastFileStorageClient.uploadImageAndCrtThumbImage(multipartFile.getInputStream(),
					multipartFile.getSize(), FilenameUtils.getExtension(multipartFile.getOriginalFilename()), null);
			if(storePath != null){
  				//缩略图路径
				String thumburl = thumbImageConfig.getThumbImagePath(storePath.getFullPath());
				StorePath waterStorePath = uploadWaterMark(storePath);//上传水印图
 				String url = storePath.getFullPath();
				res.put(FDFS_URL, url);
				res.put(FDFS_STATE, FDFS_SUCCESS_STATUS);
				res.put(FDFS_TITLE, originalFilename);
				res.put(FDFS_ORIGINAL, originalFilename);
				res.put(FDFS_THUMBURL, thumburl);
				res.put(FDFS_WATERMARKURL, waterStorePath.getFullPath());
  				return res;
			}
			return res;
		}catch(Exception e){
			e.printStackTrace();
			return res;
		}
	}

	/**
	 *
	* @Title: uploadWatermarkImage
	* @Description: TODO(上传水印图片)
	* @param @param StorePath
	* @param @return    设定文件
	* @return Map<String,Object>    返回类型
	* @throws
	 */
	public Map<String,Object> uploadWatermarkImage(StorePath storePath){
		Map<String,Object> res = new HashMap<>();
		res.put(FDFS_STATE, FDFS_FAIL_STATUS);
		res.put(FDFS_MSG, "水印图片上传失败");
		StorePath waterStorePath = uploadWaterMark(storePath);
		if(waterStorePath != null){
 			res.put(FDFS_URL, storePath.getFullPath());//原图路径
			res.put(FDFS_STATE, FDFS_SUCCESS_STATUS);
			res.put(FDFS_WATERMARKURL, waterStorePath.getFullPath());//水印图路径
			res.put(FDFS_MSG, "水印图片上传成功");
			return res;
		}
   		return res;
	}

	/**
	 *
	* @Title: uploadWaterMark
	* @Description: TODO(水印图片上传)
	* @param @param storePath
	* @param @return    设定文件
	* @return StorePath    返回类型
	* @throws
	 */
	private StorePath uploadWaterMark(StorePath storePath){
 		if(storePath == null){
			throw new IllegalArgumentException("水印图片上传 'StorePath' 不能为空");
		}

		try{
 			//获取原图路径
//			String srcImgURL = "http://image.wangdaibus.com/group1/M00/00/00/i8QHkFryrS2AfCTLAD8NwfEa8gU441.png";
 			String srcImgURL = this.hostUrl + storePath.getFullPath();
 			//水印图片
 			String srcIconURL = this.watermarkurl;
 			//获取网络图片
			URL url = new URL(srcImgURL);
			URL iconPathUrl = new URL(srcIconURL);

	        //打开链接
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
 	        //通过输入流获取图片数据
	        InputStream inStream = conn.getInputStream();
 			String srcImgName = storePath.getPath().substring(storePath.getPath().lastIndexOf("/")+1);
			//加水印后保存的图片地址
			String targerPath = getTempFilePath() + System.getProperty("file.separator") + "WaterMark_"+srcImgName;
 			//图片加水印
		    WaterMarkUtils.markImageAutoByIcon(iconPathUrl, url, targerPath, null);

			File WaterFileExtName = new File(targerPath);
			FileInputStream fileInputStream = null;
			StorePath waterStorePath = null;
			try {
				fileInputStream = FileUtils.openInputStream(WaterFileExtName);
 				//水印图片上传
				waterStorePath = defaultFastFileStorageClient.uploadFile(fileInputStream, WaterFileExtName.length(), FilenameUtils.getExtension(WaterFileExtName.getName()), null);
 				if(waterStorePath != null){
  					return waterStorePath;
 				}
			} catch (IOException e) {

				e.printStackTrace();

			}finally {

				if(fileInputStream != null){
					fileInputStream.close();
				}

				if(inStream != null){
					inStream.close();
				}
 			}

  		}catch(Exception e){
			e.printStackTrace();
		}

		return null;
	}



	/**
	 *
	* @Title: uploadWaterMark
	* @Description: TODO(水印图片上传)
	* @param @param storePath
	* @param @return    设定文件
	* @return StorePath    返回类型
	* @throws
	 *//*
	private StorePath uploadWaterMark2(StorePath storePath){
		if(storePath == null){
			throw new IllegalArgumentException("水印图片上传 'StorePath' 不能为空");
		}

		try{
			//获取原图路径
//			String srcImgURL = "http://image.wangdaibus.com/group1/M00/00/00/i8QHkFryrS2AfCTLAD8NwfEa8gU441.png";
			String srcImgURL = this.hostUrl + storePath.getFullPath();
			//获取网络图片
			URL url = new URL(srcImgURL);
	        //打开链接
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        //通过输入流获取图片数据
	        InputStream inStream = conn.getInputStream();
			String srcImgName = storePath.getPath().substring(storePath.getPath().lastIndexOf("/")+1);
			//加水印后保存的图片地址
			String targerPath = getTempFilePath() + System.getProperty("file.separator") + "WaterMark_"+srcImgName;
			String srcImgPath = getTempFilePath() + System.getProperty("file.separator") + srcImgName;
			File targerFile = new File(srcImgPath);
			FileUtils.copyInputStreamToFile(inStream, targerFile);
			//图片加水印
		    WaterMarkUtils.markImageAutoByIcon(FDFS_WATERMARK_LOGOIMG_PATH, srcImgPath, targerPath, null);

			File WaterFileExtName = new File(targerPath);
			FileInputStream fileInputStream = null;
			StorePath waterStorePath = null;
			try {
				fileInputStream = FileUtils.openInputStream(WaterFileExtName);
				//水印图片上传
				waterStorePath = defaultFastFileStorageClient.uploadFile(fileInputStream, WaterFileExtName.length(), FilenameUtils.getExtension(WaterFileExtName.getName()), null);
				if(waterStorePath != null){
 					return waterStorePath;
				}
			} catch (IOException e) {

				e.printStackTrace();

			}finally {

				if(fileInputStream != null){
					fileInputStream.close();
				}

				if(inStream != null){
					inStream.close();
				}
			}

 		}catch(Exception e){
			e.printStackTrace();
		}

		return null;
	}*/

	//获取系统临时目录
	private File getTempFilePath(){
		File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +  FDFS_TEMP_PATH  + System.getProperty("file.separator"));
		if(!tmpFile.exists()){
			tmpFile.mkdir();
		}
		return tmpFile;
	}

	// 封装图片完整URL地址
    public String getResAccessUrl(StorePath storePath) {
        String fileUrl = this.hostUrl+storePath.getFullPath();
        System.out.println(fileUrl);
        return fileUrl;
    }

     // 封装图片完整URL地址
    public String getResAccessUrl(String storePath) {
        String fileUrl = this.hostUrl+storePath;
        return fileUrl;
    }



}
