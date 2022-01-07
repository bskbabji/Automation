package com.java;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class CreatePropertiesFile {
	
	static Properties propertiesObj;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println(System.getProperty("user.dir"));
		FileWriter fw = new FileWriter(System.getProperty("user.dir")+"\\src\\main\\resources\\SampleProperties.properties",true);
		
		propertiesObj = new Properties();
		
		propertiesObj.setProperty("NAME", "Swapna");
		propertiesObj.store(fw, null);
		propertiesObj.clear();
		
		propertiesObj.setProperty("NAME1", "NIhal");
		propertiesObj.store(fw, null);
		propertiesObj.clear();
		
		fw.close();
		

	}

}
