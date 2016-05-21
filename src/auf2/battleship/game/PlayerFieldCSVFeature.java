package auf2.battleship.game;

import auf2.generated.auf2.FieldGramBaseListener;
import auf2.generated.auf2.FieldGramLexer;
import auf2.generated.auf2.FieldGramParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Jihed on 21.05.2016.
 * this is the main class who run the verification of test file
 */
public class PlayerFieldCSVFeature extends FieldGramBaseListener {

    private static String result = "";

    public static String getPlayerFieldString() throws IOException {

        FileReader fileReader = new FileReader("files/auf2/playfield.csv");
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(fileReader);
        // Get CSV lexer
        FieldGramLexer lexer = new FieldGramLexer(antlrInputStream);
        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Pass the tokens to the parser
        FieldGramParser parser = new FieldGramParser(tokens);
        // Specify our entry point
        FieldGramParser.FileContext fileContext = parser.file();
        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        FieldGramBaseListener listener = new PlayerFieldCSVFeature();
        walker.walk(listener, fileContext);

        //System.err.print("this is the value of result :\n" + result);
        return result;
    }

    public void exitFile(FieldGramParser.FileContext ctx) {
        //System.out.println("If no error outputs occurred, then file has valid format!");
        result += ctx.getText();
        //System.out.println(result);
    }

}
