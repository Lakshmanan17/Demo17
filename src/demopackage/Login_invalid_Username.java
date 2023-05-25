package demopackage;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_invalid_Username {
	public static WebDriver driver;
	
	@Test
	@Parameters({"Username","Password"})
	public void cardholderlogin(String Username,String Password) {
		System.setProperty("webdriver.chrome.driver","\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://chp.paycentral.co.za/");
		WebDriverWait wait= new WebDriverWait(driver,20);
		WebElement username=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='cardnumber']")));
		username.sendKeys(Username);
		
		WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='ID Number']")));
		password.sendKeys(Password);
		
		WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-auth/app-login/html/div[1]/div[2]/form/div/div[3]/div[2]/button")));
		submit.click();
		driver.quit();
		
	}

}
