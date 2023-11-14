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

public class TestCase_23_VerifyAddress {
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
public void signUp() throws Exception {

	SignUpPage obj1= new SignUpPage();
	obj1.dashboard(driver);
	
	obj1.clicksignup();
	
	boolean signup = obj1.signupisdisplayed();
	Assert.assertEquals(signup, true,"SignUpIsNotVisible");
	System.out.println("'New User Signup!' is visible\n");
	
	obj1.enterusername("Aparna");
	obj1.enteremail("Aparnakota9@gmail.com");
	obj1.clicksignupButton();
	System.out.println("User SignedUp Successfully");
   
}
@Test(priority = 1)
public void enterActInfo() throws Exception {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	EnterAccountInfo AI= new EnterAccountInfo();
	AI.dashboard(driver);
	
	boolean EAI = AI.enterAccountInformationIsDisplayed();
	Assert.assertEquals(EAI, true,"[**EnterAccountInformationIsNotVisible**]");
	System.out.println("'ENTER ACCOUNT INFORMATION' is visible\n");
	
	AI.clickTitle();
	
	AI.enterPasswd("Aparnakota9");
	
	WebElement Day = AI.enterDay();
	Select obj = new Select(Day);
	obj.selectByVisibleText("9");
	js.executeScript("arguments[0].scrollIntoView();", Day );
	
	WebElement month = AI.enterMonth();
	Select obj1 = new Select(month);
	obj1.selectByVisibleText("November");
    js.executeScript("arguments[0].scrollIntoView();", month );
	
	WebElement year = AI.enterYear();
	Select obj2 = new Select(year);
	obj2.selectByVisibleText("1994");
	js.executeScript("arguments[0].scrollIntoView();", year );
	
	WebElement NL= AI.signUpNewsLetter();
	js.executeScript("arguments[0].scrollIntoView();",NL );
	AI.clickSignUpNewsLetter();
	
	WebElement SO = AI.secialOffers();
	js.executeScript("arguments[0].scrollIntoView();",SO );
	AI.clickSpecialOffers();
	
	WebElement FN = AI.firstName();
	js.executeScript("arguments[0].scrollIntoView();",FN );
	AI.enterfirstName("Aparna");
	
	WebElement LN = AI.lastName();
	js.executeScript("arguments[0].scrollIntoView();",LN );
	AI.enterlastName("Kota");
	
	AI.entercompanyName("EXCLR");
	AI.enterAddress1("Pune");
	AI.enterAddress2("Hyderabad");
	
	WebElement country = AI.clickCountry();
	Select obj3 = new Select(country);
	obj3.selectByVisibleText("India");
	
	AI.enterState("Maharashtra");
	AI.enterCity("Pune");
	AI.enterZipCode("411031");
	AI.enterMobileNo("9763229961");
	AI.clickCreateAccount();
	
	String AC= driver.getCurrentUrl();
	String expUrl1="https://automationexercise.com/account_created";
	Assert.assertEquals(AC, expUrl1,"[**'ACCOUNT CREATED!' is not visible**]");
	System.out.println("'ACCOUNT CREATED!' is visible\n");
	
	AI.clickContinue();
	
	boolean LU = AI.logedInAsUserIsDisplayed();
	Assert.assertEquals(LU,true,"[**'Logged in as username' is not visible**]");
	System.out.println("'Logged in as username'is visible\n");
	
	String str = AI.logedInAsUser();
	System.out.println(str);
}

@Test(priority = 1)
public void product() throws Exception {

	TC_14_PlaceOrder po = new TC_14_PlaceOrder();
	po.dashboard(driver);
	po.clickProduct();

	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement p1 = po.addtoCart1();
	js.executeScript("arguments[0].scrollIntoView();", p1);

	Actions act = new Actions(driver);
	act.moveToElement(p1).perform();

	String hp = driver.getCurrentUrl();
	String expUrl = "https://automationexercise.com/products";
	Assert.assertEquals(hp, expUrl, "[**user is not navigated to ALL PRODUCTS page**]");
	System.out.println("user is navigated to ALL PRODUCTS page successfully\n");

	po.clickAddtoCart();
	po.viewCart();
	String AD = driver.getCurrentUrl();
	String expUrl2 = "https://automationexercise.com/view_cart";
	Assert.assertEquals(AD, expUrl2, "[** cart page is not displayed **]");
	System.out.println("cart page is displayed");

	po.proceedToCart();

	String BillingAdd = po.billingAdd();
	System.out.println(BillingAdd);
	String DeliveryAdd = po.deliveryAdd();
	System.out.println(DeliveryAdd);

	EnterAccountInfo AI = new EnterAccountInfo();
	AI.dashboard(driver);
	String Address1 = AI.enterAddressGetText();
	String Address2 = AI.enterAddressGetText2();

	boolean add = BillingAdd.contains(Address1);
	boolean add1 = BillingAdd.contains(Address2);
	Assert.assertEquals(add, true);
	Assert.assertEquals(add1, true);
	System.out.println(" billing address is same address filled at the time registration of account");

	boolean add2 = DeliveryAdd.contains(Address1);
	boolean add3 = DeliveryAdd.contains(Address2);
	Assert.assertEquals(add2, true);
	Assert.assertEquals(add3, true);
	System.out.println(" billing address is same address filled at the time registration of account");

	AI.deleteAcount();
	String AD1 = driver.getCurrentUrl();
	String expUrl23 = "https://automationexercise.com/delete_account";
	Assert.assertEquals(AD1, expUrl23, "[** 'ACCOUNT DELETED!' is not visible**]");
	System.out.println(" 'ACCOUNT DELETED!' is visible\n");

	AI.clickconDel();
      
}
@AfterMethod 
public void closeApp()
{ 
	driver.close();
}	


}
