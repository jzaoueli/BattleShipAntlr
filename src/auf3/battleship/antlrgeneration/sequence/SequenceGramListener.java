// Generated from C:/Users/Jihed/IdeaProjects/firstAntlr/src/auf3/grammar\SequenceGram.g4 by ANTLR 4.5.1
package auf3.battleship.antlrgeneration.sequence;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SequenceGramParser}.
 */
interface SequenceGramListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link SequenceGramParser#file}.
     *
     * @param ctx the parse tree
     */
    void enterFile(SequenceGramParser.FileContext ctx);

    /**
     * Exit a parse tree produced by {@link SequenceGramParser#file}.
     *
     * @param ctx the parse tree
     */
    void exitFile(SequenceGramParser.FileContext ctx);

    /**
     * Enter a parse tree produced by {@link SequenceGramParser#line}.
     *
     * @param ctx the parse tree
     */
    void enterLine(SequenceGramParser.LineContext ctx);

    /**
     * Exit a parse tree produced by {@link SequenceGramParser#line}.
     *
     * @param ctx the parse tree
     */
    void exitLine(SequenceGramParser.LineContext ctx);

    /**
     * Enter a parse tree produced by {@link SequenceGramParser#eol}.
     *
     * @param ctx the parse tree
     */
    void enterEol(SequenceGramParser.EolContext ctx);

    /**
     * Exit a parse tree produced by {@link SequenceGramParser#eol}.
     *
     * @param ctx the parse tree
     */
    void exitEol(SequenceGramParser.EolContext ctx);
}