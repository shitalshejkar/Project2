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
import pageClasses.TC_21_AddReview;

public class TestCase_21_AddReview {
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
	public void ProductReview() throws Exception {
		
		TC_08_ProductDetailPage pd = new TC_08_ProductDetailPage();
		pd.Dashboard(driver);
		pd.ClickProduct();

		String hp = driver.getCurrentUrl();
		String expUrl = "https://automationexercise.com/products";
		Assert.assertEquals(hp, expUrl, "[**user is not navigated to ALL PRODUCTS page**]");
		System.out.println("user is navigated to ALL PRODUCTS page successfully\n");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement p1 = pd.mousehoverViewProduct();
		js.executeScript("arguments[0].scrollIntoView();", p1);
		pd.ClickViewProduct();

		String vp = driver.getCurrentUrl();
		String expUrl1 = "https://automationexercise.com/product_details/2";
		Assert.assertEquals(vp, expUrl1, "[** User is not landed to product detail page**]");
		System.out.println(" User is landed to product detail page successfully\n");

		TC_21_AddReview Ar = new TC_21_AddReview();

		Ar.Dashboard(driver);
		boolean wr = Ar.writeReview();
		Assert.assertEquals(wr, true, "[** 'Write Your Review' is not visible**]");
		System.out.println("'Write Your Review' is visible\n");

		Ar.Name("Aparna");
		Ar.email("Aparnakota09@gmail.com");
		Ar.Addreviewhere("Very Good Product");
		Ar.submit();

		String str = Ar.successmsg();
		System.out.println(str + "\n");

	}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}
