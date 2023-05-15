package org.example.example;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\dell\\Downloads\\sample.pdf"));
            PDPage pae = new PDPage();
            document.open();
            Paragraph rightAlignedParagraph = new Paragraph("This paragraph is right aligned in PDF.");
            rightAlignedParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(rightAlignedParagraph);
            document.close();

            //this is create new pdf file
//            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//            Chunk chunk = new Chunk("Hello World", font);
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
//            document.open();
//            document.add(new Paragraph(rightAlignedParagraph));
//            document.close();
//            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}