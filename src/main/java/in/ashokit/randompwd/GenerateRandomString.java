package in.ashokit.randompwd;

import java.util.Random;
import java.util.Scanner;
 
public class GenerateRandomString {
 
	 private static String generateRandomString(int length, String seedChars) {
	    	
    	 String asciiUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         String asciiLowerCase = asciiUpperCase.toLowerCase();
         String digits = "1234567890";
         String seedchars = asciiUpperCase + asciiLowerCase + digits;
    	
    	int lentght=4;
    	//String seedChars=
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Random rand = new Random();
        while (i < length) {
            sb.append(seedChars.charAt(rand.nextInt(seedChars.length())));
            i++;
        }
        return sb.toString();
    }
}