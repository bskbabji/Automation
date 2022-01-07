package com.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWordsInSentence {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		System.out.println("enter a sentence");
		String sentence = reader.readLine();

		// Printing the read line
		System.out.println(sentence);

		String[] wordsArray = sentence.split(" ");
		String reverseSentence = "";

		for (int j=wordsArray.length; j>0;j--)
		{
			//System.out.println("word " + s);
			String s = wordsArray[j-1];
			String reverseString="";
			  
			  for (int i = s.length(); i >=1 ; i--)
			  {
				 // System.out.println("char at " + i+ s.charAt(i-1));
				  reverseString = reverseString + s.charAt(i-1);
			  
			  } 
			  System.out.println("reversed string " + reverseString);
			  reverseSentence = reverseSentence + reverseString + " ";
			  
			 
		}
		
		System.out.println("reversed sentence is: " + reverseSentence);  
	}

}
