package demopackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Demo_scroll {
	public static WebDriver driver;
  @Test
  public void f() {
	  JavascriptExecutor je=(JavascriptExecutor)driver;
      
      //( (JavascriptExecutor)driver).executeScript("scroll 0,400");
		
		WebElement eve1=driver.findElement(By.xpath("//span[@title='Toy Fair - New York Event in pl1']"));
		
		je.executeScript("arguments[0].scrollIntoView(true);",eve1);
		eve1.click();
		
  }
}

