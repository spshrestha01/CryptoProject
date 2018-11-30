package HillCipher;

import java.io.IOException;

public class HillDecrypt {
    public static void main(String[] args) throws IOException {
        String[] results = new String[2];
        Hill hill = new Hill();
        hill.runEncryption("hillSolveInput.txt", "invKey.txt");
    }
}
