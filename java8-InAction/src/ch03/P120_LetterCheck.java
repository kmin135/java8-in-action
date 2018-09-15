package ch03;

import java.util.function.Function;

public class P120_LetterCheck {
	
	public static void main(String[] args) {
		String originText = "Hello, Lambda";
		Function<String, String> addHeader = Letter::addHeader;
		
		String resultText = addHeader.andThen(Letter::addFooter).andThen(Letter::checkSpelling).apply(originText);
		System.out.println(resultText);
	}

	private static class Letter {
		public static String addHeader(String text) {
			return String.format("From bob\n%s", text);
		}
		public static String addFooter(String text) {
			return String.format("%s\nKind Regards", text);
		}
		public static String checkSpelling(String text) {
			return text.replaceAll("labda", "lambda");
		}
	}
}
