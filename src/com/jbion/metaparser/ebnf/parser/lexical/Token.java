package com.jbion.metaparser.ebnf.parser.lexical;

import java.util.LinkedList;
import java.util.List;

public class Token {

	public static final Token DEFINING_SYMBOL = new Token("=");
	public static final Token FIRST_QUOTE_SYMBOL = new Token("'");
	public static final Token SECOND_QUOTE_SYMBOL = new Token("\"");
	public static final Token CONCATENATE_SYMBOL = new Token(",");
	public static final Token REPETITION_SYMBOL = new Token("*");
	public static final Token DEFINITION_SEPARATOR_SYMBOL = new Token("|", "/", "!");
	public static final Token START_COMMENT_SYMBOL = new Token("(*");
	public static final Token END_COMMENT_SYMBOL = new Token("*)");
	public static final Token START_GROUP_SYMBOL = new Token("(");
	public static final Token END_GROUP_SYMBOL = new Token(")");
	public static final Token START_OPTION_SYMBOL = new Token("[", "(/");
	public static final Token END_OPTION_SYMBOL = new Token("]", "/)");
	public static final Token START_REPEAT_SYMBOL = new Token("{", "(:");
	public static final Token END_REPEAT_SYMBOL = new Token("}", ":)");
	public static final Token EXCEPT_SYMBOL = new Token("-");
	public static final Token SPECIAL_SEQUENCE_SYMBOL = new Token("?");
	public static final Token TERMINATOR_SYMBOL = new Token(";", ".");

	public static final Token OTHER_CHARACTER = new Token(" ", ":", "+", "_", "%", "@", "&", "#", "$", "<", ">", "\\",
			"^", "`", "~");

	public static final Token SPACE_CHARACTER = new Token(" ");
	public static final Token HORIZONTAL_TABULATION_CHARACTER = new Token("\t");
	public static final Token NEW_LINE = new Token("\r", "\r\n", "\n");

	public static final Token META_IDENTIFIER = new Token(""); // TODO

	private String[] representations;
	private String regexp;

	private Token(String regexp) {
		this.regexp = regexp;
	}

	private Token(String... representations) {
		this.representations = representations;
	}

	public static Token create(String s) {
		// TODO
		return null;
	}

	public static int countMatchingTokens(String s) {
		// TODO
		return 0;
	}
}
