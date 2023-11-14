package automationExercise;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClasses.EnterAccountInfo;
import pageClasses.SignUpPage;
import pageClasses.TC_14_PlaceOrder;

public class TestCase_15_PlaceOrder_Bc {
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
	public void signUp() throws Exception {		

		SignUpPage su = new SignUpPage();
		su.Dashboard(driver);
		
		su.clickSignup();
		
		boolean signUp = su.SignupIsDisplayed();
		Assert.assertEquals(signUp, true, "User Signup is not displayed");
		System.out.println("User Signup is displayed");
		
		su.enterUsername("Aparna");
		su.enterEmail("Aparnakota09@gamil.com");
		su.clickSignupButton();
	}

	@Test(priority = 2)
	public void EnterAccountInfo() throws Exception {
	
    EnterAccountInfo Ai= new EnterAccountInfo();
    Ai.Dashboard(driver);
	
    boolean Acct = Ai.EnterAccountInformationIsDisplayed();
	Assert.assertEquals(Acct, true, "Enter Account Information Is not Displayed");
	System.out.println("Enter Account Information Is Displayed");
	
	Ai.ClickTitle();
	Ai.EnterPasswd("Aparnakota9");
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	WebElement Day = Ai.EnterDay();
	Select obj = new Select(Day);
	obj.selectByVisibleText("9");
	js.executeScript("arguments[0].scrollIntoView();", Day );
	
	WebElement month = Ai.EnterMonth();
	Select obj1 = new Select(month);
	obj1.selectByVisibleText("November");
    js.executeScript("arguments[0].scrollIntoView();", month );
	
	WebElement year = Ai.EnterYear();
	Select obj2 = new Select(year);
	obj2.selectByVisibleText("1994");
	js.executeScript("arguments[0].scrollIntoView();", year );
	
	WebElement NL= Ai.SignUpNewsLetter();
	js.executeScript("arguments[0].scrollIntoView();",NL );
	Ai.ClickSignUpNewsLetter();
	
	WebElement SO = Ai.SpecialOffers();
	js.executeScript("arguments[0].scrollIntoView();",SO );
	Ai.ClickSpecialOffers();
	
	WebElement FN = Ai.firstName();
	js.executeScript("arguments[0].scrollIntoView();",FN );
	Ai.EnterfirstName("Aparna");
	
	WebElement LN = Ai.lastName();
	js.executeScript("arguments[0].scrollIntoView();",LN );
	Ai.EnterlastName("Kota");
	
	Ai.EntercompanyName("EXCLR");
	Ai.EnterAddress1("Pune");
	Ai.EnterAddress2("Hyderabad");
	
	WebElement country = Ai.ClickCountry();
	Select obj3 = new Select(country);
	obj3.selectByVisibleText("India");
	
	Ai.EnterState("Maharashtra");
	Ai.EnterCity("Pune");
	Ai.EnterZipCode("411031");
	Ai.EnterMobileNo("9763229961");
	Ai.ClickCreateAccount();
	
	String AC= driver.getCurrentUrl();
	String expUrl1="https://automationexercise.com/account_created";
	Assert.assertEquals(AC, expUrl1,"[**'ACCOUNT CREATED!' is not visible**]");
	System.out.println("'ACCOUNT CREATED!' is visible\n");
	
	Ai.ClickContinue();
	
	boolean LU = Ai.LogedInAsUserIsDisplayed();
	Assert.assertEquals(LU,true,"[**'Logged in as username' is not visible**]");
	System.out.println("'Logged in as username'is visible\n");
	
	String str = Ai.LogedInAsUser();
	System.out.println(str);
	
	}
	
	@Test(priority = 3)
	public void Product() throws Exception {
		
		TC_14_PlaceOrder po =new TC_14_PlaceOrder();
		po.Dashboard(driver);
		po.CickProduct();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement p1= po.AddtoCart1();
		js.executeScript("arguments[0].scrollIntoView();", p1);
		
		Actions act = new Actions(driver);
		act.moveToElement(p1).perform();
	
		String hp= driver.getCurrentUrl();
		String expUrl="https://automationexercise.com/products";
		Assert.assertEquals(hp, expUrl,"[**user is not navigated to ALL PRODUCTS page**]");
		System.out.println("user is navigated to ALL PRODUCTS page successfully\n");
		
		po.ClickAddtoCart();
		po.ViewCart();
		
		String AD= driver.getCurrentUrl();
		String expUrl2="https://automationexercise.com/view_cart";
		Assert.assertEquals(AD, expUrl2,"[** cart page is not displayed **]");
		System.out.println("cart page is displayed");
		
		po.ProceedToCart();
		po.Register_Login();
		
	}
	@Test(priority = 4)
	public void Cart() throws Exception {
		
		TC_14_PlaceOrder po =new TC_14_PlaceOrder();
		po.Dashboard(driver);
		
		po.cart();
		po.ProceedToCart();
		
		String BillingAdd =po.BillingAdd();
		System.out.println(BillingAdd);
		String DeliveryAdd = po.DeliveryAdd();
		System.out.println(DeliveryAdd);
		
		String CartInfo =po.CartInfo();
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
		
		String AD= driver.getCurrentUrl();
		String expUrl2="https://automationexercise.com/delete_account";
		Assert.assertEquals(AD, expUrl2,"[** 'ACCOUNT DELETED!' is not visible**]");
		System.out.println(" 'ACCOUNT DELETED!' is visible\n");
		System.out.println("Your account has been permanently deleted!");
		
		po.Continue();
		}
@AfterMethod
public void closeApp() {
	driver.close();
}
	
	
	
	
	
}
