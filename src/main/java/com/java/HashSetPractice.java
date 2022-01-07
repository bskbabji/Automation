package com.java;


import java.util.HashSet;
import java.util.Iterator;

public class HashSetPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet al = new HashSet();
		al.add(10);
		al.add("swapna");
		al.add(true);
		
		
		
		for(Object o : al)
			System.out.println(o);
		
		Iterator itr = al.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
	}

}
