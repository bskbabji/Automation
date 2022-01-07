package com.java;

public class MethodOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cat c = new Cat();
		c.makeNoise("hi"); // calls child class method
		c.makeNoise(); //calls parent class method

	}
	
	public void makeNoise() {
		
		System.out.println("animal makes noise");
		
	}

}

class Cat extends MethodOverriding
{
	   public void makeNoise(String s)
	   {
		   System.out.println("Cat says meow");
	   }
	
}
