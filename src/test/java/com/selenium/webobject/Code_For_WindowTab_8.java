package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_WindowTab_8 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
		w=new ChromeDriver();
		w.manage().window().maximize();	
		
	}

	@Test(priority=0,description="Test case to handle tab")
	public void Tab() throws Exception {
		
/*		w.get("https://demo.testfire.net/login.jsp");
            
        w.findElement(By.id("uid")).clear();
        w.findElement(By.id("uid")).sendKeys("admin");
        w.findElement(By.id("passw")).clear();
        w.findElement(By.id("passw")).sendKeys("admin");
        w.findElement(By.name("btnSubmit")).click();
        Thread.sleep(3000);
        
        WebElement link_Here=w.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_promo\"]/table/tbody/tr[3]/td/a"));
      //  link_Here.click();
        Thread.sleep(2000);
        
        
        Actions a = new Actions(w);
        link_Here.sendKeys(Keys.CONTROL, Keys.ENTER);
        Thread.sleep(2000);


        //Code to fetch number of window open by webdriver
        Set<String> window=w.getWindowHandles();

        //Code to convert window’s open into array
        Object[] win=window.toArray();

        System.out.println(win[0]);
        System.out.println(win[1]);

        w.switchTo().window(win[0].toString());
               System.out.println(w.getTitle());
        w.switchTo().window(win[1].toString());
         System.out.println(w.getTitle());

        
        

        w.findElement(By.name("passwd")).sendKeys("Test");
	
	*/
	}

	
	@Test(priority=1,description="Test case to handle Flipkart Tab")
	public void tabFlipkart() throws Exception {
		
		
		w.get("https://www.flipkart.com/home-kitchen/home-appliances/washing-machines/fully-automatic-front-load~function/pr?sid=j9e%2Cabm%2C8qx&otracker=nmenu_sub_TVs%20%26%20Appliances_0_Fully%20Automatic%20Front%20Load");
		
		w.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[1]/div[1]")).click();
		
        Thread.sleep(2000);
        
        Set<String> tab=w.getWindowHandles();        
        System.out.println(tab);
        
        Object [] splitWindow=tab.toArray();
        
        System.out.println("Tab 1 : "+splitWindow[0]);
        System.out.println("Tab 2 : "+splitWindow[1]);
        
        w.switchTo().window(splitWindow[0].toString());
        System.out.println("Tab 1 Title : "+w.getTitle());
        
        Thread.sleep(2000);

        w.switchTo().window(splitWindow[1].toString());
        System.out.println("Tab 2 Title : "+w.getTitle());
      
		
	}
	@AfterTest
	public void afterTest() {
	}

}
