package com.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateTextFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\SampleTextFile.txt");
		//FileWriter fw = new FileWriter(System.getProperty("user.dir")+"\\src\\main\\resources\\SampleTextFile.txt",true);
		FileWriter fw = new FileWriter(f,true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("hello Swapna" + " \n");
		bw.flush();
		bw.write("hello Nihal" + "\n");
		bw.flush();
		bw.write("hello Nirvan" + "\n");
		bw.flush();
		
		bw.close();
		fw.close();
		
		
		
	}

}
