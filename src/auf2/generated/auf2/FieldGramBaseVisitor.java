// Generated from C:/Users/Jihed/IdeaProjects/firstAntlr/src/auf2\FieldGram.g4 by ANTLR 4.5.1
package auf2.generated.auf2;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link FieldGramVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class FieldGramBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements FieldGramVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFile(FieldGramParser.FileContext ctx) { return visitChildren(ctx); }
}