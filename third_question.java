package com.selenium_assesment.selenium_assesment;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class third_question {
	WebDriver driver=null;
	@BeforeTest
	public void browser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	     driver=new ChromeDriver();	driver.manage().window().maximize();
		driver.get("https://demoqa.com/webtables");
		Thread.sleep(9000);
	}
	@Test
public void delete_edit() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"edit-record-1\"]/svg")).click();
	Thread.sleep(8000);
		
		driver.findElement(By.xpath("//*[@id=\"delete-record-2\"]/svg/path")).click();
		Thread.sleep(5000);
}
}
