package com.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverse {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     
            // Reading data using readLine
            String name = reader.readLine();
     
            // Printing the read line
            System.out.println(name);
            String reverseString="";
            
            for (int i = name.length(); i >=1 ; i--)
            {	
            	System.out.println("char at " + i + name.charAt(i-1));
            	reverseString = reverseString + name.charAt(i-1);      
            	
            }
            System.out.println("reversed string " + reverseString);
	}

}
