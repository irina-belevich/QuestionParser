package com.parser;

import javax.xml.xpath.XPath;

public class QuestionData {

	private int _number;
	private String _questionText;
	
	public int getNumber () { return _number; }
	public void setNumber (int number) { _number = number; }
	
	public String getQuestionText () { return _questionText; }
	public void setQuestionText (String questionText) { _questionText = questionText; }
	
	public String toString () {
		String result = String.format("%s: %s", getNumber(), getQuestionText());
		return result;
	}
}
