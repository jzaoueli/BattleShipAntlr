package auf3.battleship.generator;

import auf3.battleship.antlrgeneration.sequence.SequenceGramBaseListener;
import auf3.battleship.antlrgeneration.sequence.SequenceGramLexer;
import auf3.battleship.antlrgeneration.sequence.SequenceGramParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileReader;
import java.io.IOException;

import static auf3.battleship.generator.SequenceAndFieldGenerator.createAndWriteInFile;
import static auf3.battleship.generator.SequenceAndFieldGenerator.getTime;


class SeqCodeGen extends SequenceGramBaseListener {

    private static String sequence;
    private static final String FIELD_PATH = "src/auf3/battleship/game/Sequence.java";


    void generateSequenceClass() throws IOException {
        String generatedStr = getHeaderStrings();
        generatedStr += getTableValues();
        generatedStr += getFooter();
        createAndWriteInFile(FIELD_PATH, generatedStr);
    }

    private String getFooter() {
        return "\n"
                + "     return sequence;\n"
                + "   }\n}";
    }

    private String getTableValues() throws IOException {
        getSequenceStringFromFile();
        String csvString = sequence;
        return getSequenceContent(csvString);
    }

    private static String getSequenceContent(String csvString) {
        int a = 0;
        String tempResultString = "";
        String tempInput = removeExtras(csvString);
        System.out.print(a);
            for (int i = 0; i < 49; i++) {
                tempResultString += "        sequence[" + i + "] = \"" + getValueWithIndex(i, tempInput) + "\";\n";
            }
        return tempResultString;
    }

    private static String getValueWithIndex(int i, String input) {
        String[] parts = input.split("\\.");
        return parts[i];
    }

    private static String removeExtras(String csvString) {
        String tempString = csvString.replaceAll("null","");
        tempString = tempString.replaceAll("<EOF>","");
        tempString = tempString.replaceAll("Der Computer feuert auf ","");
        tempString = tempString.replaceAll("\r\n","");
        //tempString = tempString.replaceAll("\\.", "*");
        return tempString;
    }

    private String getHeaderStrings() {
        return "package auf3.battleship.game;\n\n" +
                "class Sequence {\n\n" +
                "/**\n* created : " + getTime() +
                "\n*/\n"
                + "   private static String[] sequence = new String[49];\n"
                + "   static String[] getSequence(){\n";
    }

    private String getSequenceStringFromFile() throws IOException {

        FileReader fileReader = new FileReader("files/auf3/sequence.csv");
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(fileReader);
        // Get CSV lexer
        SequenceGramLexer lexer = new SequenceGramLexer(antlrInputStream);
        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Pass the tokens to the parser
        SequenceGramParser parser = new SequenceGramParser(tokens);
        // Specify our entry point
        SequenceGramParser.FileContext fileContext = parser.file();
        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        SequenceGramBaseListener listener = new SeqCodeGen();
        walker.walk(listener, fileContext);

        return sequence;
    }

    public void exitFile(SequenceGramParser.FileContext ctx) {
        sequence += ctx.getText();
    }
}
