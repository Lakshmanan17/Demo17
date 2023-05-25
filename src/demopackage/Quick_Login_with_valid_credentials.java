package demopackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Quick_Login_with_valid_credentials {
	public static WebDriver driver;
	
	@BeforeMethod
	public void openBrowser()
	{ 

	driver = BrowserSelection.usingChrome(); 
	}
	
    @DataProvider(name="login_data")
	public String[][] login_data_provider(){
		return data;
	}
	
    String[][] data= {
    		//{"5192607817637308","GJj88HJ"},
    		//{"5192606747837474","GFHJ76878GVHJ"},
    	//	{"5192606747837474","GJj88HJ"},
    		{"5192607817637308","GFHJ76878GVHJ"}
    };
	
	@Test(dataProvider="login_data")
	public void cardholderlogin(String Username,String Password) throws InterruptedException {		
		driver.get("https://chp.paycentral.co.za/");
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver,30);
		WebElement username=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='cardnumber']")));
		username.sendKeys(Username);
		
		WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='ID Number']")));
		password.sendKeys(Password);
		
		WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-auth/app-login/html/div[1]/div[2]/form/div/div[3]/div[2]/button")));
		submit.click();
		
		Thread.sleep(7000);
		WebElement submit1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-base/div/div/div/div/app-dashboard/div[1]/div[3]/div[1]")));
		submit1.click();
		Thread.sleep(3000);
		submit1.click();
		Thread.sleep(7000);
		WebElement date01=driver.findElement(By.xpath("/html/body/app-root/app-base/div/div/div/div/app-statement/div[1]/div[2]/div[2]/form/div[1]/div/div/div/div/button"));
		date01.click();
		WebElement date=driver.findElement(By.xpath("//ngb-datepicker-month[@role='grid']"));
		List<WebElement> columns=date.findElements(By.tagName("div"));

		for (WebElement cell: columns){
		   //Select 13th Date 
		   if (cell.getText().equals("20")){
		      cell.findElement(By.linkText("20")).click();
		      break;
		 }
		
		
    	Thread.sleep(7000);
		WebElement date1=driver.findElement(By.xpath("//div[@id=\"todte\"]/div/button"));
        //date1.click();
		List<WebElement> columns1=date1.findElements(By.tagName("div"));

		for (WebElement cells: columns1){
		   //Select 13th Date 
		   if (cells.getText().equals("28")){
		      cells.findElement(By.linkText("28")).click();
		      break;
		 }
		
		
		driver.findElement(By.xpath("/html/body/app-root/app-base/div/div/div/div/app-statement/div[1]/div[2]/div[2]/form/div[3]/div/button[1]")).click();
	

		driver.close();
		
		
	}
		}
}}