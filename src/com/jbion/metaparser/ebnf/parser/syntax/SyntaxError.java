package com.jbion.metaparser.ebnf.parser.syntax;

public class SyntaxError extends Exception {

	public SyntaxError(String message) {
		super(message);
	}
	
	public SyntaxError(Throwable cause) {
		super(cause);
	}
}
