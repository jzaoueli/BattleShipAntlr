// Generated from C:/Users/Jihed/IdeaProjects/firstAntlr/src/auf2\FieldGram.g4 by ANTLR 4.5.1
package auf2.antlergeneration;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FieldGramParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
interface FieldGramVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FieldGramParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(FieldGramParser.FileContext ctx);
}