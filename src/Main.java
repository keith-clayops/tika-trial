//package Extractors;

public class Main {

    public static void main(String[] args){

        PDFExtractor extractor = new PDFExtractor();
        try {
            extractor.importPDF("test.pdf");
        } catch (Exception e) {
            System.out.println(("Failed: " + e.getMessage()));
        }
    }
}