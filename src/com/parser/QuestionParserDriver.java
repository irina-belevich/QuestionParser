package com.parser;

import java.util.List;
import java.util.Scanner;

import org.w3c.dom.Document;

public class QuestionParserDriver {

        /**
         * @param args
         */
        public static void main(String[] args) {
                
        	try {
        		
        		Scanner scanner = new Scanner(System.in);
        		String initialPath = scanner.nextLine();
        		scanner.close();
        		
                IFileReader fileReader = new FileReader();
                Document document = fileReader.readContentAsXML(initialPath);
                
                IDocumentParser documentParser = new Parser();
                List<QuestionData> data = documentParser.parseQuestionsFromDocument(document);
                
                String path = initialPath.replace(".xml", ".txt");
                IFileWriter fileWriter = new FileWriter();
                fileWriter.writeDataToFile(data, path);
                
                System.out.println(String.format("\n%s questions have been saved to %s", data.size(), path));
        	} 
        	catch (Exception e) {
        		e.printStackTrace();
        	}
        }

}