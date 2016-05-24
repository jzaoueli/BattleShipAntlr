// Generated from C:/Users/Jihed/IdeaProjects/firstAntlr/src/auf3/grammar\SequenceGram.g4 by ANTLR 4.5.1
package auf3.battleship.antlrgeneration.sequence;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link SequenceGramVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public class SequenceGramBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements SequenceGramVisitor<T> {
    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitFile(SequenceGramParser.FileContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitLine(SequenceGramParser.LineContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitEol(SequenceGramParser.EolContext ctx) {
        return visitChildren(ctx);
    }
}