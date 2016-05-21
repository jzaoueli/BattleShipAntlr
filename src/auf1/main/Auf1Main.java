package auf1.main;

import auf1.generated.CSVBaseListener;
import auf1.generated.CSVLexer;
import auf1.generated.CSVParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Jihed on 19.05.2016.
 * this is the main class who run the verification of test file
 */
public class Auf1Main extends CSVBaseListener {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("files/auf1/test.csv");
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(fileReader);
        // Get CSV lexer
        CSVLexer lexer = new CSVLexer(antlrInputStream);
        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Pass the tokens to the parser
        CSVParser parser = new CSVParser(tokens);
        // Specify our entry point
        CSVParser.FileContext fileContext = parser.file();
        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        CSVBaseListener listener = new Auf1Main();
        walker.walk(listener, fileContext);
    }

    public void exitFile(CSVParser.FileContext ctx) {
        System.out.println("If no error outputs occurred, then file has valid format!");
        System.out.println(ctx.getText());
    }
}
