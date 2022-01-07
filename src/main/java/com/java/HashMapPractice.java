package com.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HashMapPractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		char[] ch = s.toCharArray();
		
		
		
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		
		for(char c : ch)
		{
			
			if(hm.containsKey(c))
			 {
				int val = hm.get(c);
				val = val + 1;
				hm.put(c, val);
			 }
			else
				hm.put(c, 1);
		}
		
		System.out.println(hm);
	}

}
