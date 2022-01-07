package com.java;
public class Example{  
   public static void main(String args[]){  
	String str1 = "beginnersbook";    
		
	/* The Java String intern() method searches the string "beginnersbook"  
	 * in the memory pool and returns the reference of it.
	 */
	//String str2 = new String("beginnersbook").intern();
	String str2 = new String("beginnersbook"); 
	//prints true 
	System.out.println("str1==str2: "+(str1==str2));
   }
}