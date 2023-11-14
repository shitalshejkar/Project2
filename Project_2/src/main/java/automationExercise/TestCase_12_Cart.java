package automationExercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClasses.TC_12_Cartpage;

public class TestCase_12_Cart {
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
	public void Product() throws Exception {
		
		TC_12_Cartpage AI= new TC_12_Cartpage();
		AI.Dashboard(driver);
		AI.CickProduct();
		
		Actions act = new Actions(driver);
		
		WebElement p1= AI.bluetop1();
		act.moveToElement(p1).perform();
		
		String Prod1= AI.bluetop();
		System.out.println(Prod1);
		
		AI.AddtoCart();
		AI.Continue();
		
		WebElement p2=AI.menTshirt1();
		act.moveToElement(p2).perform();
		
		String Prod2= AI.bluetop();
		System.out.println(Prod2);
		
		AI.AddtoCart2();
		AI.viewCart();
		String prodOfCart1=AI.Product1();
		String prodOfCart2=AI.Product2();
		
		Assert.assertEquals(Prod1, prodOfCart1, "required product not added");
		Assert.assertEquals(Prod2, prodOfCart2,"required product not added");
		
		System.out.println("both products are added to Cart");
	}	
	
@Test(priority = 1)
		public void ProductDetail() throws Exception {	

			TC_12_Cartpage Ai = new TC_12_Cartpage();
			Ai.Dashboard(driver);

			driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();
			String hp = driver.getCurrentUrl();
			String expUrl = "https://automationexercise.com/product_details/1";
			Assert.assertEquals(hp, expUrl, "[**product detail is not opened**]");
			System.out.println("product detail is opened successfully\n");

			for (int i = 1; i < 4; i++) {
				WebElement qa = Ai.ProdQuantity();
				qa.sendKeys(Keys.ARROW_UP);
			}
			
			String quan = driver.findElement(By.id("quantity")).getAttribute("value");
			System.out.println("quantity increased to : " + quan);
			driver.findElement(By.xpath("//*[@type='button']")).click();
			driver.findElement(By.xpath("//*[text()='View Cart']")).click();
            String quatInCart = driver.findElement(By.xpath("//*[text()='4']")).getText();
			System.out.println("product is displayed in cart page with exact quantity : " + quatInCart);
}
@AfterMethod 
public void closeApp()
{ 
	driver.close();
}	
}
