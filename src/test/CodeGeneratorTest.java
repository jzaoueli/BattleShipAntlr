package test;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

import static auf2.battleship.generator.CodeGenerator.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jihed on 21.05.2016.
 * test Code Generator class
 */
public class CodeGeneratorTest {

    private static String RESULT_STRING = "";

    @Test
    public void main() throws Exception {
        String INPUT_STRING =
                "w;w;w;s;s;s;s\n" +
                        "w;s;w;w;w;w;w\n" +
                        "w;s;w;w;w;w;w\n" +
                        "w;s;w;s;s;s;w\n" +
                        "w;s;w;w;w;w;w\n" +
                        "w;s;w;w;w;w;w\n" +
                        "w;w;s;s;w;w;w<EOF>";
        whenGetTableValues(INPUT_STRING);
        thenTableValueAdded();
    }

    @Test
    public void failureGenerateFile() {
        String INPUT_STRING =
                "nullw;w;w;s;s;s;s\n" +
                        "w;s;w;w;w;w;w\n" +
                        "w;s;w;w;w;w;w\n" +
                        "w;s;w;s;s;s;w\n" +
                        "w;s;w;w;w;w;w\n" +
                        "w;s;w;w;w;w;\n" +
                        "w;w;s;s;w;w;w";
        boolean thrown = false;

        try {
            whenGetTableValues(INPUT_STRING);
        } catch (RuntimeException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void checkGeneratedFile() throws IOException {
        String text;
        String INPUT_STRING =
                 "w;w;w;s;s;s;s\n" +
                 "w;s;w;w;w;w;w\n" +
                 "w;s;w;w;w;w;w\n" +
                 "w;s;w;s;s;s;w\n" +
                 "w;s;w;w;w;w;w\n" +
                 "w;s;w;w;w;w;w\n" +
                 "w;w;s;s;w;w;w<EOF>";
        String[][] expectedText = new String[][]{
                {"w","w","w","s","s","s","s"},
                {"w","s","w","w","w","w","w"},
                {"w","s","w","w","w","w","w"},
                {"w","s","w","s","s","s","w"},
                {"w","s","w","w","w","w","w"},
                {"w","s","w","w","w","w","w"},
                {"w","w","s","s","w","w","w"}
        };

        cleanOldGeneratedFiles();

        String path = "src/test/Field.java";
        text = givenGenerateFieldText(INPUT_STRING);
        whenGenerateFile(path, text);
        thenFieldIsGenerated();
        String[][] textGeneratedField;
        textGeneratedField = whenGetField();
        thenTextEquals(textGeneratedField, expectedText);
    }

    private void thenTextEquals(String[][] textGeneratedField, String[][] expectedText) {
        assert(Arrays.deepEquals(textGeneratedField, expectedText));
    }

    private String[][] whenGetField() {
        return Field.getField();
    }

    private void cleanOldGeneratedFiles() {
        String pathString = "src/test/Field.java";
        Path path = Paths.get(pathString);
        try {
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }
    }

    private void whenGenerateFile(String path, String text) throws IOException {
        createAndWriteInFile(path, text);
    }

    private void thenFieldIsGenerated() {
        File file = new File("src/test/Field.java");
        assertTrue(file.exists());
    }

    private String givenGenerateFieldText(String inputText) {
        String tempText = "package test;\n\n" +
                "class Field {\n\n" +
                "   private static String[][] field = new String[][]{\n";
        String tempResultString = "       {";
        tempResultString = setContent(inputText, tempResultString);
        tempResultString += "\"";
        tempText += tempResultString;
        tempText = setFooter(tempText);
        return tempText;
    }

    private void thenTableValueAdded() {
        String EXPECTED_RESULT_STRING =
                "\"w\",\"w\",\"w\",\"s\",\"s\",\"s\",\"s\"},\n" +
                        "       {\"w\",\"s\",\"w\",\"w\",\"w\",\"w\",\"w\"},\n" +
                        "       {\"w\",\"s\",\"w\",\"w\",\"w\",\"w\",\"w\"},\n" +
                        "       {\"w\",\"s\",\"w\",\"s\",\"s\",\"s\",\"w\"},\n" +
                        "       {\"w\",\"s\",\"w\",\"w\",\"w\",\"w\",\"w\"},\n" +
                        "       {\"w\",\"s\",\"w\",\"w\",\"w\",\"w\",\"w\"},\n" +
                        "       {\"w\",\"w\",\"s\",\"s\",\"w\",\"w\",\"w\",";

        assertTrue(EXPECTED_RESULT_STRING.equals(RESULT_STRING));
    }

    private void whenGetTableValues(String csvString) {
        RESULT_STRING = setContent(csvString, RESULT_STRING);
    }

}