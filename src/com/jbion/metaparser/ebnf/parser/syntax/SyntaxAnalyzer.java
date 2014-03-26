package com.jbion.metaparser.ebnf.parser.syntax;

import java.io.IOException;

import com.jbion.metaparser.ebnf.parser.lexical.LexicalAnalyzer;
import com.jbion.metaparser.instance.model.SyntaxTree;

public class SyntaxAnalyzer {

	private LexicalAnalyzer lex;

	public static SyntaxTree parse(String filename) throws IOException, SyntaxError {
		SyntaxTree tree = new SyntaxTree();
		new SyntaxAnalyzer(filename).getTree(tree);
		return tree;
	}

	private SyntaxAnalyzer(String filename) throws IOException {
		lex = new LexicalAnalyzer(filename);
	}

	private void getTree(SyntaxTree tree) {
		
	}
}
