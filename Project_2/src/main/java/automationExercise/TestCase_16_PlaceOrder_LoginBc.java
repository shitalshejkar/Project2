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
import pageClasses.UserLogin;

public class TestCase_16_PlaceOrder_LoginBc {
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
	public void Login() throws Exception {

		UserLogin obj1 = new UserLogin();
		obj1.Dashboard(driver);

		obj1.clickSignup();
		boolean Login = obj1.LoginActIsDisplayed();
		Assert.assertEquals(Login, true, "'Login to your account' is not visible");
		System.out.println("'Login to your account' is visible");

		obj1.EnterEmailId("Aparnakota90@gmail.com");
		obj1.EnterPasswd1("Aparnakota9");
		obj1.ClickOnLogin();

		boolean LU = obj1.LogedInAsUserIsDisplayed();
		Assert.assertEquals(LU, true, "[**'Logged in as username' is not visible**]");
		System.out.println("'Logged in as username'is visible\n");

		String str = obj1.LogedInAsUser();
		System.out.println(str);
	}

	@Test(priority = 1)
	public void Product() throws Exception {

		TC_14_PlaceOrder po = new TC_14_PlaceOrder();
		po.Dashboard(driver);
		po.CickProduct();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement p1 = po.AddtoCart1();
		js.executeScript("arguments[0].scrollIntoView();", p1);

		Actions act = new Actions(driver);
		act.moveToElement(p1).perform();

		String hp = driver.getCurrentUrl();
		String expUrl = "https://automationexercise.com/products";
		Assert.assertEquals(hp, expUrl, "[**user is not navigated to ALL PRODUCTS page**]");
		System.out.println("user is navigated to ALL PRODUCTS page successfully\n");

		po.ClickAddtoCart();
		po.ViewCart();
		String AD = driver.getCurrentUrl();
		String expUrl2 = "https://automationexercise.com/view_cart";
		Assert.assertEquals(AD, expUrl2, "[** cart page is not displayed **]");
		System.out.println("cart page is displayed");

		po.ProceedToCart();

	}

	@Test(priority = 4)
	public void Cart() throws Exception {

		TC_14_PlaceOrder po = new TC_14_PlaceOrder();
		po.Dashboard(driver);

		String BillingAdd = po.BillingAdd();
		System.out.println(BillingAdd);
		String DeliveryAdd = po.DeliveryAdd();
		System.out.println(DeliveryAdd);

		String CartInfo = po.CartInfo();
		System.out.println(CartInfo);
		po.Comment("xyzproduct");
		po.placeOrder();

		po.nameOncard("Aparna");
		po.cardNumber("338899022383");
		po.cvc("311");
		po.expiry_month("09");
		po.expiry_year("2027");
		po.Pay_submit();
		
		String successMsg = po.successMsg();
		System.out.println(successMsg);
		
		po.deleteAccnt();
		
		String AD = driver.getCurrentUrl();
		String expUrl2 = "https://automationexercise.com/delete_account";
		Assert.assertEquals(AD, expUrl2, "[** 'ACCOUNT DELETED!' is not visible**]");
		System.out.println(" 'ACCOUNT DELETED!' is visible\n");
		System.out.println("Your account has been permanently deleted!");
		
		po.Continue();
	}

	@AfterMethod
	public void closeApp() {
		driver.close();
	}
	
}
