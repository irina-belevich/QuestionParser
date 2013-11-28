package com.parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class FileReader implements IFileReader{

        @Override
        public Document readContentAsXML(String path) throws Exception {
        	
        	Document document = null;
        	
        	try {
        		
	        	File xmlFile = new File(path);
	        	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        	document = dBuilder.parse(xmlFile);
	        	document.getDocumentElement().normalize();
	        	return document;
        	} 
        	catch (Exception e) {
        		throw new Exception("Read failed", e);
        	}
       }
        
}

interface IFileReader {
        Document readContentAsXML(String path) throws Exception;
}