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
	 * Wrong number of columns �������ִ�������Ϊ
	 *  float[] columnWidths = {1f, 1f, 1f}; �������Ϊfloat[] columnWidths = {1f, 1f, 1f,1f};
	    table.setWidths(columnWidths);
	 * @param args
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void main(String[] args) throws DocumentException, IOException {
	        //�����ļ�
	        Document document = new Document();
	        //����һ����д��
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/file/test6.pdf"));
	        //PdfWriter.getInstance(document, new FileOutputStream("D:/file/test555.pdf"));
	        //���ļ�
	        document.open();
	        //�������
	        document.add(new Paragraph("HD content here"));
	     
	        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
	        Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
	        //Paragraph pragraph=new Paragraph("���", FontChinese); 
	        
	        // 6�еı�.
	        PdfPTable table = new PdfPTable(6); 
	        table.setWidthPercentage(80); // ���100%���
	        table.setSpacingBefore(5f); // ǰ���
	        table.setSpacingAfter(5f); // ����
	
	        List<PdfPRow> listRow = table.getRows();
	        //�����п�
	        float[] columnWidths = {1f,1f,1f,1f,1f,1f};
	        table.setWidths(columnWidths);
	        
	        //��1
	        PdfPCell cells1[]= new PdfPCell[6];
	        PdfPRow row1 = new PdfPRow(cells1);
	       
	        //��Ԫ��
	        cells1[0] = new PdfPCell(new Paragraph("���",FontChinese));//��Ԫ������
	        cells1[0].setBorderColor(BaseColor.BLACK);//�߿���֤
	        cells1[0].setPaddingLeft(20);//�����20
	        cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//ˮƽ����
	        cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//��ֱ����
	
	        cells1[1] = new PdfPCell(new Paragraph("����",FontChinese));
	        cells1[1].setBorderColor(BaseColor.BLACK);//�߿���֤
	        cells1[1].setPaddingLeft(20);//�����20
	        cells1[1].setHorizontalAlignment(Element.ALIGN_CENTER);//ˮƽ����
	        cells1[1].setVerticalAlignment(Element.ALIGN_MIDDLE);//��ֱ����
	        
	        cells1[2] = new PdfPCell(new Paragraph("����",FontChinese));
	        cells1[2].setBorderColor(BaseColor.BLACK);//�߿���֤
	        cells1[2].setPaddingLeft(20);//�����20
	        cells1[2].setHorizontalAlignment(Element.ALIGN_CENTER);//ˮƽ����
	        cells1[2].setVerticalAlignment(Element.ALIGN_MIDDLE);//��ֱ����
	        
	        cells1[3] = new PdfPCell(new Paragraph("����333",FontChinese));
	        cells1[3].setBorderColor(BaseColor.BLACK);//�߿���֤
	        cells1[3].setPaddingLeft(20);//�����20
	        cells1[3].setHorizontalAlignment(Element.ALIGN_CENTER);//ˮƽ����
	        cells1[3].setVerticalAlignment(Element.ALIGN_MIDDLE);//��ֱ����
	        
	        cells1[4] = new PdfPCell(new Paragraph("����444",FontChinese));
	        cells1[4].setBorderColor(BaseColor.BLACK);//�߿���֤
	        cells1[4].setPaddingLeft(20);//�����20
	        cells1[4].setHorizontalAlignment(Element.ALIGN_CENTER);//ˮƽ����
	        cells1[4].setVerticalAlignment(Element.ALIGN_MIDDLE);//��ֱ����
	        
	        cells1[5] = new PdfPCell(new Paragraph("����6666",FontChinese));
	        cells1[5].setBorderColor(BaseColor.BLACK);//�߿���֤
	        cells1[5].setPaddingLeft(20);//�����20
	        cells1[5].setHorizontalAlignment(Element.ALIGN_CENTER);//ˮƽ����
	        cells1[5].setVerticalAlignment(Element.ALIGN_MIDDLE);//��ֱ����
	        
	   
	        
	        //��2
	        PdfPCell cells2[]= new PdfPCell[6];
	        PdfPRow row2 = new PdfPRow(cells2);
	        cells2[0] = new PdfPCell(new Paragraph("444"));
	        cells2[0].setBorderColor(BaseColor.BLACK);//�߿���֤
	        cells2[0].setPaddingLeft(20);//�����20
	        cells2[0].setHorizontalAlignment(Element.ALIGN_CENTER);//ˮƽ����
	        cells2[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//��ֱ����
	        
	        cells2[1] = new PdfPCell(new Paragraph("555"));
	        cells2[2] = new PdfPCell(new Paragraph("666"));
	        cells2[3] = new PdfPCell(new Paragraph("777"));
	        cells2[4] = new PdfPCell(new Paragraph("888"));
	        cells2[5] = new PdfPCell(new Paragraph("999"));
	
	        //�ѵ�һ����ӵ�����
	        listRow.add(row1);
	        listRow.add(row2);
	        //�ѱ����ӵ��ļ���
	        document.add(table);
	        
	        //�ر��ĵ�
	        document.close();
	        //�ر���д��
	        writer.close();
	    }

	
}

