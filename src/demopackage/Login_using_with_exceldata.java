//package demopackage;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Iterator;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//
//
//public class Login_using_with_exceldata {
//	public static WebDriver driver;
//	String [][] data=null;
//	
//	@BeforeTest
//	public void browser_open() {
//		System.setProperty("webdriver.chrome.driver","\\Chromedriver\\chromedriver.exe");
//		driver=new ChromeDriver();
//		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.get("https://chp.paycentral.co.za/");
//		
//	}
//	@DataProvider(name="login_data")
//	public String[][] login_data_provider() throws BiffException, IOException 
//	{
//		data=readexcel();
//		return data;
//		
//	}
//	
////public String[][] readexcel() throws IOException {
////		
////		FileInputStream excel=new FileInputStream("C:\\Users\\Lakshmanan\\Desktop\\input.xlsx");
////		XSSFWorkbook workbook= new XSSFWorkbook(excel);
////		XSSFSheet sheet =workbook.getSheetAt(0);
////		Iterator<Row> rowIterator=sheet.iterator();
////		while(rowIterator.hasNext()) {
////			Row rowValue=rowIterator.next();
////			Iterator<Cell> columnIterator=rowValue.iterator();
////			int i=2;
////		while(columnIterator.hasNext())	{
////			if(i%2==0) {
////				userNameList.add(columnIterator.next().getStringCellValue());
////			}else {			
////				passwordList.add(columnIterator.next().getStringCellValue());
////			}
////			i++;
////		}
////		}
////	}
////	
//	public String[][] getexceldata() throws BiffException, IOException {
//		File file = new File("C:\\Users\\Lakshmanan\\Desktop\\Testdata.xls");
//		FileInputStream fis = new FileInputStream(file); 
//		Workbook workbook=Workbook.getWorkbook(fis);
//		Sheet sheet=workbook.getSheet("Sheet1");
//		int rows=sheet.getRows();
//		int columns=sheet.getColumns();
//		//System.out.println(rows);
//		//System.out.println(columns);
//		String inputdata[][]= new String[rows-1][columns];
//		for (int i=1; i<rows; i++) {
//			for(int j=0; j<columns;j++) {
//				inputdata[i-1][j]=sheet.getCell(j, i).getContents();
//				//System.out.println(inputdata [i][j]);
//				//System.exit(1);
//			}
//		}
//		return inputdata;
//	}
//	
//	@Test(dataProvider="login_data")
//	public void cardholderlogin(String Username,String Password) {
//		
//		
//		
//		WebElement username=driver.findElement(By.xpath("//input[@name='cardnumber']"));
//		username.sendKeys(Username);
//		
//		WebElement password=driver.findElement(By.xpath("//input[@name='ID Number']"));
//		password.sendKeys(Password);
//		
//		WebElement submit=driver.findElement(By.xpath("/html/body/app-root/app-auth/app-login/html/div[1]/div[2]/form/div/div[3]/div[2]/button"));
//		submit.click();
//		
//		
//	}
//	@AfterTest
//	public void browser_close() {
//		driver.close();
//	}
//
//
//}
