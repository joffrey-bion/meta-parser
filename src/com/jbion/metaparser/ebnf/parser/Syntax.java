package com.jbion.metaparser.ebnf.parser;

import java.io.IOException;

import com.jbion.metaparser.ebnf.parser.lexical.LexicalAnalyzer;
import com.jbion.metaparser.grammar.model.SyntaxTree;

public class Syntax {

	private LexicalAnalyzer lex;

	public static SyntaxTree parse(String filename) throws IOException, SyntaxError {
		SyntaxTree tree = new SyntaxTree();
		new Syntax(filename).syntaxRuleList(tree);
		return tree;
	}

	private Syntax(String filename) throws IOException {
		lex = new LexicalAnalyzer(filename);
	}

	private void syntaxRuleList(SyntaxTree tree) throws SyntaxError {
		syntaxRule(tree.newChild());
		// TODO repetition
		syntaxRule(tree.newChild());
	}

	private void syntaxRule(SyntaxTree tree) throws SyntaxError {
		try {
			lex.metaIdentifier();
			lex.definingSymbol();
			definitionsList(tree.newChild());
			lex.terminatorSymbol();
		} catch (UnexpectedSymbolException e) {
			throw new SyntaxError(e);
		}
	}

	private void definitionsList(SyntaxTree tree) throws SyntaxError {
		singleDefinition(tree.newChild());
		// TODO repetition
		singleDefinition(tree.newChild());
	}

	private void singleDefinition(SyntaxTree tree) throws SyntaxError {
		syntacticTerm(tree.newChild());
		// TODO repetition
		syntacticTerm(tree.newChild());
	}

	private void syntacticTerm(SyntaxTree tree) throws SyntaxError {
		try {
			syntacticFactor(tree.newChild());
			// TODO optional
			lex.exceptSymbol();
			syntacticException(tree.newChild());
		} catch (UnexpectedSymbolException e) {
			throw new SyntaxError(e);
		}
	}

	private void syntacticException(SyntaxTree tree) throws SyntaxError {
		// TODO find something to check infinite recursion
		syntacticFactor(tree.newChild());
	}

	private void syntacticFactor(SyntaxTree tree) throws SyntaxError {
		try {
			// TODO optional
			lex.integer();
			lex.repetitionSymbol();

			syntacticPrimary(tree.newChild());
		} catch (UnexpectedSymbolException e) {
			throw new SyntaxError(e);
		}
	}

	private void syntacticPrimary(SyntaxTree tree) throws SyntaxError {
		try {
			// TODO choice
			optionalSequence(tree.newChild());
			repeatedSequence(tree.newChild());
			groupedSequence(tree.newChild());
			lex.metaIdentifier();
			lex.terminalString();
			specialSequence(tree.newChild());
			emptySequence(tree.newChild());
		} catch (UnexpectedSymbolException e) {
			throw new SyntaxError(e);
		}
	}

	private void optionalSequence(SyntaxTree tree) throws SyntaxError {
		try {
			lex.startOptionSymbol();
			definitionsList(tree.newChild());
			lex.endOptionSymbol();
		} catch (UnexpectedSymbolException e) {
			throw new SyntaxError(e);
		}
	}

	private void repeatedSequence(SyntaxTree tree) throws SyntaxError {
		try {
			lex.startRepeatSymbol();
			definitionsList(tree.newChild());
			lex.endRepeatSymbol();
		} catch (UnexpectedSymbolException e) {
			throw new SyntaxError(e);
		}
	}

	private void groupedSequence(SyntaxTree tree) throws SyntaxError {
		try {
			lex.startGroupSymbol();
			definitionsList(tree.newChild());
			lex.endGroupSymbol();
		} catch (UnexpectedSymbolException e) {
			throw new SyntaxError(e);
		}
	}

	private void specialSequence(SyntaxTree tree) throws SyntaxError {
		try {
			lex.specialSequenceSymbol();
			definitionsList(tree.newChild());
			lex.specialSequenceSymbol();
		} catch (UnexpectedSymbolException e) {
			throw new SyntaxError(e);
		}
	}

	private void emptySequence(SyntaxTree tree) {}
}
