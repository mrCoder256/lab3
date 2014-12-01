package com.example.webservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TranslatorThread extends Thread  {
	
	private String word;
	private Languages from;
	private Languages to;
	
	public TranslatorThread(String word, Languages from, Languages to) {
		this.word = word;
		this.from = from;
		this.to = to;
	}
	
	private static String KEY = "dict.1.1.20141130T194438Z.58176e1be38fef49.e9900a7fbf01f8be37623d4e756726d7d4ca313b";
	private static String URL = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=%s&lang=%s-%s&text=%s";
	
	private String substitute() {
		return String.format(URL, KEY, Languages.values()[from.ordinal()], Languages.values()[to.ordinal()], word);
	}
	
	public void run() {
		
		try {
			String req = substitute();
			URL obj = new URL(req);
			HttpURLConnection con = null;
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = null;
				in = new BufferedReader(
				        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			// Result
			Word w = TranslatorJSONParser.parseTranslations(word, response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
}
