package com.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseNumber {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	     
         // Reading data using readLine
		 
         String name = reader.readLine();
         int i = Integer.parseInt(name);
         int j=name.length();
         double reverseInt = 0;
    
         while (i >=0 && j>=1)
         {
        	 double temp = (i%10);
        	 reverseInt = reverseInt + temp*(Math.pow(10, j-1));
        	 j--;
        	 i=i/10;
        	 
         }
         
  
    System.out.println("reverse number " + reverseInt);
    
    
    
	}

}
