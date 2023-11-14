package automationExercise;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClasses.category;

public class TestCase_18_viewCategory {
	WebDriver driver;

	@BeforeTest
	public void m() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\my lap\\Downloads\\eclipse-dsl-2022-09-R-win32-x86_64\\Jars\\chromedriver.exe");
		ChromeOptions	options = new ChromeOptions();
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
	@Test(priority = 1)
	public void Category() throws Exception {
		category ca = new category();
		ca.Dashboard(driver);
		String str = ca.Category();
		System.out.println(str);
		System.out.println("categories are visible on left side bar");
		
		ca.women();
		ca.dress();
		
		String hp= driver.getCurrentUrl();
		String expUrl="https://automationexercise.com/category_products/1";
		Assert.assertEquals(hp, expUrl,"[**category page is not displayed **]");
		System.out.println("category page is displayed \n");
		
		String str1=ca.DressProduct();
		System.out.println(str1+"\n");
		
		ca.men();
		ca.Jeans();
		
		String hp1= driver.getCurrentUrl();
		String expUrl1="https://automationexercise.com/category_products/6";
		Assert.assertEquals(hp1, expUrl1,"[**category page is not displayed **]");
		System.out.println("category page is displayed\n");
			
		String str2=ca.MenJeans();
		System.out.println(str2+"\n");
		}

	@AfterMethod
	public void closeApp() {
		driver.close();
	}
		
	}
	
	
	
	
	
	
	
