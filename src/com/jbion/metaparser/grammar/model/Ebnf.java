package com.jbion.metaparser.grammar.model;

import com.jbion.metaparser.grammar.model.Grammar.*;

public class Ebnf {

	public static Grammar get() {
		Grammar ebnf = new Grammar();
		ebnf.rules.add(new SyntaxRule());

		// TODO build EBNF tree
		
		return ebnf;
	}

}
