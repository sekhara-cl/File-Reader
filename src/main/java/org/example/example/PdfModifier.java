package org.example.example;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfModifier {
    public static void main(String[] args) throws IOException, DocumentException {
        PdfReader reader=new PdfReader("C:\\Users\\dell\\Downloads\\sample.pdf");
        PdfStamper stamper= new PdfStamper(reader,new FileOutputStream("C:\\Users\\dell\\Downloads\\sample10.pdf"));
        PdfContentByte c=stamper.getOverContent(1);
        c.beginText();
        c.setFontAndSize(BaseFont.createFont(),15);
        c.showTextAligned(Element.ALIGN_RIGHT,"hello",500,750,0);
        c.endText();
        stamper.close();
        reader.close();
    }
}
