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

import pageClasses.TC_08_ProductDetailPage;
import pageClasses.TC_14_PlaceOrder;
import pageClasses.TC_20_SearchProduct;

public class TestCase_20_SearchProducts {
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
	
	@Test(priority = 0)
	public void productDetails() throws Exception {
		TC_08_ProductDetailPage pd = new TC_08_ProductDetailPage();
		pd.dashboard(driver);
		pd.clickProduct();

		String hp = driver.getCurrentUrl();
		String expUrl = "https://automationexercise.com/products";
		Assert.assertEquals(hp, expUrl, "[**user is not navigated to ALL PRODUCTS page**]");
		System.out.println("user is navigated to ALL PRODUCTS page successfully\n");

		TC_20_SearchProduct se = new TC_20_SearchProduct();
		se.dashboard(driver);
		
		se.search("Colour Blocked Shirt – Sky Blue");
		se.searchbutton();
		
		String str = se.searchResult();
		
		String expected = "Colour Blocked Shirt – Sky Blue";
		if (str.contains(expected)) {
			System.out.println(str);
			System.out.println("SEARCHED PRODUCTS' is visible");
		} else {
			System.out.println("SEARCHED PRODUCTS' is not visible");
		}

		TC_14_PlaceOrder po = new TC_14_PlaceOrder();
		po.dashboard(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement p1 = po.addtoCart1();
		js.executeScript("arguments[0].scrollIntoView();", p1);

		Actions act = new Actions(driver);
		act.moveToElement(p1).perform();

		po.clickAddtoCart();
		po.viewCart();

		String str1 = se.cartdiscription();
		
		if (str1.contains("Colour Blocked Shirt – Sky Blue")) {
			System.out.println(str1);
			System.out.println("Selected products are visible in cart");
		} else {
			System.out.println("Selected products are not visible in cart");
		}
}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
