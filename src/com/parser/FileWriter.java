package com.parser;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.List;

import org.w3c.dom.NodeList;

public class FileWriter implements IFileWriter {

        @Override
        public void writeDataToFile(List<QuestionData> data, String path) throws Exception {
               
	        try {
	        	
		        PrintWriter out = new PrintWriter(path, "utf-8");
	        
		        for (QuestionData qd : data)
		        	out.println(qd.toString());
		        out.close();
	        } 
	        catch (Exception e) {
	        	throw new Exception("Write failed");
	        }
        }

}

interface IFileWriter {
        void writeDataToFile (List<QuestionData> data, String path) throws Exception;
}
