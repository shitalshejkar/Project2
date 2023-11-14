package automationExercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase_07_TestcasePage {
	WebDriver driver;

@BeforeTest
	public void m() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\my lap\\Downloads\\eclipse-dsl-2022-09-R-win32-x86_64\\Jars\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://automationexercise.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		
		String hp= driver.getCurrentUrl();
		String expUrl="https://automationexercise.com/";
		Assert.assertEquals(hp, expUrl,"[**HomePageIsNotVissible**]");
		System.out.println("home page is visible successfully\n");
	}
	@Test(priority = 0)
	public void TestCasepage() throws Exception {
		
	WebElement TestcaseLink = driver.findElement(By.xpath("//*[text()=' Test Cases']"));
	TestcaseLink.click();
	String hp= driver.getCurrentUrl();
	String expUrl="https://automationexercise.com/test_cases";
	Assert.assertEquals(hp, expUrl,"[**user is not navigated to test cases page**]");
	System.out.println("user is navigated to test cases pagesuccessfully\n");
	}
	
	@AfterMethod 
	public void closeApp()
	{ 
		driver.close();
	}	
}
