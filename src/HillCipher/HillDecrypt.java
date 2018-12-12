package HillCipher;

import AffineCipher.AffineDecrypt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class HillDecrypt {
    public static void main(String[] args) throws IOException {
        Hill hill = new Hill();
        String[] results  = hill.runEncryption("hillSolveInput.txt", "invKey.txt");
        File file = new File("hillSolveOutput.txt");
        try{
            PrintWriter dataOut = new PrintWriter(file);
            dataOut.print(results[0]);
            dataOut.close();
        }catch(Exception e){
            System.out.println(e);
        }
        AffineDecrypt ad = new AffineDecrypt();
        ad.decrypt();
    }
}
