package com.java;

public class AccessSpecifiers {
	
	public void publicMethod()
	{
		System.out.println("in public method");
	}
	
	void defaultMethod()
	{
		System.out.println("in default method");
	}
	private void privateMethod()
	{
		System.out.println("in private method");
	}
	protected void protectedMethod()
	{
		System.out.println("in protected method");
	}

	public static void main(String args[])
	{
		AccessSpecifiers obj = new AccessSpecifiers();
		obj.publicMethod();
		obj.defaultMethod();
		obj.privateMethod();
		obj.protectedMethod();
		
	}
}
