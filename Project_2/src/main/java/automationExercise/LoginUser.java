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
	public void SignIN() throws Exception {
		
		SignUpPage obj_1= new SignUpPage();
		obj_1.Dashboard(driver);
		obj_1.clickSignup();
		obj_1.enterUsername("Aparna");
		obj_1.enterEmail("Aparnakota9@gmail.com");
		obj_1.clickSignupButton();
		
		EnterAccountInfo AI= new EnterAccountInfo();
		AI.Dashboard(driver);
		AI.ClickTitle();
		AI.EnterPasswd("Aparnakota9");	
		WebElement Day = AI.EnterDay();
		Select obj = new Select(Day);
		obj.selectByVisibleText("9");
		WebElement month = AI.EnterMonth();
		Select obj1 = new Select(month);
		obj1.selectByVisibleText("November");
		WebElement year = AI.EnterYear();
		Select obj2 = new Select(year);
		obj2.selectByVisibleText("1994");
		AI.ClickSignUpNewsLetter();
		AI.ClickSpecialOffers();
		AI.EnterfirstName("Aparna");
		AI.EnterlastName("Kota");
		AI.EntercompanyName("EXCLR");
		AI.EnterAddress1("Pune");
		AI.EnterAddress2("Hyderabad");
		WebElement country = AI.ClickCountry();
		Select obj3 = new Select(country);
		obj3.selectByVisibleText("India");
		AI.EnterState("Maharashtra");
		AI.EnterCity("Pune");
		AI.EnterZipCode("411031");
		AI.EnterMobileNo("9763229961");
		AI.ClickCreateAccount();
		AI.ClickContinue();
		
		
	}
	
	@Test(priority = 1)
	public void Login() throws Exception {

    UserLogin obj1= new UserLogin();
		obj1.Dashboard(driver);
		
		obj1.clickSignup();
	boolean Login = obj1.LoginActIsDisplayed();
		Assert.assertEquals(Login, true,"'Login to your account' is not visible");
		System.out.println("'Login to your account' is visible");
		
		obj1.EnterEmailId("Aparnakota9@gmail.com");
	    obj1.EnterPasswd1("Aparnakota9");
	    obj1.ClickOnLogin();
	   
	boolean LU = obj1.LogedInAsUserIsDisplayed();
		Assert.assertEquals(LU,true,"[**'Logged in as username' is not visible**]");
		System.out.println("'Logged in as username'is visible\n");
		
		String str = obj1.LogedInAsUser();
		System.out.println(str);
		
	    obj1.DeleteAcount();
		String AD= driver.getCurrentUrl();
		String expUrl2="https://automationexercise.com/delete_account";
		Assert.assertEquals(AD, expUrl2,"[** 'ACCOUNT DELETED!' is not visible**]");
		System.out.println(" 'ACCOUNT DELETED!' is visible\n");
		
		obj1.ClickconDel();
	}
	@Test(priority = 2)
	public void LoginWithWrongPass() throws Exception {

    UserLogin obj1= new UserLogin();
		obj1.Dashboard(driver);
		
		obj1.clickSignup();
	boolean Login = obj1.LoginActIsDisplayed();
		Assert.assertEquals(Login, true,"'Login to your account' is not visible");
		System.out.println("'Login to your account' is visible\n");
		
		obj1.EnterEmailId("Aparnakota27@gmail.com");
	    obj1.EnterPasswd1("Aparnakota19");
	    obj1.ClickOnLogin();
	    String error = obj1.ErrorMsg();
	    System.out.println(error+"\n");
}
	@Test(priority = 3)
	public void ForLoggingOUT() throws Exception {

		UserLogin obj1 = new UserLogin();
		obj1.Dashboard(driver);

		obj1.clickSignup();
		
		boolean Login = obj1.LoginActIsDisplayed();
		Assert.assertEquals(Login, true, "'Login to your account' is not visible");
		System.out.println("'Login to your account' is visible\n");

		obj1.EnterEmailId("Aparnakota27@gmail.com");
		obj1.EnterPasswd1("Aparnakota9");
		obj1.ClickOnLogin();
		
		boolean LU = obj1.LogedInAsUserIsDisplayed();
		Assert.assertEquals(LU, true, "[**'Logged in as username' is not visible**]");
		System.out.println("'Logged in as username'is visible\n");

		String str = obj1.LogedInAsUser();
		System.out.println(str);

		obj1.ClickLogOut();
		
		String hp = driver.getCurrentUrl();
		String expUrl = "https://automationexercise.com/login";
		Assert.assertEquals(hp, expUrl, "[**user is not navigated to login page**]");
		System.out.println("user is navigated to login page successfully\n");
	}
	
	@Test(priority = 4)
	public void signExistingUser() throws Exception {
		
	    SignUpPage obj_1= new SignUpPage();
		obj_1.Dashboard(driver);
		
		obj_1.clickSignup();
		obj_1.enterUsername("Aparna");
		obj_1.enterEmail("Aparnakota27@gmail.com");
		obj_1.clickSignupButton();
		
		String error = obj_1.ErrorMsg();
	    System.out.println(error+"\n");
		}

	@AfterMethod 
	public void closeApp()
	{ 
		driver.close();
	}	
}
