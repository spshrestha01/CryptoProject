package HillCipher;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class HillDecrypt {
    public static void main(String[] args) throws IOException {
        String[] results = new String[2];
        Hill hill = new Hill();
        results = hill.runEncryption("hillSolveInput.txt", "invKey.txt");
        File file = new File("hillSolveOutput.txt");
        try{
            PrintWriter dataOut = new PrintWriter(file);
            dataOut.print(results[0]);
            dataOut.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
