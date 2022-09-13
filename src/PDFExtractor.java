//package Extractors;

// File handling

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Datatype for returning metadata
import java.util.HashMap;
import java.util.Map;

// Tika components
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

// Exception handling
import org.xml.sax.SAXException;

public class PDFExtractor {

    // Initial handlers and context, BodyContentHandler argument shows limit, -1 is unlimited
    BodyContentHandler handler = new BodyContentHandler(-1);
    Metadata metadata = new Metadata();
    ParseContext pcontext = new ParseContext();
    FileInputStream inputstream;
    PDFParser pdfparser = new PDFParser();

    // Void constructor to initialise requisite components
    public void PDFExtractor() {

    }

    // Takes filepath as input and tries to open and extract the file
    public void importPDF(String filepath) {
        try {
            inputstream = new FileInputStream(new File(filepath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            pdfparser.parse(inputstream, handler, metadata, pcontext);
            // For testing purposes, will be replaced by getDocumentText in practice
            System.out.println(handler.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }
    }

    // Returns the document text
    public String getDocumentText(){
        return handler.toString();
    }

    // Returns document metadata
    public Map<String,String> getMetadata(){
        String[] metadatanames = metadata.names();
        Map<String,String> metamap = new HashMap<>();
        for (String name: metadatanames) {
            metamap.put(name, metadata.get(name));
        }
        return metamap;
    }
}