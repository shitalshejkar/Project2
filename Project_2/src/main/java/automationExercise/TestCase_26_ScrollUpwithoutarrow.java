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
import pageClasses.TC_25_26;

public class TestCase_26_ScrollUpwithoutarrow {
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
	public void  scrollUp() throws Exception {
		TC_08_ProductDetailPage pd=new TC_08_ProductDetailPage();
		pd.dashboard(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sub = pd.subscription();
		js.executeScript("arguments[0].scrollIntoView();", sub);
		
		boolean su =pd.sub();
		Assert.assertEquals(su,true,"[**SUBSCRIPTION is not visible **]");
		System.out.println("SUBSCRIPTION is visible");
		
		TC_25_26 tc = new TC_25_26();
		tc.dashboard(driver);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement sub1 = tc.scrolledupIntoView();
		js1.executeScript("arguments[0].scrollIntoView();", sub1);
		
		String str = tc.scrolledup();
		
		if(str.contains("Full-Fledged practice website for Automation Engineers")) {
		System.out.println("'Full-Fledged practice website for Automation Engineers' text is visible on screen\n");
		}else {
			System.out.println("No text is visible on screen\n");
		}
		
		}
@AfterMethod 
		public void closeApp()
		{ 
			driver.close();
		}	
		
		
	}

