package auf2.battleship.generator;

import auf2.feature.PlayerFieldCSVFeature;

import java.io.*;

public class CodeGenerator extends PlayerFieldCSVFeature {

    public static void main(String[] args) throws IOException {

        String generatedStr = getHeaderStrings();
        generatedStr += getTableValues();
        generatedStr = setFooter(generatedStr);

        createAndWriteInFile("src/auf2/battleship/generated/GeneratedField.java", generatedStr);

    }

    private static String setFooter(String generatedStr) {
        return generatedStr.substring(0, generatedStr.length() - 2) + "}\n   };\n\n"
                + "   static String[][] getField(){\n"
                + "     return field;\n"
                + "   }\n}";
    }

    private static String getHeaderStrings() {
        return "package auf2.battleship.generated;\n\n" +
                "class GeneratedField {\n\n" +
                "   private static String[][] field = new String[][]{\n";
    }

    private static void createAndWriteInFile(String path, String text) throws IOException {
        File file = new File(path);
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.flush();
        writer.close();
    }

    private static String getTableValues() throws IOException {
        setResult();
        String csvString = getResult();
        String tempResultString = "       {";

        for (int i = 0; i < csvString.length(); i++) {
            switch (csvString.charAt(i)) {
                case 'w':
                    tempResultString += "\"0\"";
                    if (csvString.charAt(i + 1) != '\n' && csvString.charAt(i + 1) != '\r') {
                        tempResultString += ",";
                    }
                    break;
                case 's':
                    tempResultString += "\"1\"";
                    if (csvString.charAt(i + 1) != '\n' && csvString.charAt(i + 1) != '\r') {
                        tempResultString += ",";
                    }
                    break;
                case '\n':
                    tempResultString += "},\n       {";
                    break;
                default:
                    System.err.println(i + "- this character will not be moved = " + csvString.charAt(i));
            }
            System.err.println("actual string : " + tempResultString);
        }
        tempResultString += "\"";
        return tempResultString;
    }
}
