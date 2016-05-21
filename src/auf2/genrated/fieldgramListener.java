// Generated from C:/Users/Jihed/IdeaProjects/firstAntlr/src/auf2\fieldgram.g4 by ANTLR 4.5.1
package auf2.genrated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link fieldgramParser}.
 */

 interface fieldgramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link fieldgramParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(fieldgramParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link fieldgramParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(fieldgramParser.FileContext ctx);
}