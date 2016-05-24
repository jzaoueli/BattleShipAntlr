package auf3.battleship.generator;

import auf3.battleship.antlrgeneration.field.FieldGramBaseListener;
import auf3.battleship.antlrgeneration.field.FieldGramLexer;
import auf3.battleship.antlrgeneration.field.FieldGramParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class SequenceAndFieldGenerator extends FieldGramBaseListener {

    private static String field;
    private static final String FIELD_PATH = "src/auf3/battleship/game/Field.java";

    public static void main(String[] args) throws IOException {
        SeqCodeGen sequence = new SeqCodeGen();
        sequence.generateSequenceClass();
        generateFieldClass();
    }

    private static void generateFieldClass() throws IOException {
        //set the head of generated Field class
        String generatedStr = getHeaderStrings();
        //set the Field into String[][] in Field class
        generatedStr += getTableValues();
        //set the get method and foot of generated Field class
        generatedStr = setFooter(generatedStr);
        //generate Filed.java from the generatedString
        createAndWriteInFile(FIELD_PATH, generatedStr);
    }

    private static String setFooter(String generatedStr) {
        return generatedStr.substring(0, generatedStr.length() - 2) + "}\n   };\n\n"
                + "   static String[][] getField(){\n"
                + "     return field;\n"
                + "   }\n}";
    }

    private static String getHeaderStrings() {
        return "package auf3.battleship.game;\n\n" +
                "class Field {\n\n" +
                "/**\n* created : " + getTime() +
                "\n*/\n"
                + "   private static String[][] field = new String[][]{\n";
    }

    static void createAndWriteInFile(String path, String text) throws IOException {
        File file = new File(path);
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.flush();
        writer.close();
    }

    private static String getTableValues() throws IOException {
        setResult();
        String csvString = field;
        String tempResultString = "       {";
        tempResultString = setContent(csvString, tempResultString);
        tempResultString += "\"";
        return tempResultString;
    }

    private static String setContent(String csvString, String tempResultString) {

        try {
            for (int i = 0; i < csvString.length(); i++) {
                switch (csvString.charAt(i)) {
                    case 'w':
                        tempResultString += "\"w\"";
                        if (isAtTheEOL(csvString, i)) tempResultString += ",";
                        break;
                    case 's':
                        tempResultString += "\"s\"";
                        if (isAtTheEOL(csvString, i)) tempResultString += ",";
                        break;
                    case '\n':
                        tempResultString += "},\n       {";
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            System.out.println("can not generate tableContent");
            throw new RuntimeException("with error:\n" + e.getMessage());
        }
        return tempResultString;
    }

    private static boolean isAtTheEOL(String csvString, int i) {
        return csvString.charAt(i + 1) != '\n' && csvString.charAt(i + 1) != '\r';
    }

    private static String getPlayerFieldString() throws IOException {

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
        FieldGramBaseListener listener = new SequenceAndFieldGenerator();
        walker.walk(listener, fileContext);

        //System.err.print("this is the value of field :\n" + field);
        return field;
    }

    public void exitFile(FieldGramParser.FileContext ctx) {
        field += ctx.getText();
    }

    private static void setResult() throws IOException {
        getPlayerFieldString();
    }

    static String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

}
