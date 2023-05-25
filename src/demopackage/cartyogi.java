package demopackage;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class cartyogi {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeSuite
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","\\Chromedriver\\chromedriver.exe");		
		driver=new ChromeDriver();
	 //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	WebDriverWait wait= new WebDriverWait(driver,10);
	driver.get("http://fishermanmarket.in/adminindex.html#!/");
	
	WebElement login=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div[14]/button")));
	login.click(); 
	Thread.sleep(20000);
	driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[2]/div[15]/div/button[1]")).click();
	
}
	@Test(priority = 0)
	public void product_details() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='bs-example-navbar-collapse-1']/ul/li[3]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@id='menuShow']/li[1]/a")).click();		
		
//		Select category=new Select(driver.findElement(By.id("Subcategory")));
//		category.selectByVisibleText("Fishes");
//		Select warehouse=new Select(driver.findElement(By.xpath("//div[@id=\"page-wrapper\"]/div/div[1]/div[2]/div/div[2]/form/div[1]/div[2]/div/div[2]/select")));
//		warehouse.selectByVisibleText("kumar");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//select[@id='Subcategory']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='Subcategory']/option[4]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[1]/div[2]/div/div[2]/form/div[1]/div[2]/div/div[2]/select")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div[1]/div[2]/div/div[2]/form/div[1]/div[2]/div/div[2]/select/option[2]")).click();
		Thread.sleep(2000);
		WebElement cli=driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[3]/div/div[1]/div[1]/div/div[2]/form/div[2]/div[4]/div[4]/div[1]/div/input"));
		cli.click();
				cli.sendKeys("Demo product title");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[3]/div/div[1]/div[1]/div/div[2]/form/div[2]/div[5]/div/div/input")).sendKeys("1");
		
		
		JavascriptExecutor je=(JavascriptExecutor)driver;
        
	       //( (JavascriptExecutor)driver).executeScript("scroll 0,400");
			
			WebElement eve1=driver.findElement(By.xpath("//input[@id='VariantPrice1']"));
			
			je.executeScript("arguments[0].scrollIntoView(true);",eve1);
			eve1.click();
			eve1.sendKeys("1");
		
//		WebElement mrp=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='VariantPrice1']")));
//		mrp.sendKeys("1");
		
		WebElement sell=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='VariantSellingPrice1']")));
		sell.sendKeys("1");
		
		WebElement desc1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[3]/div/div[1]/div[2]/div/div[2]/form/div[8]/div[1]/input")));
		desc1.sendKeys("Demo");
		
		WebElement desc2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[3]/div/div[1]/div[2]/div/div[2]/form/div[8]/div[2]/input")));
		desc2.sendKeys("Demo");
		
		WebElement desc3=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[3]/div/div[1]/div[2]/div/div[2]/form/div[9]/div[1]/input")));
		desc3.sendKeys("Demo");
		
		WebElement spec1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[3]/div/div[1]/div[2]/div/div[2]/form/div[13]/div[2]/input")));
		spec1.sendKeys("Demo product Specification");
		
		WebElement spec2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[1]/div[3]/div/div[1]/div[2]/div/div[2]/form/div[13]/div[3]/input")));
		spec2.sendKeys("Demo product Specification1");
		
		WebElement Save=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='productsavedes']")));
		Save.click();
				
	}
	
	@Test(priority = 1)
	public void Edit_product_details() throws InterruptedException {
		Thread.sleep(10000);
		WebElement edit=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"page-wrapper\"]/div/div[2]/div/table/tbody/tr[1]/td[8]/span/a/img")));
		edit.click();
	}
}


	