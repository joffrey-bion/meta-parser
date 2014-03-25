package com.jbion.metaparser.ebnf.parser.lexical;

import java.io.IOException;
import java.util.List;

import com.jbion.metaparser.ebnf.parser.UnexpectedSymbolException;
import com.jbion.utils.io.UnicodeReader;

public class LexicalAnalyzer extends UnicodeReader {

	public LexicalAnalyzer(String filename) throws IOException {
		super(filename);
	}

	/**
	 * Reads the next {@link Token} and returns it.
	 * 
	 * @return the next {@link Token} read from the file, or {@code null} if the end
	 *         of the stream has been reached.
	 * @throws LexicalError
	 *             If the next characters do not match any {@link Token}.
	 * @throws IOException
	 *             If an I/O error occurs when attempting to read the file.
	 */
	public Token readToken() throws LexicalError, IOException {
		skipSpaces();
		Token lastToken;
		StringBuilder textValue = new StringBuilder();
		char c;
		while ((c = (char) read()) != -1) {
			textValue.append(c);
			List<Token> list = Token.getMatchingTokens(textValue.toString());
			// TODO review this to go to maximum length for one token
			if (list.size() == 1) {
				return list.get(0);
			} else if (list.size() == 0) {
				throw new LexicalError(textValue.toString());
			}
		}
		return null;
	}

	private void skipSpaces() throws IOException {
		// TODO skip gap characters
		char c;
		while ((c = (char) read()) != -1 && isGapCharacter(c))
			;
	}

	private boolean isGapCharacter(char c) {
		// TODO
		return false;
	}
}
