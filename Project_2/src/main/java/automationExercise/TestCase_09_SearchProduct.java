package automationExercise;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClasses.TC_08_ProductDetailPage;

public class TestCase_09_SearchProduct {
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
		pd.dashboard(driver);
		pd.clickProduct();
		
		String hp= driver.getCurrentUrl();
		
		String expUrl="https://automationexercise.com/products";
		Assert.assertEquals(hp, expUrl,"[**user is not navigated to ALL PRODUCTS page**]");
		System.out.println("user is navigated to ALL PRODUCTS page successfully\n");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement pr = pd.viewProduct();
		
		js.executeScript("arguments[0].scrollIntoView();", pr);
		
		pd.clickProduct();
		
		pd.searchProduct("Blue Top");
		System.out.println("products related to search are visible");
		}
	
	@Test(priority = 0)
	public void  subscription() throws Exception {
		
		TC_08_ProductDetailPage pd=new TC_08_ProductDetailPage();
		pd.dashboard(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sub = pd.subscription();
		js.executeScript("arguments[0].scrollIntoView();", sub);
		
		boolean su =pd.sub();
		Assert.assertEquals(su,true,"[**SUBSCRIPTION is not visible **]");
		System.out.println("SUBSCRIPTION is not visible");
		
		pd.enterSubEmail("Aparnakota27@gmail.com");
		pd.clickSubArrow();
		
		String str = pd.successMessg();
		System.out.println(str);
		}
	

@Test(priority = 0)
public void  subscriptionInCart() throws Exception {
	TC_08_ProductDetailPage pd=new TC_08_ProductDetailPage();
	pd.dashboard(driver);
	
	pd.clickCart();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement sub = pd.subscription();
	js.executeScript("arguments[0].scrollIntoView();", sub);
	
	boolean su =pd.sub();
	Assert.assertEquals(su,true,"[**SUBSCRIPTION is not visible **]");
	System.out.println("SUBSCRIPTION is not visible");
	
	pd.enterSubEmail("Aparnakota27@gmail.com");
	pd.clickSubArrow();
	
	String str = pd.successMessg();
	System.out.println(str);	
}
@AfterMethod 
public void closeApp()
{ 
	driver.close();
}	
}
