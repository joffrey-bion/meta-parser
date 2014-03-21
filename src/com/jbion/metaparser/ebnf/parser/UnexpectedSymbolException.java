package com.jbion.metaparser.ebnf.parser;

public class UnexpectedSymbolException extends SyntaxError {

	public UnexpectedSymbolException(String readSymbol, String... expectedSymbols) {
		super("Unexpected symbol '" + readSymbol + "', expected " + getMessage(expectedSymbols));
	}

	private static String getMessage(String... expectedSymbols) {
		if (expectedSymbols.length == 0) {
			throw new IllegalArgumentException("No expected symbol.");
		}
		StringBuilder sb = new StringBuilder();
		if (expectedSymbols.length > 1) {
			sb.append("one of ");
		}
		String last = expectedSymbols[expectedSymbols.length - 1];
		String secondLast = null;
		if (expectedSymbols.length > 1) {
			secondLast = expectedSymbols[expectedSymbols.length - 2];
		}
		for (String symbol : expectedSymbols) {
			sb.append("'").append(symbol).append("'");
			if (!symbol.equals(last)) {
				if (!symbol.equals(secondLast)) {
					sb.append(", ");
				} else {
					sb.append(" or ");
				}
			}
		}
		return sb.toString();
	}

	public static void main (String[] args) {
		System.out.println(getMessage("bob","bib","bab","bub"));
		System.out.println(getMessage("bob","bib","bab"));
		System.out.println(getMessage("bob","bib"));
		System.out.println(getMessage("bob"));
	}
}