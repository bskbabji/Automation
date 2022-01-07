package com.java;

public class AccessSpecifiersSamePackage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AccessSpecifiers obj = new AccessSpecifiers();
		obj.publicMethod();
		obj.protectedMethod();
		obj.defaultMethod();
		
		
		SamePackage obj1 = new SamePackage();
		obj1.defaultMethod();
		obj1.protectedMethod();
		obj1.publicMethod();
		
		

	}

}

class SamePackage extends AccessSpecifiers{
	
}

