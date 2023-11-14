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

import pageClasses.SignUpPage;
import pageClasses.TC_14_PlaceOrder;
import pageClasses.EnterAccountInfo;
public class TestCase_14_PlaceOrder_wc {
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
		
		TC_14_PlaceOrder po =new TC_14_PlaceOrder();
		po.dashboard(driver);
		po.clickProduct();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement p1= po.addtoCart1();
		js.executeScript("arguments[0].scrollIntoView();", p1);
		
		Actions act = new Actions(driver);
		act.moveToElement(p1).perform();
	
		String hp= driver.getCurrentUrl();
		String expUrl="https://automationexercise.com/products";
		Assert.assertEquals(hp, expUrl,"[**user is not navigated to ALL PRODUCTS page**]");
		System.out.println("user is navigated to ALL PRODUCTS page successfully\n");
		
		po.clickAddtoCart();
		po.viewCart();
		String AD= driver.getCurrentUrl();
		String expUrl2="https://automationexercise.com/view_cart";
		Assert.assertEquals(AD, expUrl2,"[** cart page is not displayed **]");
		System.out.println("cart page is displayed");
		
		po.proceedToCart();
		po.register_Login();
		}
	
	@Test(priority = 2)
		public void signUp() throws Exception {		

			SignUpPage su = new SignUpPage();
			su.dashboard(driver);
			
			boolean signUp = su.signupisdisplayed();
			Assert.assertEquals(signUp, true, "User Signup is not displayed");
			System.out.println("User Signup is displayed");
			
			su.enterusername("Aparna");
			su.enteremail("Aparnakota09@gamil.com");
			su.clicksignupButton();
		}

		@Test(priority = 3)
		public void enterAccountInfo() throws Exception {
		
			EnterAccountInfo Ai = new EnterAccountInfo();
			Ai.dashboard(driver);
			
			boolean Acct = Ai.enterAccountInformationIsDisplayed();
			Assert.assertEquals(Acct, true, "Enter Account Information Is not Displayed");
			System.out.println("Enter Account Information Is Displayed");
			
			Ai.clickTitle();
			Ai.enterPasswd("Aparnakota9");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			WebElement Day = Ai.enterDay();
			Select obj = new Select(Day);
			obj.selectByVisibleText("9");
			js.executeScript("arguments[0].scrollIntoView();", Day);

			WebElement month = Ai.enterMonth();
			Select obj1 = new Select(month);
			obj1.selectByVisibleText("November");
			js.executeScript("arguments[0].scrollIntoView();", month);

			WebElement year = Ai.enterYear();
			Select obj2 = new Select(year);
			obj2.selectByVisibleText("1994");
			js.executeScript("arguments[0].scrollIntoView();", year);

			WebElement NL = Ai.signUpNewsLetter();
			js.executeScript("arguments[0].scrollIntoView();", NL);
			Ai.clickSignUpNewsLetter();

			WebElement SO = Ai.secialOffers();
			js.executeScript("arguments[0].scrollIntoView();", SO);
			Ai.clickSpecialOffers();

			WebElement FN = Ai.firstName();
			js.executeScript("arguments[0].scrollIntoView();", FN);
			Ai.enterfirstName("Aparna");

			WebElement LN = Ai.lastName();
			js.executeScript("arguments[0].scrollIntoView();", LN);
			Ai.enterlastName("Kota");

			Ai.entercompanyName("EXCLR");
			Ai.enterAddress1("Pune");
			Ai.enterAddress2("Hyderabad");

			WebElement country = Ai.clickCountry();
			Select obj3 = new Select(country);
			obj3.selectByVisibleText("India");

			Ai.enterState("Maharashtra");
			Ai.enterCity("Pune");
			Ai.enterZipCode("411031");
			Ai.enterMobileNo("9763229961");
			Ai.clickCreateAccount();

			String AC = driver.getCurrentUrl();
			String expUrl1 = "https://automationexercise.com/account_created";
			Assert.assertEquals(AC, expUrl1, "[**'ACCOUNT CREATED!' is not visible**]");
			System.out.println("'ACCOUNT CREATED!' is visible\n");

			Ai.clickContinue();

			boolean LU = Ai.logedInAsUserIsDisplayed();
			Assert.assertEquals(LU, true, "[**'Logged in as username' is not visible**]");
			System.out.println("'Logged in as username'is visible\n");

			String str = Ai.logedInAsUser();
			System.out.println(str);
		
		}

		@Test(priority = 4)
		public void cart() throws Exception {
			
			TC_14_PlaceOrder po =new TC_14_PlaceOrder();
			po.dashboard(driver);
			
			po.cart();
			po.proceedToCart();
			
			String BillingAdd =po.billingAdd();
			System.out.println(BillingAdd);
			String DeliveryAdd = po.deliveryAdd();
			System.out.println(DeliveryAdd);
			
			String CartInfo =po.cartInfo();
			System.out.println(CartInfo);
			po.comment("xyzproduct");
			po.placeOrder();
			
			po.nameOncard("Aparna");
			po.cardNumber("338899022383");
			po.cvc("311");
			po.expiry_month("09");
			po.expiry_year("2027");
			po.pay_submit();
			
			String successMsg = po.successMsg();
			System.out.println(successMsg);
			po.deleteAccnt();
			
			String AD= driver.getCurrentUrl();
			String expUrl2="https://automationexercise.com/delete_account";
			Assert.assertEquals(AD, expUrl2,"[** 'ACCOUNT DELETED!' is not visible**]");
			System.out.println(" 'ACCOUNT DELETED!' is visible\n");
			System.out.println("Your account has been permanently deleted!");
			
			po.continued();
			}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
		
}
