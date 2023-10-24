/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_hamdi;

/**
 *
 * @author Hamdi
 */import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class pdf {
    public static void generateRestaurantPDF(List<Restaurant> restaurantList, String outputPath) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Set the font and position for your content
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER), 12);
            float yPosition = page.getMediaBox().getHeight() - 50;

            for (Restaurant restaurant : restaurantList) {
                contentStream.beginText();
                contentStream.newLineAtOffset(50, yPosition);
                contentStream.showText("Restaurant Name: " + restaurant.getNom());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Location: " + restaurant.getlocation());
                contentStream.endText();

                yPosition -= 50;
            }

            contentStream.close();

            document.save(new File(outputPath));
            document.close();

            System.out.println("Restaurant data has been written to PDF file: " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


