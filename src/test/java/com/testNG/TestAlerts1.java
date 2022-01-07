package com.testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestAlerts1 {
	
	WebDriver driver;
	Properties propertiesObj;
  @Test
  public void testingAlerts() throws InterruptedException {
	  
	  Alert alertObj;
	  SoftAssert softAssertObj = new SoftAssert();
	  
	  driver.findElement(By.name("alert")).click();
	  alertObj = driver.switchTo().alert();
	  softAssertObj.assertEquals(alertObj.getText(), propertiesObj.getProperty("AlertText"));
	  Thread.sleep(1000);
	  alertObj.accept();
	  
	  
	  Thread.sleep(2000);
	  driver.findElement(By.name("confirmation")).click();
	  alertObj = driver.switchTo().alert();
	  softAssertObj.assertEquals(alertObj.getText(), propertiesObj.getProperty("ConfirmText"));
	  Thread.sleep(2000);
	  alertObj.dismiss();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.name("prompt")).click();
	  alertObj = driver.switchTo().alert();
	  System.out.println(propertiesObj.getProperty("PromptBoxInput"));
	  alertObj.sendKeys(propertiesObj.getProperty("PromptBoxInput"));
	  softAssertObj.assertEquals(alertObj.getText(), propertiesObj.getProperty("PromptText"));
	  Thread.sleep(5000);
	  alertObj.accept();
	  
	  softAssertObj.assertAll();
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
  
public void readPropertyFile(){
	  
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
	  
	  driver.get(propertiesObj.getProperty("PracticeAlertURL"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	  
  }


  @AfterSuite
  public void afterSuite() {
	  driver.close();
  }

}
