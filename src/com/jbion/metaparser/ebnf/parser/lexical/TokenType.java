package com.jbion.metaparser.ebnf.parser.lexical;

public enum TokenType {

	DEFINING_SYMBOL("="),
	FIRST_QUOTE_SYMBOL("'"),
	SECOND_QUOTE_SYMBOL("\""),
	CONCATENATE_SYMBOL(","),
	REPETITION_SYMBOL("*"),
	DEFINITION_SEPARATOR_SYMBOL("|", "/", "!"),
	START_COMMENT_SYMBOL("(*"),
	END_COMMENT_SYMBOL("*)"),
	START_GROUP_SYMBOL("("),
	END_GROUP_SYMBOL(")"),
	START_OPTION_SYMBOL("[", "(/"),
	END_OPTION_SYMBOL("]", "/)"),
	START_REPEAT_SYMBOL("{", "(:"),
	END_REPEAT_SYMBOL("}", ":)"),
	EXCEPT_SYMBOL("-"),
	SPECIAL_SEQUENCE_SYMBOL("?"),
	TERMINATOR_SYMBOL(";", "."),

	OTHER_CHARACTER(" ", ":", "+", "_", "%", "@", "&", "#", "$", "<", ">", "\\", "^", "`", "~"),

	SPACE_CHARACTER(" "),
	HORIZONTAL_TABULATION_CHARACTER("\t"),
	NEW_LINE("\r", "\r\n", "\n");

	private String[] representations;

	private TokenType(String... representations) {
		this.representations = representations;
	}
	
	public String[] getRepresentations() {
		return representations;
	}
}
