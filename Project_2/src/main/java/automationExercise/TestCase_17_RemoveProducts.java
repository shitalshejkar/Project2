package automationExercise;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClasses.TC_14_PlaceOrder;

public class TestCase_17_RemoveProducts {
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

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement p1 = po.addtoCart1();
		js.executeScript("arguments[0].scrollIntoView();", p1);

		Actions act = new Actions(driver);
		act.moveToElement(p1).perform();

		String hp = driver.getCurrentUrl();
		String expUrl = "https://automationexercise.com/products";
		Assert.assertEquals(hp, expUrl, "[**user is not navigated to ALL PRODUCTS page**]");
		System.out.println("user is navigated to ALL PRODUCTS page successfully\n");

		po.clickAddtoCart();
		po.viewCart();
		String AD = driver.getCurrentUrl();
		String expUrl2 = "https://automationexercise.com/view_cart";
		Assert.assertEquals(AD, expUrl2, "[** cart page is not displayed **]");
		System.out.println("cart page is displayed");

		po.removeproduct();
		String ec = po.emptyCart();
		System.out.println(ec);

	}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}
