package com.java;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n1 = 0, n2 =1, i, count = 15, fSum = 0;
		System.out.print(n1 + " " );
		System.out.print(n2 + " " );

		
		for ( i =0; i < count -2; i++)
		{
			System.out.print( (n1+n2)+ " ");
			fSum = n1+n2;
			n1 = n2;
			n2 = fSum;
				
		}

	}

}
