package org.example.example;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfModify {
    public static void main(String[] args) throws IOException, DocumentException {

//        String inputPath="C:\\Users\\dell\\Downloads\\sample.pdf";
//        String outputPath="C:\\Users\\dell\\Downloads\\modifySample.pdf";
//        OutputStream fo=new FileOutputStream(new File(outputPath));
//        PdfReader pdfReader=new PdfReader(inputPath);
//        PdfStamper pdfStamper= new PdfStamper(pdfReader,fo);
//        for(int i=0;i<=pdfReader.getNumberOfPages();i++){
//
//            Paragraph rightAlignedParagraph= new Paragraph("This paragraph is right aligned in PDF.");
//            rightAlignedParagraph.setAlignment(Element.ALIGN_RIGHT);
//
//            PdfContentByte pdfContentByte= pdfStamper.getOverContent(i);
//            pdfContentByte.showText(rightAlignedParagraph);
//            pdfContentByte.endText();

        PdfReader pdfReader =
                new PdfReader("C:\\Users\\dell\\Downloads\\sample.pdf");

        //Create PdfStamper instance.
        PdfStamper pdfStamper = new PdfStamper(pdfReader,
                new FileOutputStream("C:\\Users\\dell\\Downloads\\sample2.pdf"));
        BaseFont baseFont = BaseFont.createFont(
                BaseFont.TIMES_ROMAN,
                BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            PdfContentByte pageContentByte =
                    pdfStamper.getOverContent(1);
            pageContentByte.beginText();
            pageContentByte.setFontAndSize(baseFont, 14);
            pageContentByte.setTextMatrix(500, 740);
            pageContentByte.showText("Additionally");
            pageContentByte.endText();
            pdfStamper.close();


    }
    }

