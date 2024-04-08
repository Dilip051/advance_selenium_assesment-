package com.selenium_assesment.selenium_assesment;

import java.io.File;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoqa_form {
	WebDriver driver=null;
	@BeforeTest
public void browser() throws InterruptedException {
  WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();	driver.manage().window().maximize();
	driver.get("https://demoqa.com/automation-practice-form");
	Thread.sleep(3000);
   }
	@Test
	private void form() throws InterruptedException {
		
//		16-november-2002
		String expectedDay="16";
		String expectedMonthyear="November 2002";
		
		driver.findElement(By.id("firstName")).sendKeys("Dilip");
		Thread.sleep(2000);
		driver.findElement(By.id("lastName")).sendKeys("Makvana");
		Thread.sleep(2000);
		driver.findElement(By.id("userEmail")).sendKeys("makvanadilip051@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("userNumber")).sendKeys("9429684965");
		Thread.sleep(2000);
//		
//		for calender
		
		WebElement datepicker=driver.findElement(By.id("dateOfBirthInput"));
		datepicker.click();
		Thread.sleep(2000);
		while (true) {
			String calenderMontYear=driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]")).getText();
//			if (calenderMontYear.equals(expectedMonthyear)) {
//				driver.findElement(By.xpath("//div[text()=' " +expectedDay+"']")).click();
////				break;
////				
//			} 
//		
//			else {
//               driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/button[2]")).click();
//			}
//			break;
			System.out.println(calenderMontYear);
		}
		
}
	public void afterdate_select() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]")).sendKeys("type of subject...");
		Thread.sleep(2000);
		
		for (int i = 0; i <1; i++) {
			driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"+i)).click();
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		
		 WebElement fileInput = driver.findElement(By.id("uploadPicture"));
		// Provide the path of the file to be uploaded
	        String filePath = "\"D:\\IELTS\\Spoken International.pdf"; // Change this to the path of your file
	        File file = new File(filePath);
	        fileInput.sendKeys(file.getAbsolutePath());
	        Thread.sleep(2000);
	        
	        driver.findElement(By.id("currentAddress")).sendKeys("varachha,surat");
	        Thread.sleep(2000);
	        
	       driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]")).click();
	       Thread.sleep(1000);
	       driver.findElement(By.xpath("//div[text()='NCR']")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[1]")).click();
	       Thread.sleep(1000);
	       driver.findElement(By.xpath("//div[text()='Noida']")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.id("submit")).click();
	       Thread.sleep(2000);
	       driver.close();
	       
	}
}

