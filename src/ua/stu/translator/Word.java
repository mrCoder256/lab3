package com.example.webservice;

import java.util.ArrayList;

public class Word {
	
	private String src;
	private ArrayList<String> translationList;
	
	public Word(String src, ArrayList<String> translationList) {
		this.src = src;
		this.translationList = translationList;
	}
}
