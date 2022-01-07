package com.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWordsInSentenceUsingStringBuffer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		System.out.println("enter a sentence");
		String sentence = reader.readLine();

		// Printing the read line
		System.out.println(sentence);
		
		StringBuffer sentenceBuffer = new StringBuffer();
		sentenceBuffer.append(sentence);
		
		StringBuffer reverseSentence = sentenceBuffer.reverse();

			
		System.out.println("reversed sentence is: " + reverseSentence);  
	}

}


	


