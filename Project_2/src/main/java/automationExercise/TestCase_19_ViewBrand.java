package automationExercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClasses.Brandpage;
import pageClasses.TC_14_PlaceOrder;

public class TestCase_19_ViewBrand {
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
	public void product() throws Exception {

		TC_14_PlaceOrder po = new TC_14_PlaceOrder();
		po.dashboard(driver);
		po.clickProduct();

		Brandpage br = new Brandpage();

		boolean brand = br.Brand();
		Assert.assertEquals(brand, true, "Brands are not visible on left side bar");
		System.out.println("Brands are visible on left side bar");

		String str = br.Brands();
		System.out.println(str);

		br.Brandname();
		String hp = driver.getCurrentUrl();
		String expUrl = "https://automationexercise.com/brand_products/Polo";
		Assert.assertEquals(hp, expUrl, "[**user is  not navigated to brand page and brand products are displayed **]");
		System.out.println("user is navigated to brand page and brand products are displayed \n");

		br.Brandname2();

		String hp1 = driver.getCurrentUrl();
		String expUrl1 = "https://automationexercise.com/brand_products/H&M";
		Assert.assertEquals(hp1, expUrl1,"[**user is  not navigated to brand page and brand products are displayed **]");
		System.out.println("user is navigated to that brand page and can see products\n");
	}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
	
	
	
	
	
}
