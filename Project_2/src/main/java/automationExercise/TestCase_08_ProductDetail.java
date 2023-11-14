package automationExercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageClasses.TC_08_ProductDetailPage;

public class TestCase_08_ProductDetail {
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
	public void  ProductDetails() throws Exception {
		
		TC_08_ProductDetailPage pd=new TC_08_ProductDetailPage();
		pd.Dashboard(driver);
		pd.ClickProduct();
		
		String hp= driver.getCurrentUrl();
		String expUrl="https://automationexercise.com/products";
		Assert.assertEquals(hp, expUrl,"[**user is not navigated to ALL PRODUCTS page**]");
		System.out.println("user is navigated to ALL PRODUCTS page successfully\n");
		
		pd.ClickViewProduct();
		
		String vp= driver.getCurrentUrl();
		String expUrl1="https://automationexercise.com/product_details/2";
		Assert.assertEquals(vp, expUrl1,"[** User is not landed to product detail page**]");
		System.out.println(" User is landed to product detail page successfully\n");
		
		boolean category = pd.categoryIsDisplayed();
		Assert.assertEquals(category,true,"[**Category of Product is not visible**]");
		System.out.println("Category of Product is visible");
		
		boolean Price= pd.PriceIsDisplayed();
		Assert.assertEquals(Price,true,"[**Price of Product is not visible**]");
		System.out.println("Price of Product is visible");
		
		boolean Aval = pd.AvalIsDisplayed();
		Assert.assertEquals(Aval,true,"[**Availability of Product is not visible**]");
		
		boolean cond = pd.CondIsDisplayed();
		Assert.assertEquals(cond,true,"[**Condition of Product is not visible**]");
		
		boolean brand = pd.BrandIsDisplayed();
		Assert.assertEquals(brand,true,"[**Price of Product is not visible**]");
		}
	
	@AfterMethod 
	public void closeApp()
	{ 
		driver.close();
	}	
}
