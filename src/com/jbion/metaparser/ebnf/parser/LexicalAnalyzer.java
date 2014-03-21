package com.jbion.metaparser.ebnf.parser;

import java.io.IOException;

import com.jbion.utils.io.UnicodeReader;

public class LexicalAnalyzer {

	private static final String DEFINING_SYMBOL = "=";
	private static final String FIRST_QUOTE_SYMBOL = "'";
	private static final String SECOND_QUOTE_SYMBOL = "\"";
	private static final String CONCATENATE_SYMBOL = ",";
	private static final String REPETITION_SYMBOL = "*";
	private static final String DEFINITION_SEPARATOR_SYMBOL_1 = "|";
	private static final String DEFINITION_SEPARATOR_SYMBOL_2 = "/";
	private static final String DEFINITION_SEPARATOR_SYMBOL_3 = "!";
	private static final String START_COMMENT_SYMBOL = "(*";
	private static final String END_COMMENT_SYMBOL = "*)";
	private static final String START_GROUP_SYMBOL = "(";
	private static final String END_GROUP_SYMBOL = ")";
	private static final String START_OPTION_SYMBOL_1 = "[";
	private static final String START_OPTION_SYMBOL_2 = "(/";
	private static final String END_OPTION_SYMBOL_1 = "]";
	private static final String END_OPTION_SYMBOL_2 = "/)";
	private static final String START_REPEAT_SYMBOL_1 = "{";
	private static final String START_REPEAT_SYMBOL_2 = "(:";
	private static final String END_REPEAT_SYMBOL_1 = "}";
	private static final String END_REPEAT_SYMBOL_2 = ":)";
	private static final String EXCEPT_SYMBOL = "-";
	private static final String SPECIAL_SEQUENCE_SYMBOL = "?";
	private static final String TERMINATOR_SYMBOL_1 = ";";
	private static final String TERMINATOR_SYMBOL_2 = ".";

	private UnicodeReader reader;

	public LexicalAnalyzer(String filename) throws IOException {
		reader = new UnicodeReader(filename);
	}

	/**
	 * Reads characters from the file and ensures they correspond to one of the
	 * specified {@code String}s.
	 * 
	 * @param options
	 *            The {@code String}s to check in the file.
	 * @throws IllegalStateException
	 *             If the characters read in the file do not correspond to any of the
	 *             specified {@code String}s.
	 */
	private void ensure(String... options) throws UnexpectedSymbolException {
		// TODO
	}
	
	public void letter() {
		// TODO
	}
	
	public void decimalDigit() {
		// TODO
	}

	public void definingSymbol() throws UnexpectedSymbolException {
		ensure(DEFINING_SYMBOL);
	}

	public void firstQuoteSymbol() throws UnexpectedSymbolException {
		ensure(FIRST_QUOTE_SYMBOL);
	}

	public void secondQuoteSymbol() throws UnexpectedSymbolException {
		ensure(SECOND_QUOTE_SYMBOL);
	}

	public void concatenateSymbol() throws UnexpectedSymbolException {
		ensure(CONCATENATE_SYMBOL);
	}

	public void repetitionSymbol() throws UnexpectedSymbolException {
		ensure(REPETITION_SYMBOL);
	}

	public void definitionSeparatorSymbol() throws UnexpectedSymbolException {
		ensure(DEFINITION_SEPARATOR_SYMBOL_1, DEFINITION_SEPARATOR_SYMBOL_2, DEFINITION_SEPARATOR_SYMBOL_3);
	}

	public void startCommentSymbol() throws UnexpectedSymbolException {
		ensure(START_COMMENT_SYMBOL);
	}

	public void endCommentSymbol() throws UnexpectedSymbolException {
		ensure(END_COMMENT_SYMBOL);
	}

	public void startGroupSymbol() throws UnexpectedSymbolException {
		ensure(START_GROUP_SYMBOL);
	}

	public void endGroupSymbol() throws UnexpectedSymbolException {
		ensure(END_GROUP_SYMBOL);
	}

	public void startOptionSymbol() throws UnexpectedSymbolException {
		ensure(START_OPTION_SYMBOL_1, START_OPTION_SYMBOL_2);
	}

	public void endOptionSymbol() throws UnexpectedSymbolException {
		ensure(END_OPTION_SYMBOL_1, END_OPTION_SYMBOL_2);
	}

	public void startRepeatSymbol() throws UnexpectedSymbolException {
		ensure(START_REPEAT_SYMBOL_1, START_REPEAT_SYMBOL_2);
	}

	public void endRepeatSymbol() throws UnexpectedSymbolException {
		ensure(END_REPEAT_SYMBOL_1, END_REPEAT_SYMBOL_2);
	}

	public void exceptSymbol() throws UnexpectedSymbolException {
		ensure(EXCEPT_SYMBOL);
	}

	public void specialSequenceSymbol() throws UnexpectedSymbolException {
		ensure(SPECIAL_SEQUENCE_SYMBOL);
	}

	public void terminatorSymbol() throws UnexpectedSymbolException {
		ensure(TERMINATOR_SYMBOL_1, TERMINATOR_SYMBOL_2);
	}

	public void metaIdentifier() {
		// TODO 
	}

	public void terminalString() {
		// TODO 
	}

	public void integer() {
		// TODO 
	}
}
