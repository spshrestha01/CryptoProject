package HillCipher;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class HillEncrypt {
    public void runEncryption() throws IOException {
        String[] results = new String[2];
        Hill hill = new Hill();
        results = hill.runEncryption("textToEncipher.txt", "matrixData.txt");
        File input = new File("hillSolveInput.txt");
        File matrix = new File("invKey.txt");
        PrintWriter printWriter = new PrintWriter(input);
        PrintWriter matrixWriter = new PrintWriter(matrix);
        printWriter.print(results[0]);
        matrixWriter.print(results[1]);
        printWriter.close();
        matrixWriter.close();
    }
}
