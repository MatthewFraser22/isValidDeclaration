package cp213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ValidDeclaration {

    public static void main(String[] args) {
    	Scanner keyboard = new Scanner(System.in);
    	
        String statement = "1";
        
        
        while (statement.length() != 0) {
            System.out.println("Enter a string: ");
            statement = keyboard.nextLine();
            if (statement.length() > 0) {
                if(isValid(statement)) {
                    System.out.println("'"+statement+"' is a valid java variable definition.");
                }else {
                    System.out.println("'"+statement+"' is not a valid java variable definition.");
                }
            }
        }
        keyboard.close();

    }
    
    public static boolean isValid(final String statement) {
        String data = "";
        String name = "";
        int x = 0;
        if(!statement.substring(statement.length()-1).equals(";")) {
            return false;
        }
        for (int i = 0; i < statement.length()-1; i++) {
            if ((!Character.toString(statement.charAt(i)).equals(" "))&& x==0) {
                data += statement.charAt(i);
            }else if (x==1){
                name += statement.charAt(i);
            }else {
                x += 1;
            }
        }
        if ((data.equals(""))|| (name.equals(""))) {
            return false;
        }
        
        ArrayList<String> list = new ArrayList<String>(
        Arrays.asList("byte","short","char","int","long","float","double","boolean"));
        
        boolean valid = false;
        
        for(String j: list) {
            if(data.equals(j)) {
                valid = true;
                
                break;
            }
        }
        if (valid = false) {
            return false;
        }
        if(name.equals("_")) {
            return false;
        }
        
        for (int i=0; i< name.length(); i++) {
            if (i==0) {
                if((!Character.toString(name.charAt(i)).equals("_")) && 
                		(!Character.isLetter(name.charAt(i)))){
                    return false;
                }else if ((!Character.isLetter(name.charAt(i))) && 
                		(!Character.isDigit(name.charAt(i)))
                && (!Character.toString(name.charAt(i)).equals("_"))){
                    return false;
                }
            }
            
        }
        return true;
    }

}

