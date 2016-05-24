// Generated from C:/Users/Jihed/IdeaProjects/firstAntlr/src/auf3/grammar\SequenceGram.g4 by ANTLR 4.5.1
package auf3.battleship.antlrgeneration.sequence;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SequenceGramParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
interface SequenceGramVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link SequenceGramParser#file}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFile(SequenceGramParser.FileContext ctx);

    /**
     * Visit a parse tree produced by {@link SequenceGramParser#line}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLine(SequenceGramParser.LineContext ctx);

    /**
     * Visit a parse tree produced by {@link SequenceGramParser#eol}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEol(SequenceGramParser.EolContext ctx);
}