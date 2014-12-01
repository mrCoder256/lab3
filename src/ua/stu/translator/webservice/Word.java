package ua.stu.translator.webservice;

import java.util.ArrayList;

public class Word {
	
	private String src;
	public ArrayList<String> translationList;
	
	public Word(String src, ArrayList<String> translationList) {
		this.src = src;
		this.translationList = translationList;
	}
}
