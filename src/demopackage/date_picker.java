package demopackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class date_picker {
	WebDriver driver;
	
	public void statement() {
		driver.findElement(By.xpath("/html/body/app-root/app-base/div/div/div/div/app-dashboard/div[1]/div[3]/div[1]/img")).click();
		WebElement date=driver.findElement(By.xpath("/html/body/app-root/app-base/div/div/div/div/app-statement/div[1]/div[2]/div[2]/form/div[1]/div/div/div/div/button"));
		date.sendKeys("30/7/2020"+Keys.ENTER);
		WebElement date1=driver.findElement(By.xpath("//div[@id=\"todte\"]/div/button"));
		date1.sendKeys("30/7/2021"+Keys.ENTER);
		driver.findElement(By.xpath("/html/body/app-root/app-base/div/div/div/div/app-statement/div[1]/div[2]/div[2]/form/div[3]/div/button[1]")).click();
	}

	
	public void statement1() throws InterruptedException {
WebElement date=driver.findElement(By.xpath("/html/body/app-root/app-base/div/div/div/div/app-statement/div[1]/div[2]/div[2]/form/div[1]/div/div/div/div/button"));
		
		List<WebElement> columns=date.findElements(By.tagName("div"));

		for (WebElement cell: columns){
		   //Select 13th Date 
		   if (cell.getText().equals("20")){
		      cell.findElement(By.linkText("20")).click();
		      break;
		 }
		
		
    	Thread.sleep(7000);
		WebElement date1=driver.findElement(By.xpath("//div[@id=\"todte\"]/div/button"));

		List<WebElement> columns1=date1.findElements(By.tagName("div"));

		for (WebElement cells: columns1){
		   //Select 13th Date 
		   if (cells.getText().equals("28")){
		      cells.findElement(By.linkText("28")).click();
		      break;
		 }
		
		
		driver.findElement(By.xpath("/html/body/app-root/app-base/div/div/div/div/app-statement/div[1]/div[2]/div[2]/form/div[3]/div/button[1]")).click();
		}
	}
}}

