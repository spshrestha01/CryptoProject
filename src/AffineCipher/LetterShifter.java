package AffineCipher;

/*
 * This is code that affine shifts a message
 * It can also perform linear shifts and multiplication shifts
 * This can be accomplished by making a=1 or b=0, respectively
 */

import HillCipher.Hill;
import HillCipher.HillEncrypt;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class LetterShifter {
    private int a;
    private int b;
    private String messageToCode;
    // shifts all letters in messageToCode by ax + b

    private LetterShifter(int anA, int aB, String aMessage){
        a = anA;
        b = aB;
        messageToCode = aMessage.toUpperCase(); // case insensitive
    }

    private String shiftMessage(){
        if (!isRelativePrime()){
            return "Message cannot be shifted by the given a value.";
        }
        String codedMessage = "";
        char currentLetter;

        for (int index = 0; index < messageToCode.length(); index++){
            currentLetter = messageToCode.charAt(index);
            if (currentLetter >= 65 && currentLetter <= 90){
                codedMessage += shiftLetter(currentLetter);
            }else{
                codedMessage += currentLetter;
            }
        }
        return group(codedMessage);
    }

    private boolean isRelativePrime(){
        if ((a == 13) || ((a % 2) == 0)){
            return false;
        }
        return true;
    }

    private char shiftLetter(char toShift){
        // the int values of characters A-Z are 65-90 on the ASCII table
        // it must be converted to values 1-26
        int x = toShift - 64;

        // shift x by
        // x = ax + b
        x *= a;
        x += b;

        // make it between 1 and 26 (wrap around mod 26)
        while (x > 26){
            x -= 26;
        }

        // convert to the coded letter
        x += 64;
        return (char)x;
    }

    private String group(String coded){
        // divides the coded message in groups of 5 letters each
        // eliminates blank spaces and punctuation in original message
        StringBuilder output = new StringBuilder("");
        coded = coded.trim();
        int letters = 0; // variable to keep track of how many letters are in the current word
        for (int index = 0; index < coded.length(); index++){
            if (letters == 5){
                output.append("");
                letters = 0;
            }
            if (coded.charAt(index) >= 65 && coded.charAt(index) <= 90){
                output.append(coded.charAt(index));
                letters++;
            }
        }
        return output.toString();
    }


    public static void main(String[] args){
        HillEncrypt he = new HillEncrypt();
        Hill hill = new Hill();
        Scanner dataIn = new Scanner(System.in);
        System.out.println("Enter input as follows:");
        System.out.println("Please input a on the first line and b on the second line (shift is ax + b)");
        System.out.println("On the following lines, input the message to shift, using as many lines as needed.");
        System.out.println("Note: It is not necessary to use punctuation.");
        System.out.println("Input \"endOfMessage\" on its own line to finish the input.");

        System.out.println("Enter Value for a:");
        int a = dataIn.nextInt();
        File filea = new File("a.txt");
        System.out.println("Enter Value for b:");
        int b = dataIn.nextInt();
        File fileb = new File("b.txt");


        try{
            PrintWriter printa = new PrintWriter(filea);
            PrintWriter printb = new PrintWriter(fileb);
            printa.print(a);
            printb.print(b);
            printa.close();
            printb.close();
        }catch(Exception e){
            System.out.println(e);
        }

        String message = "";
        System.out.println("Enter plain text followed by 'endOfMessage': ");
        String input = dataIn.nextLine();

        while (!input.equals("endOfMessage")){
            message += input;
            input = dataIn.nextLine();
        }

        System.out.println("Enter the key for the matrix");
        String key = dataIn.next();
        while(!hill.check(key, 2)){
            System.out.println("Invalid key!!! Key is not invertible because determinant=0... Please enter again");
            key = dataIn.nextLine();
        }
        dataIn.close();
        LetterShifter shifter = new LetterShifter(a, b, message);
        String text = shifter.shiftMessage();
        File f = new File("textToEncipher.txt");
        System.out.println("Affine Cipher Encryption Result:" );
        System.out.println(text.toUpperCase());
        try{
            PrintWriter dataOut = new PrintWriter(f);
            dataOut.print(text);
            dataOut.close();
        }catch(Exception e){
            System.out.println(e);
        }

        try{
            File matrixData = new File("matrixData.txt");
            PrintWriter matrixWrite = new PrintWriter(matrixData);
            matrixWrite.print(key.toUpperCase());
            matrixWrite.close();
            he.runEncryption();
        }catch(Exception e) {
            System.out.println(e);
        }

    }
}
