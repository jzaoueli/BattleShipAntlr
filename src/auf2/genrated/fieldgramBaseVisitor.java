// Generated from C:/Users/Jihed/IdeaProjects/firstAntlr/src/auf2\fieldgram.g4 by ANTLR 4.5.1
package auf2.genrated;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link fieldgramVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class fieldgramBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements fieldgramVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFile(fieldgramParser.FileContext ctx) { return visitChildren(ctx); }
}