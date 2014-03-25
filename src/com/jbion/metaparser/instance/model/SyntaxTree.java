package com.jbion.metaparser.instance.model;

import java.util.LinkedList;

public class SyntaxTree {

	private LinkedList<SyntaxTree> children;
	private String leafValue;

	public SyntaxTree() {
		children = new LinkedList<>();
		leafValue = null;
	}

	public SyntaxTree(String value) {
		leafValue = value;
	}

	public boolean isLeaf() {
		return leafValue != null;
	}

	/**
	 * Adds a child to this {@link SyntaxTree}.
	 * 
	 * @param child
	 *            The {@link SyntaxTree} to add as a child
	 * @return The child {@link SyntaxTree} that has just been added.
	 */
	public SyntaxTree addChild(SyntaxTree child) {
		children.add(child);
		leafValue = null;
		return child;
	}

	/**
	 * Creates a new {@link SyntaxTree} and adds it to this {@link SyntaxTree} as a
	 * child.
	 * 
	 * @return The created child.
	 */
	public SyntaxTree newChild() {
		SyntaxTree child = new SyntaxTree();
		children.add(child);
		leafValue = null;
		return child;
	}

	public void setValue(String value) {
		leafValue = value;
	}

}
