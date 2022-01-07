package com.testNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestFrames {
	
	WebDriver driver;
	Properties propertiesObj;
	
  @Test
  public void testingFrames() throws InterruptedException {
	  driver.switchTo().frame("frame1");
	  Thread.sleep(100);
	  driver.switchTo().frame("frame3");
	  Thread.sleep(100);
	  driver.findElement(By.xpath("//input[@id='a']")).click();
	  Thread.sleep(100);
	  
	  driver.switchTo().parentFrame();
	  driver.findElement(By.xpath("//input")).sendKeys("swapna");
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame("frame2");
	  Thread.sleep(200);
	  //other way of doing the above functionality
	 /* WebElement parentFrame = driver.findElement(By.xpath("//iframe[@id='frame1']"));
	  driver.switchTo().frame(parentFrame);
	  if(parentFrame == null) System.out.println("frame not found");
	  if(parentFrame != null) {
		  WebElement childFrame1 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		  
		  if(childFrame1 == null) System.out.println("child frame is null");
		  driver.switchTo().frame(childFrame1);
		  driver.findElement(By.xpath("//input[@id='a']")).click();
		  Thread.sleep(5000);
	  }*/
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  readPropertyFile();
	  launchBrowser();
	  
  }
  
  public void readPropertyFile() {
	  
	  try {
		  File fileObj = new File(System.getProperty("user.dir")+ "//src//test//resources//ConfigurationProperty.properties");
		  System.out.println("file name is " +fileObj.getName());
		  FileInputStream fileInputStreamObj = new FileInputStream(fileObj);
		  propertiesObj = new Properties();
		  propertiesObj.load(fileInputStreamObj);
		  }
		  catch(Exception e) {
			  System.out.println("exception caused is " + e.getMessage());
		  }	  
  }
  
  public void launchBrowser() {
	  
	  String browser = propertiesObj.getProperty("browser");
	  
	  switch(browser) {
	  
	  case "Edge": WebDriverManager.edgedriver().setup();
	  			   driver = new EdgeDriver();
	  			   break;
	  			   
	  case "Chrome": WebDriverManager.chromedriver().setup();
	  				 driver = new ChromeDriver();
	  				 break;
	  				 
	  case "IE" : WebDriverManager.iedriver().setup();
		 		  driver = new InternetExplorerDriver();
		 		  break;

	  }
	  
	  driver.get(propertiesObj.getProperty("FramesURL"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	  
  }

	  
  

  @AfterSuite
  public void afterSuite() {
	  driver.close();
  }

}
