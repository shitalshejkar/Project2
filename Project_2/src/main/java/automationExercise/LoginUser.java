package automationExercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageClasses.EnterAccountInfo;
import pageClasses.SignUpPage;
import pageClasses.UserLogin;

public class LoginUser {
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
	public void signIN() throws Exception {
		
		SignUpPage obj_1= new SignUpPage();
		obj_1.dashboard(driver);;
		obj_1.clicksignup();
		obj_1.enterusername("Aparna");
		obj_1.enteremail("Aparnakota9@gmail.com");
		obj_1.clicksignupButton();
		
		EnterAccountInfo AI= new EnterAccountInfo();
		AI.dashboard(driver);;
		AI.clickTitle();
		AI.enterPasswd("Aparnakota9");	
		WebElement Day = AI.enterDay();
		Select obj = new Select(Day);
		obj.selectByVisibleText("9");
		WebElement month = AI.enterMonth();
		Select obj1 = new Select(month);
		obj1.selectByVisibleText("November");
		WebElement year = AI.enterYear();
		Select obj2 = new Select(year);
		obj2.selectByVisibleText("1994");
		AI.clickSignUpNewsLetter();
		AI.clickSpecialOffers();
		AI.enterfirstName("Aparna");
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
		AI.clickContinue();
		
		
	}
	
	@Test(priority = 1)
	public void login() throws Exception {

    UserLogin obj1= new UserLogin();
		obj1.dashboard(driver);;
		
		obj1.clickSignup();
	boolean Login = obj1.loginActIsDisplayed();
		Assert.assertEquals(Login, true,"'Login to your account' is not visible");
		System.out.println("'Login to your account' is visible");
		
		obj1.enterEmailId("Aparnakota9@gmail.com");
	    obj1.enterPasswd1("Aparnakota9");
	    obj1.clickOnLogin();
	   
	boolean LU = obj1.logedInAsUserIsDisplayed();
		Assert.assertEquals(LU,true,"[**'Logged in as username' is not visible**]");
		System.out.println("'Logged in as username'is visible\n");
		
		String str = obj1.logedInAsUser();
		System.out.println(str);
		
	    obj1.deleteAcount();
		String AD= driver.getCurrentUrl();
		String expUrl2="https://automationexercise.com/delete_account";
		Assert.assertEquals(AD, expUrl2,"[** 'ACCOUNT DELETED!' is not visible**]");
		System.out.println(" 'ACCOUNT DELETED!' is visible\n");
		
		obj1.clickconDel();
	}
	@Test(priority = 2)
	public void loginWithWrongPass() throws Exception {

    UserLogin obj1= new UserLogin();
		obj1.dashboard(driver);
		
		obj1.clickSignup();
	boolean Login = obj1.loginActIsDisplayed();
		Assert.assertEquals(Login, true,"'Login to your account' is not visible");
		System.out.println("'Login to your account' is visible\n");
		
		obj1.enterEmailId("Aparnakota27@gmail.com");
	    obj1.enterPasswd1("Aparnakota19");
	    obj1.clickOnLogin();
	    String error = obj1.errorMsg();
	    System.out.println(error+"\n");
}
	@Test(priority = 3)
	public void forLoggingOUT() throws Exception {

		UserLogin obj1 = new UserLogin();
		obj1.dashboard(driver);

		obj1.clickSignup();
		
		boolean Login = obj1.loginActIsDisplayed();
		Assert.assertEquals(Login, true, "'Login to your account' is not visible");
		System.out.println("'Login to your account' is visible\n");

		obj1.enterEmailId("Aparnakota27@gmail.com");
		obj1.enterPasswd1("Aparnakota9");
		obj1.clickOnLogin();
		
		boolean LU = obj1.logedInAsUserIsDisplayed();
		Assert.assertEquals(LU, true, "[**'Logged in as username' is not visible**]");
		System.out.println("'Logged in as username'is visible\n");

		String str = obj1.logedInAsUser();
		System.out.println(str);

		obj1.clickLogOut();
		
		String hp = driver.getCurrentUrl();
		String expUrl = "https://automationexercise.com/login";
		Assert.assertEquals(hp, expUrl, "[**user is not navigated to login page**]");
		System.out.println("user is navigated to login page successfully\n");
	}
	
	@Test(priority = 4)
	public void signExistingUser() throws Exception {
		
	    SignUpPage obj_1= new SignUpPage();
		obj_1.dashboard(driver);
		
		obj_1.clicksignup();
		obj_1.enterusername("Aparna");
		obj_1.enteremail("Aparnakota27@gmail.com");
		obj_1.clicksignupButton();
		
		String error = obj_1.errormsg();
	    System.out.println(error+"\n");
		}

	@AfterMethod 
	public void closeApp()
	{ 
		driver.close();
	}	
}
