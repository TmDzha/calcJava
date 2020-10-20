package one;
import java.util.Scanner;

public class Strt{

    public static void main(String[]args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        String trimmedStr = str.trim();
        
        String a = returnA(trimmedStr);
        String b = returnB(trimmedStr);
        
        if ((Digits.isDigit(a))&(Digits.isDigit(b))) {
        	int ai = Integer.parseInt(a);
        	int bi = Integer.parseInt(b);
        	if((ai<=10)&(bi<=10)) {
        		System.out.print(getAction(trimmedStr, ai, bi));
			} else {
	    		throw new WrongInput("Too big digit");
	    	}
        } else if (Digits.checkPresence(a)&(Digits.checkPresence(b))) {
        	int ar = Integer.parseInt(Digits.getKeyOrValue(a));
        	int br = Integer.parseInt(Digits.getKeyOrValue(b));
        	if((ar<=10)&(br<=10)) {
        		int resultr = getAction(trimmedStr, ar, br);
        		String outputr = Digits.getKeyOrValue(Integer.toString(resultr));
        		System.out.println(outputr);
			} else {
	    		throw new WrongInput("Too big digit");
	    	}
        }
    }
    
    private static String returnA (String a) {
    	String subStr = "";
    	int subInd = 0;
    	if (a.contains("*")){
    		subInd = a.indexOf('*');
    		subStr = a.substring(0, subInd);
    	}else if(a.contains("/")){
    		subInd = a.indexOf('/');
    		subStr = a.substring(0, subInd);
    	}else if(a.contains("+")){
    		subInd = a.indexOf('+');
    		subStr = a.substring(0, subInd);
    	}else if(a.contains("-")){
    		subInd = a.indexOf('-');
    		subStr = a.substring(0, subInd);
    	}else {
    		System.out.println("No operation available");
    	}
    	return subStr;
    }
    
    
    private static String returnB (String b) {
    	String subStr = "";
    	int subInd = 0;
    	if (b.contains("*")){
    		subInd = b.indexOf('*')+1;
    		subStr = b.substring(subInd, b.length());
    	}else if(b.contains("/")){
    		subInd = b.indexOf('/')+1;
    		subStr = b.substring(subInd, b.length());
    	}else if(b.contains("+")){
    		subInd = b.indexOf('+')+1;
    		subStr = b.substring(subInd, b.length());
    	}else if(b.contains("-")){
    		subInd = b.indexOf('-')+1;
    		subStr = b.substring(subInd, b.length());
    	}else {
    		System.out.println("No operation available");
    	}
    	return subStr;
    }
    
    
    private static int getAction (String inputStr, int a, int b) throws Exception {
    	int output = 0;
    	if (inputStr.contains("*")){
    		output = Mth.mul(a, b);
    	}else if(inputStr.contains("/")){
    		output = Mth.div(a, b);
    	}else if(inputStr.contains("+")){
    		output = Mth.add(a, b);
    	}else if(inputStr.contains("-")){
    		output = Mth.sub(a, b);
    	}else {
    		throw new WrongInput("Wrong digit");
    	}
    	return output;
    }
    
   
    
}

