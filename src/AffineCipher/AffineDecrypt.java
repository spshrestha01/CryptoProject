package AffineCipher;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

public class AffineDecrypt {
    public HashMap<String, Integer> alphabetMap = new HashMap<>();
    private int a;
    private int b;
    private String message;

    public void decrypt(){
        a = getValue("a.txt");
        b = getValue("b.txt");
        message = getMessage("hillSolveOutput.txt");
        setAlphabetMap();
        String decryptedMessage = "";
        for (int i = 0; i < message.length(); i++){
            decryptedMessage += decryptMessage(message.charAt(i));
        }

        System.out.println("The final decrypted message is: " + decryptedMessage);
    }

    private String decryptMessage(char c) {
        int hashValue = alphabetMap.get(String.valueOf(c));
        int decValue = (hashValue - b) / a;
        int cValue = decValue + 96;
        char x = (char)cValue;
        return String.valueOf(x);
    }

    private int getValue(String fileName){
        String value = readFile(fileName);
        int val = Integer.parseInt(value);
        return val;
    }

    private String getMessage(String fileName){
        String message = readFile(fileName);
        return message;
    }

    private String readFile(String fileName){
        String content ="";
        File file = new File(fileName);
        try{
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            StringBuilder plain = new StringBuilder("");
            while (bis.available() > 0){
                plain.append((char)bis.read());
            }
            bis.close();
            fis.close();
            content = plain.toString();
        }catch (Exception e){
            System.out.println(e);
        }
        return content;
    }

    private void setAlphabetMap(){
        alphabetMap.put("a",1);
        alphabetMap.put("b",2);
        alphabetMap.put("c",3);
        alphabetMap.put("d",4);
        alphabetMap.put("e",5);
        alphabetMap.put("f",6);
        alphabetMap.put("g",7);
        alphabetMap.put("h",8);
        alphabetMap.put("i",9);
        alphabetMap.put("j",10);
        alphabetMap.put("k",11);
        alphabetMap.put("l",12);
        alphabetMap.put("m",13);
        alphabetMap.put("n",14);
        alphabetMap.put("o",15);
        alphabetMap.put("p",16);
        alphabetMap.put("q",17);
        alphabetMap.put("r",18);
        alphabetMap.put("s",19);
        alphabetMap.put("t",20);
        alphabetMap.put("u",21);
        alphabetMap.put("v",22);
        alphabetMap.put("w",23);
        alphabetMap.put("x",24);
        alphabetMap.put("y",25);
        alphabetMap.put("z",26);
    }
}
