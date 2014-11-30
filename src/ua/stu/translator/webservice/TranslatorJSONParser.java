package ua.stu.translator.webservice;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TranslatorJSONParser {

	public static Word parseTranslations(String src, String response) {
		Word word = null;
		JSONObject jsonResponse;
		ArrayList<String> translationList = new ArrayList<String>();
		
		try {
			jsonResponse = new JSONObject(response);
			JSONArray defArray = jsonResponse.getJSONArray("def");
			JSONObject defObj = (JSONObject) defArray.get(0);
			
			JSONArray trArray = defObj.getJSONArray("tr");
			JSONObject trObj = (JSONObject) trArray.get(0);
			translationList.add(trObj.getString("text"));
			
			JSONArray synArray = trObj.getJSONArray("syn");
			for (int i = 0; i < synArray.length(); i++) {
				JSONObject synObj = (JSONObject) synArray.get(i);
				translationList.add(synObj.getString("text"));
			}
			word = new Word(src, translationList);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return word;
	} 
	
	
}
