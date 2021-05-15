package com.assignment2.asert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class VerifyBlazeDemo {
	
	String projectPath;
	WebDriver driver;
	SoftAssert st;
 
  @BeforeTest
  public void preConditions() {
	  
	  projectPath= System.getProperty("user.dir");
	  System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  st=new SoftAssert();
	  
	  
  }
  
  @Test(priority=0, description="Verify home page title is BlazeDemo")
  public void getPageTitle() {
	  
	  driver.get("https://blazedemo.com/");
	  String homePageTitle=driver.getTitle();
	  st.assertEquals(homePageTitle, "BlazeDemo");
	  st.assertAll();
	  
  }
  
  @Test(priority=1, description="Verify after login pageLabel is Flights from Boston to London:")
  public void loginLabel() {
	  
	  WebElement fromCity= driver.findElement(By.cssSelector("select[name='fromPort']"));
	  Select s1= new Select(fromCity);
	  s1.selectByValue("Boston");
	  WebElement toCity= driver.findElement(By.cssSelector("select[name='toPort']"));
	  Select s2= new Select(toCity);
	  s2.selectByValue("London");
	  driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
	  String loginPageLabel= driver.findElement(By.xpath("/html/body/div[2]/h3")).getText();
	  st.assertEquals(loginPageLabel, "Flights from Boston to London:");
	  st.assertAll();
  }
  
  @Test(priority=2, description="Flight details")
  public void verifyFirstFlight() throws InterruptedException {
	  
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[1]/input")).click();
	 Thread.sleep(2000);
	 st.assertEquals(driver.getTitle(),"BlazeDemo Purchase");
	 System.out.println("TitleDetails="+driver.getTitle());
	 Thread.sleep(2000);
	 //verify label
	 String flightLabel= driver.findElement(By.xpath("/html/body/div[2]/h2")).getText();
	 st.assertEquals(flightLabel,"Your flight from TLV to SFO has been reserved.");
	 //verify Airline
	 String airline= driver.findElement(By.xpath("/html/body/div[2]/p[1]")).getText();
	 System.out.println("Airline details="+airline); 
	 st.assertTrue(airline.contains("United"),"Wrong flight details");
	 //verify flightNumber
	 String flightNumber=driver.findElement(By.xpath("/html/body/div[2]/p[2]")).getText();
	 System.out.println("FlightNumber="+flightNumber);
	 st.assertTrue(flightNumber.contains("UA954"),"Wrong flight number");
	 
	 //verify total cost
	 String priceText= driver.findElement(By.xpath("/html/body/div[2]/p[3]")).getText();
	 String price=priceText.substring(7);
	 System.out.println(price);
	 double priceNum= Double.valueOf(price);
	 System.out.println("price in double="+priceNum);
	 
	 String taxText= driver.findElement(By.xpath("/html/body/div[2]/p[4]")).getText();
	 String tax=taxText.substring(26);
	 System.out.println(tax);
	 double taxNum=Double.valueOf(tax);
	 System.out.println("tax in double="+taxNum);
	 
	 String totalCostText= driver.findElement(By.xpath("/html/body/div[2]/p[5]")).getText();
	 String totalCost=totalCostText.substring(12);
	 System.out.println("Total cost="+totalCost);
	 double totalCostNum= Double.valueOf(totalCost);
	 System.out.println("Total cost in double="+totalCostNum);
	 st.assertTrue(totalCostNum==(priceNum+taxNum),"Wrong total cost");
	 st.assertAll();
	  
  }
  
  @Test(priority=3, description="Verify Purchase flight form")
  public void purchaseFlightForm() throws InterruptedException {
	  
	  driver.findElement(By.id("inputName")).clear();
	  driver.findElement(By.id("inputName")).sendKeys("Jones Pence");
	  driver.findElement(By.id("address")).clear();
	  driver.findElement(By.id("address")).sendKeys("Observatory Circle, U.S");
	  driver.findElement(By.id("city")).sendKeys("Phoenix");
	  driver.findElement(By.id("state")).sendKeys("Arizona (AZ)");
	  driver.findElement(By.id("zipCode")).sendKeys("85001");
	  WebElement cardType= driver.findElement(By.id("cardType"));
	  Select card= new Select(cardType);
	  card.selectByValue("amex");
	  driver.findElement(By.id("creditCardNumber")).sendKeys("12345678");
	  driver.findElement(By.id("creditCardMonth")).clear();
	  driver.findElement(By.id("creditCardMonth")).sendKeys("12");
	  driver.findElement(By.id("creditCardYear")).clear();
	  driver.findElement(By.id("creditCardYear")).sendKeys("2018");
	  Thread.sleep(2000);
	  driver.findElement(By.id("nameOnCard")).clear();
	  driver.findElement(By.id("nameOnCard")).sendKeys("Jones Pence");
	
	  driver.findElement(By.id("rememberMe")).click();
	  driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
	  
	  //verify pageTitle
	  Thread.sleep(2000);
	 st.assertEquals(driver.getTitle(),"BlazeDemo Confirmation");
	 st.assertAll();
	  
  }

  @AfterTest
  public void afterTest() {
	  
	 driver.quit();
  }

}
