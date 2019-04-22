package com.walmart.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfUtils {
	/**
	 * Wrong number of columns 出现这种错误是因为
	 *  float[] columnWidths = {1f, 1f, 1f}; 把这个改为float[] columnWidths = {1f, 1f, 1f,1f};
	    table.setWidths(columnWidths);
	 * @param args
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void main(String[] args) throws DocumentException, IOException {
	        //创建文件
	        Document document = new Document();
	        //建立一个书写器
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/file/test6.pdf"));
	        //PdfWriter.getInstance(document, new FileOutputStream("D:/file/test555.pdf"));
	        //打开文件
	        document.open();
	        //添加内容
	        document.add(new Paragraph("HD content here"));
	     
	        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
	        Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
	        //Paragraph pragraph=new Paragraph("你好", FontChinese); 
	        
	        // 6列的表.
	        PdfPTable table = new PdfPTable(6); 
	        table.setWidthPercentage(80); // 宽度100%填充
	        table.setSpacingBefore(5f); // 前间距
	        table.setSpacingAfter(5f); // 后间距
	
	        List<PdfPRow> listRow = table.getRows();
	        //设置列宽
	        float[] columnWidths = {1f,1f,1f,1f,1f,1f};
	        table.setWidths(columnWidths);
	        
	        //行1
	        PdfPCell cells1[]= new PdfPCell[6];
	        PdfPRow row1 = new PdfPRow(cells1);
	       
	        //单元格
	        cells1[0] = new PdfPCell(new Paragraph("你好",FontChinese));//单元格内容
	        cells1[0].setBorderColor(BaseColor.BLACK);//边框验证
	        cells1[0].setPaddingLeft(20);//左填充20
	        cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
	        cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
	
	        cells1[1] = new PdfPCell(new Paragraph("哈哈",FontChinese));
	        cells1[1].setBorderColor(BaseColor.BLACK);//边框验证
	        cells1[1].setPaddingLeft(20);//左填充20
	        cells1[1].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
	        cells1[1].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
	        
	        cells1[2] = new PdfPCell(new Paragraph("姓名",FontChinese));
	        cells1[2].setBorderColor(BaseColor.BLACK);//边框验证
	        cells1[2].setPaddingLeft(20);//左填充20
	        cells1[2].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
	        cells1[2].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
	        
	        cells1[3] = new PdfPCell(new Paragraph("姓名333",FontChinese));
	        cells1[3].setBorderColor(BaseColor.BLACK);//边框验证
	        cells1[3].setPaddingLeft(20);//左填充20
	        cells1[3].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
	        cells1[3].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
	        
	        cells1[4] = new PdfPCell(new Paragraph("姓名444",FontChinese));
	        cells1[4].setBorderColor(BaseColor.BLACK);//边框验证
	        cells1[4].setPaddingLeft(20);//左填充20
	        cells1[4].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
	        cells1[4].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
	        
	        cells1[5] = new PdfPCell(new Paragraph("姓名6666",FontChinese));
	        cells1[5].setBorderColor(BaseColor.BLACK);//边框验证
	        cells1[5].setPaddingLeft(20);//左填充20
	        cells1[5].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
	        cells1[5].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
	        
	   
	        
	        //行2
	        PdfPCell cells2[]= new PdfPCell[6];
	        PdfPRow row2 = new PdfPRow(cells2);
	        cells2[0] = new PdfPCell(new Paragraph("444"));
	        cells2[0].setBorderColor(BaseColor.BLACK);//边框验证
	        cells2[0].setPaddingLeft(20);//左填充20
	        cells2[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
	        cells2[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
	        
	        cells2[1] = new PdfPCell(new Paragraph("555"));
	        cells2[2] = new PdfPCell(new Paragraph("666"));
	        cells2[3] = new PdfPCell(new Paragraph("777"));
	        cells2[4] = new PdfPCell(new Paragraph("888"));
	        cells2[5] = new PdfPCell(new Paragraph("999"));
	
	        //把第一行添加到集合
	        listRow.add(row1);
	        listRow.add(row2);
	        //把表格添加到文件中
	        document.add(table);
	        
	        //关闭文档
	        document.close();
	        //关闭书写器
	        writer.close();
	    }

	
}

