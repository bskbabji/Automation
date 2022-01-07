package com.java;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList al = new ArrayList();
		al.add(10);
		al.add("swapna");
		al.add(true);
		
		int i = (int) al.get(0);
		
		for(Object o : al)
			System.out.println(o);
		
		Iterator itr = al.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		

	}

}
