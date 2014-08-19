package com.jbion.metaparser.ebnf.parser.lexical;

import java.io.IOException;

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
		StringBuilder sb = new StringBuilder();
		char c;
		while ((c = (char) read()) != -1) {
			sb.append(c);
			int nbTokens = Token.countMatchingTokens(sb.toString());
			if (nbTokens == 0) {
				String unrecognized = sb.toString();
				throw new LexicalError(sb.toString());
			}
		}
		return null;
	}
}
