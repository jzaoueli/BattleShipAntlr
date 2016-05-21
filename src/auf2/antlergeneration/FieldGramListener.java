// Generated from C:/Users/Jihed/IdeaProjects/firstAntlr/src/auf2\FieldGram.g4 by ANTLR 4.5.1
package auf2.antlergeneration;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FieldGramParser}.
 */
interface FieldGramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FieldGramParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(FieldGramParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link FieldGramParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(FieldGramParser.FileContext ctx);
}