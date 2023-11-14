package automationExercise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase_22_AddToCart {
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

	public void addtoCart() throws Exception {

		boolean we = driver.findElement(By.xpath("//*[text()='recommended items']")).isDisplayed();
		Assert.assertEquals(we, true, "'RECOMMENDED ITEMS' are not visible");
		System.out.println("'RECOMMENDED ITEMS' are visible");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement p1 = driver.findElement(By.xpath("//*[@class='recommended_items']"));
		js.executeScript("arguments[0].scrollIntoView();", p1);

		List<WebElement> list = driver.findElements(By.xpath("//*[@class='recommended_items']"));
		for (int i = 0; i < list.size(); i++) {
			String[] productname = list.get(i).getText().split("-");
			String frmtname = productname[0].trim();
			if (frmtname.contains("Winter Top")) {
				List<WebElement> list2 = driver.findElements(By.xpath("//*[text()='Add to cart']"));
				list2.get(i).click();
				System.out.println("Product Added to cart");
			                                     }
		                                      }
		}
	@AfterMethod 
	public void closeApp()
	{ 
		driver.close();
	}	
	
	
	
	
}
