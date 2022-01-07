package com.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapWithoutTemp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter first number");
		String num1 = bReader.readLine();
		int num1Int = Integer.parseInt(num1);
		
		System.out.println("enter second number");
		String num2 = bReader.readLine();
		int num2Int = Integer.parseInt(num2);
		
		System.out.println("before swap a and b are "+ num1Int +" " + num2Int);
		
		
		num1Int = num1Int + num2Int;
		num2Int = num1Int - num2Int;
		num1Int = num1Int - num2Int;
		
		System.out.println("before swap a and b are "+ num1Int +" " + num2Int);

	}

}
