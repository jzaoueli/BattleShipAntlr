package yahima;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileReader;
import java.io.IOException;

public class Main extends FieldBaseListener {
    public static void main(String[] args) throws IOException {
        FieldLexer lexer = new FieldLexer(new ANTLRInputStream(new FileReader("src/Field.csv")));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        FieldParser parser = new FieldParser(tokens);

        FieldParser.FileContext fileContext = parser.file();

        ParseTreeWalker walker = new ParseTreeWalker();

        FieldBaseListener listener = new Main();

        walker.walk(listener, fileContext);
    }

    public void exitFile(FieldParser.FileContext ctx) {
        System.out.println("Alles ok");
    }

    public void exitRow(FieldParser.RowContext ctx) {
        System.out.println(ctx.getText());
    }

}