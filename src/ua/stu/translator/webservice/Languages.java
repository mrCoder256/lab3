package ua.stu.translator.webservice;

public enum Languages {
	EN,
	RU,
	UA,
	DE,
	FR,
	ES,
	PL;
	
	public static String[] getArray(){
		String[] langs = new String[] {
			"EN",
			"RU",
			"UA",
			"DE",
			"FR",
			"ES",
			"PL"				
		};
		return langs;
	}
}	
