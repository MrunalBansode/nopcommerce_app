package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle rb;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br){
		rb = ResourceBundle.getBundle("config");
		logger = LogManager.getLogger(this.getClass());
	//	driver = new ChromeDriver();
		
		if(br.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if (br.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if (br.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL"));
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tesrDown() {
		driver.quit();
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
	}
	
	public String randomNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return(generatedString2);
	}
	
	public String randomalphanumeric() {
		String str = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		return(str+"*"+num);
	}
	
	public String captureScreen(String tname) throws IOException {
			
	  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
	  TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
	  File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
	  String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + " " + timeStamp + ".png";
			
			try {
				FileUtils.copyFile(source, new File(destination));
			} catch(Exception e) {
				e.getMessage();
			}
			return destination;
	}
}
