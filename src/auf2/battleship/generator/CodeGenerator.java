package auf2.battleship.generator;

import java.io.*;

public class CodeGenerator {
    public static void main(String[] args) throws IOException {

        String generatedStr =
                "package auf2.battleship.generated;\n\n" +
                        "class Field {\n\n" +
                        "   private static String[][] field = new String[][]{\n";


        try (BufferedReader br = new BufferedReader(new FileReader("src/auf2/battleship/generated/generatedModel.txt"))) {
            String line;
            String generatedLine;
            for (int i = 0; i < 7; i++) {
                line = br.readLine();
                generatedLine = "       {";
                for (int j = 0; j < 7; j++) {
                    generatedLine = generatedLine + "\"" + line.charAt(j) + "\",";
                }
                generatedLine = generatedLine.substring(0, generatedLine.length() - 1) + "},\n";

                generatedStr = generatedStr + generatedLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        generatedStr = generatedStr.substring(0, generatedStr.length() - 2) + "\n   };\n\n"
                + "   static String[][] getField(){\n"
                + "     return field;\n"
                + "   }\n}";

        File file = new File("src/auf2/battleship/generated/Field.java");
        //file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write(generatedStr);
        writer.flush();
        writer.close();
    }
}
