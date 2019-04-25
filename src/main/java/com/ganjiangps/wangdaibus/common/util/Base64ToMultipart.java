package com.ganjiangps.wangdaibus.common.util;


import org.apache.commons.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

public class Base64ToMultipart {

	@SuppressWarnings("static-access")
	public static MultipartFile base64ToMultipart(String base64) {
	    String[] baseStrs = base64.split(",");

		//BASE64Decoder decoder = new BASE64Decoder();
		//Decoder decoder2 =  Base64.getDecoder();
	    Base64 base642 = new Base64();
		byte[] b = new byte[0];
		b = base642.decodeBase64(baseStrs[1]);
 		//decoder2.decode(baseStrs[1]);
		for(int i = 0; i < b.length; ++i) {
		    if (b[i] < 0) {
		        b[i] += 256;
		    }
		}

		return new BASE64DecodedMultipartFile(b, baseStrs[0]);
	}
}
