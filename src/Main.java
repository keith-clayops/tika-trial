import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        PDFExtractor extractor = new PDFExtractor();
        try {
            extractor.importPDF(filename);
        } catch (Exception e) {
            System.out.println(("Failed: " + e.getMessage()));
        }
    }
}