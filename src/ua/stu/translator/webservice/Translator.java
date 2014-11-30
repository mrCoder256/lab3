package ua.stu.translator.webservice;

public class Translator {
	public static Word translate(String word, Languages from, Languages to) {
		TranslatorThread thread = new TranslatorThread(word, from, to);
		thread.start();
		return null;
	}
}
