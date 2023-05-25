package demopackage;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_with_exceldata_using_POI {
	public static WebDriver driver;
	static List<String> userNameList=new ArrayList<String>();
	static List<String> passwordList=new ArrayList<String>();
	
	@SuppressWarnings("resource")
	public void readexcel() throws IOException {
		
		FileInputStream excel=new FileInputStream("C:\\Users\\Lakshmanan\\Desktop\\input.xlsx");
		Workbook workbook= new XSSFWorkbook(excel);
		Sheet sheet =workbook.getSheetAt(0);
		Iterator<Row> rowIterator=sheet.iterator();
		while(rowIterator.hasNext()) {
			Row rowValue=rowIterator.next();
			Iterator<Cell> columnIterator=rowValue.iterator();
			int i=2;
		while(columnIterator.hasNext())	{
			if(i%2==0) {
				userNameList.add(columnIterator.next().getStringCellValue());
			}else {			
				passwordList.add(columnIterator.next().getStringCellValue());
			}
			i++;
		}
		}
	}
	
	public void login(String Username,String Password) {
		System.setProperty("webdriver.chrome.driver","\\Chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://chp.paycentral.co.za/");
		WebElement username=driver.findElement(By.xpath("//input[@name='cardnumber']"));
		username.sendKeys(Username);
		
		WebElement password=driver.findElement(By.xpath("//input[@name='ID Number']"));
		password.sendKeys(Password);
		
		WebElement submit=driver.findElement(By.xpath("/html/body/app-root/app-auth/app-login/html/div[1]/div[2]/form/div/div[3]/div[2]/button"));
		submit.click();
		driver.quit();
	}
	
	public void executeTest() {
		for(int i=0; i<userNameList.size();i++) {
			login(userNameList.get(i), passwordList.get(i));
			
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Login_with_exceldata_using_POI usingPOI= new Login_with_exceldata_using_POI();
		usingPOI.readexcel();
		System.out.println("userNameList"+ userNameList);
		System.out.println("passwordList"+ passwordList);
		usingPOI.executeTest();

	}

}
