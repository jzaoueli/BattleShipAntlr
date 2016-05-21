// Generated from C:/Users/Jihed/IdeaProjects/firstAntlr/src/auf2\fieldgram.g4 by ANTLR 4.5.1
package auf2.genrated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link fieldgramParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
interface fieldgramVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link fieldgramParser#file}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFile(fieldgramParser.FileContext ctx);
}