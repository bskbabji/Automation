package com.java1;

import com.java.AccessSpecifiers;

public class AccessSpecifiersDifferentPackage extends AccessSpecifiers
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AccessSpecifiers obj = new AccessSpecifiers(); //automatically created import com.java.AccessSpecifiers;  statement
		obj.publicMethod();	
		
		AccessSpecifiersDifferentPackage obj1 = new AccessSpecifiersDifferentPackage();
		obj1.protectedMethod();
		obj1.publicMethod();
	
		
		
		
		

	}

}


