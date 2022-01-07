package com.testNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

public class TestNGAnnotations {
	
	WebDriver driver;
	Properties propertiesObj;
  @Test
  public void validateLaunchPageTitle() {
	  
	  System.out.println("inside validateLaunchPageTitle");
	  String title = driver.getTitle();
	  //Assert.assertEquals(title, "Welcome to Green Mountain Outpost");
	  Assert.assertEquals(title,propertiesObj.getProperty("GMO_onlineTitle"));
  }
  @Test(dependsOnMethods= {"validateLaunchPageTitle"})
  public void validateGMOOnlinePage() {
	  
	  System.out.println("inside validateGMOOnlinePage");
	  driver.findElement(By.name("bSubmit")).click();
	  String text = driver.findElement(By.xpath("//h1[contains(text(),'OnLine Catalog')]")).getText();
	  //Assert.assertEquals(text, "OnLine Catalog");
	  Assert.assertEquals(text,propertiesObj.getProperty("GmoOnlineListPageTitle"));
  }
  
  @Test(dependsOnMethods={"validateGMOOnlinePage"})
	public void ValidateOrderGlacierSunGlasses(){
		System.out.println("inside ValidateOrderGlacierSunGlasses");
		driver.findElement(By.name("QTY_BACKPACKS")).sendKeys(propertiesObj.getProperty("BackPackQuantity"));
		//driver.findElement(By.xpath("//input[@name='QTY_BACKPACKS']")).sendKeys("5");
		driver.findElement(By.name("bSubmit")).click();
		String Title=driver.getTitle();
		//Assert.assertEquals(Title, "Place Order");
		Assert.assertEquals(Title,propertiesObj.getProperty("GMOonlinePlaceOrderTitle"));
		String UnitPrice=driver.findElement(By.xpath("//table[@cellpadding='4' and @cellspacing='1']/tbody/tr[2]/td[4]")).getText();
		System.out.println("UnitPrice: "+UnitPrice);
		String floatUnitPrice=UnitPrice.substring(2).trim();
		System.out.println("floatUnitPrice: "+floatUnitPrice);
		float UnitPrice_FloatValue = Float.parseFloat(floatUnitPrice);
		float UnitPrice_FloatCalculatedValue = UnitPrice_FloatValue*5;
		System.out.println("UnitPrice_FloatCalculatedValue:"+UnitPrice_FloatCalculatedValue);
		String TotalPrice = driver.findElement(By.xpath("//table[@cellpadding='4' and @cellspacing='1']/tbody/tr[2]/td[5]")).getText();
		float TotalPricefromWebTable = Float.parseFloat(TotalPrice.substring(2).trim());
		System.out.println("TotalPricefromWebTable:"+TotalPricefromWebTable);
		Assert.assertEquals(UnitPrice_FloatCalculatedValue, TotalPricefromWebTable);
	
	} 
  
  @Test (dependsOnMethods={"ValidateOrderGlacierSunGlasses"})
    public void validateGrandTotal(){
	  System.out.println("inside validateGrandTotal");
	  String product_total = driver.findElement(By.xpath("//table[@cellpadding='4' and @cellspacing='1']/tbody/tr[3]/td[3]")).getText();
	  //System.out.println("product_total_string" + product_total );
	  float product_total_float = Float.parseFloat(product_total.substring(2).trim());
	  System.out.println("product_total "+ product_total_float);
	  String sales_tax =  driver.findElement(By.xpath("//table[@cellpadding='4' and @cellspacing='1']/tbody/tr[4]/td[2]")).getText();
	  float sales_tax_float = Float.parseFloat(sales_tax.substring(2).trim());
	  System.out.println("sales_tax "+ sales_tax_float);
	  String shipping_handling = driver.findElement(By.xpath("//table[@cellpadding='4' and @cellspacing='1']/tbody/tr[5]/td[2]")).getText();
	  float shipping_handling_float = Float.parseFloat(shipping_handling.substring(2).trim());
	  System.out.println("shipping_handling "+ shipping_handling_float);
	  
	  float grand_total = product_total_float + sales_tax_float + shipping_handling_float;
	  System.out.println("grand_toatal " + grand_total );
			  
  }
//
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
	  
	  driver.get(propertiesObj.getProperty("GMOonlineURL"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	  
  }

  @AfterSuite
  public void afterSuite() {
	  //driver.close();
  }

}
