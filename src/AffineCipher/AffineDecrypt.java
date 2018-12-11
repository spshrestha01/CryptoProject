package AffineCipher;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

public class AffineDecrypt {
    public HashMap<String, Integer> alphabetMap = new HashMap<>();
    public HashMap<Integer, String> numericMap = new HashMap<>();
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
        int decValue = (hashValue - b);
        if (decValue > 26){
            decValue -= 26;
        }
        if (decValue<=0){
            decValue += 26;
        }
        if(decValue % a != 0){
            while(decValue % a != 0){
                decValue += 26;
            }
        }
        decValue /= a;
        String cValue = numericMap.get(decValue);
        return  cValue;
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

        numericMap.put(1,"a");
        numericMap.put(2,"b");
        numericMap.put(3,"c");
        numericMap.put(4,"d");
        numericMap.put(5,"e");
        numericMap.put(6,"f");
        numericMap.put(7,"g");
        numericMap.put(8,"h");
        numericMap.put(9,"i");
        numericMap.put(10,"j");
        numericMap.put(11,"k");
        numericMap.put(12,"l");
        numericMap.put(13,"m");
        numericMap.put(14,"n");
        numericMap.put(15,"o");
        numericMap.put(16,"p");
        numericMap.put(17,"q");
        numericMap.put(18,"r");
        numericMap.put(19,"s");
        numericMap.put(20,"t");
        numericMap.put(21,"u");
        numericMap.put(22,"v");
        numericMap.put(23,"w");
        numericMap.put(24,"x");
        numericMap.put(25,"y");
        numericMap.put(26,"z");
    }
}
