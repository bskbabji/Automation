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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestAlerts {
	
	WebDriver driver;
	Properties propertiesObj;
	
  @Test
  public void testingAlerts() throws InterruptedException {
	  
	  SoftAssert softAssertObj = new SoftAssert();
	  
	  
	  //testing first alert
	  driver.findElement(By.id("alertButton")).click();
	  Alert alertObj = driver.switchTo().alert();
	  Thread.sleep(1000);
	  String alert1Text = alertObj.getText();
	  alertObj.accept();
	  softAssertObj.assertEquals(alert1Text, propertiesObj.getProperty("Alert1Text"));
	  //Assert.assertEquals(alert1Text, propertiesObj.getProperty("Alert1Text"));
	  
	  
	  //testing second alert
	  Thread.sleep(1000);
	  driver.findElement(By.id("timerAlertButton")).click();
	  Thread.sleep(6000);
	  alertObj = driver.switchTo().alert();
	  String alert2Text = alertObj.getText();
	  alertObj.accept();
	  softAssertObj.assertEquals(alert2Text, propertiesObj.getProperty("Alert2Text"));
	  
	  //testing third alert
	  Thread.sleep(1000);
	  driver.findElement(By.id("confirmButton")).click();
	  alertObj = driver.switchTo().alert();
	  Thread.sleep(1000);
	  alertObj.dismiss();
	  String alert3CancelText = driver.findElement(By.id("confirmResult")).getText();
	  System.out.println( "alert3CancelText" + alert3CancelText);
	  softAssertObj.assertEquals(alert3CancelText, propertiesObj.getProperty("Alert3ResultTextCancel"));
	  
	  
	  //testing fourth alert
	  Thread.sleep(1000);
	  driver.findElement(By.id("promtButton")).click();
	  alertObj = driver.switchTo().alert();
	  alertObj.sendKeys(propertiesObj.getProperty("Alert4Textbox"));
	  Thread.sleep(5000);
	  alertObj.accept();
	  String alert4text = driver.findElement(By.id("promptResult")).getText();
	  softAssertObj.assertEquals(alert4text, propertiesObj.getProperty("Alert4Result"));
	  
	  
	  
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
	  
	  driver.get(propertiesObj.getProperty("AlertURL"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	  
  }


  @AfterSuite
  public void afterSuite() {
	  
	  driver.close();
  }

}
