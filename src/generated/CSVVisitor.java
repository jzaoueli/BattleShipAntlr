package generated;// Generated from C:/Users/Jihed/IdeaProjects/firstAntlr/src\CSV.g4 by ANTLR 4.5.1

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CSVParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface CSVVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link CSVParser#file}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFile(CSVParser.FileContext ctx);

    /**
     * Visit a parse tree produced by {@link CSVParser#row}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRow(CSVParser.RowContext ctx);

    /**
     * Visit a parse tree produced by {@link CSVParser#value}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitValue(CSVParser.ValueContext ctx);
}