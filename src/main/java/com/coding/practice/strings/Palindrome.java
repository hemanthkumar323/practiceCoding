package com.coding.practice.strings;

public class Palindrome {
	public int isPalindrome(String a) {
	    int i=0, j= a.length()-1;
	    
	    while(i<j) {
	        boolean foundChar1 = false;    
	        while(i<j && !foundChar1) {
	            if(isAlphaNumeric(a.charAt(i)))
	            	foundChar1 = true;
	            else
	            	i++;
	        }
	        
	        boolean foundChar2 = false; 
	        while(i<j && !foundChar2) {
	        	if(isAlphaNumeric(a.charAt(j)))
	        		foundChar2 = true;
	        	else
	        		j--;
	        }
	        
	        if(i<j) {
	        	if(Character.toLowerCase(a.charAt(i)) != Character.toLowerCase(a.charAt(j)))
	        		return -1;
	        	else {
	        		i++;j--;
	        	}
	        }
	    }
	    return 1;
	}
	
	private boolean isAlphaNumeric(char c) {
	    return Character.isDigit(c) || Character.isLetter(c);
	}
	
	public static void main(String args[]) {
		Palindrome pal = new Palindrome();
		System.out.println(pal.isPalindrome("Abc:,Cba"));
	}
}
