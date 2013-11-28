package com.parser;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Parser implements IDocumentParser{
        public List<QuestionData> parseQuestionsFromDocument (Document document) throws Exception {

        	try {
        		
	        	XPath xpath = XPathFactory.newInstance().newXPath();
	        	String parsedExpression =  "//QuestionBlock/Content/PlainText/text()";
	        	XPathExpression expression = xpath.compile(parsedExpression);
	        	Object result = expression.evaluate(document, XPathConstants.NODESET);
	        	NodeList nodes = (NodeList) result;
	        	List<QuestionData> listQuestionData = new ArrayList<QuestionData>();
	        	
	        	 for (int i = 0; i < nodes.getLength(); i++) {  
	        		 QuestionData questionData = new QuestionData();
	        		 questionData.setNumber(i+1);
	        		 questionData.setQuestionText(nodes.item(i).getNodeValue());
	        		 listQuestionData.add(questionData);        		 
	        	 }
	        	 
	        	return  listQuestionData;
        	
        	}
        	catch (Exception e) {
        		throw new Exception("Parsing failed", e);
        	}
        }
}

interface IDocumentParser {
        List<QuestionData> parseQuestionsFromDocument (Document document) throws Exception;
}