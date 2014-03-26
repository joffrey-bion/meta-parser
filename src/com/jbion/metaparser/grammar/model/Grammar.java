package com.jbion.metaparser.grammar.model;

import java.util.LinkedList;

public class Grammar {

	LinkedList<SyntaxRule> rules;

	public Grammar() {
		rules = new LinkedList<>();
	}

	public static class SyntaxRule {
		MetaIdentifier metaIdentifier;
		LinkedList<Definition> definitions;
	}

	public static interface Parseable {
		public boolean potentiallyMatches(String s);
	}

	public static class Definition {
		LinkedList<SyntacticTerm> terms;
	}

	public static class SyntacticTerm {
		SyntacticFactor factor;
		SyntacticFactor exception;
	}

	public static class SyntacticFactor {
		Integer repeat;
		SyntacticPrimary primary;
	}

	public static class SyntacticPrimary {
	}

	public static class MetaIdentifier extends SyntacticPrimary {
		String value;
	}

	public static class TerminalString extends SyntacticPrimary {
		String value;
	}

	public static abstract class AbstractSequence extends SyntacticPrimary {
		LinkedList<Definition> definitions;
	}

	public static class OptionalSequence extends AbstractSequence {
	}

	public static class RepeatedSequence extends AbstractSequence {
	}

	public static class GroupedSequence extends AbstractSequence {
	}

	public static class EmptySequence extends AbstractSequence {
	}

	public static class SpecialSequence /* not an AbstractSequence */ {
	}
}
