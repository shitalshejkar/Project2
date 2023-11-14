package automationExercise;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
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

public class SignUp {

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
	obj1.Dashboard(driver);
	
	obj1.clickSignup();
	
	boolean signup = obj1.SignupIsDisplayed();
	Assert.assertEquals(signup, true,"SignUpIsNotVisible");
	System.out.println("'New User Signup!' is visible\n");
	
	obj1.enterUsername("Aparna");
	obj1.enterEmail("Aparnakota9@gmail.com");
	obj1.clickSignupButton();
	System.out.println("User SignedUp Successfully");
   
}
@Test(priority = 1)
public void EnterActInfo() throws Exception {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	EnterAccountInfo AI= new EnterAccountInfo();
	AI.Dashboard(driver);
	
	boolean EAI = AI.EnterAccountInformationIsDisplayed();
	Assert.assertEquals(EAI, true,"[**EnterAccountInformationIsNotVisible**]");
	System.out.println("'ENTER ACCOUNT INFORMATION' is visible\n");
	
	AI.ClickTitle();
	
	AI.EnterPasswd("Aparnakota9");
	
	WebElement Day = AI.EnterDay();
	Select obj = new Select(Day);
	obj.selectByVisibleText("9");
	js.executeScript("arguments[0].scrollIntoView();", Day );
	
	WebElement month = AI.EnterMonth();
	Select obj1 = new Select(month);
	obj1.selectByVisibleText("November");
    js.executeScript("arguments[0].scrollIntoView();", month );
	
	WebElement year = AI.EnterYear();
	Select obj2 = new Select(year);
	obj2.selectByVisibleText("1994");
	js.executeScript("arguments[0].scrollIntoView();", year );
	
	WebElement NL= AI.SignUpNewsLetter();
	js.executeScript("arguments[0].scrollIntoView();",NL );
	AI.ClickSignUpNewsLetter();
	
	WebElement SO = AI.SpecialOffers();
	js.executeScript("arguments[0].scrollIntoView();",SO );
	AI.ClickSpecialOffers();
	
	WebElement FN = AI.firstName();
	js.executeScript("arguments[0].scrollIntoView();",FN );
	AI.EnterfirstName("Aparna");
	
	WebElement LN = AI.lastName();
	js.executeScript("arguments[0].scrollIntoView();",LN );
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
	
	String AC= driver.getCurrentUrl();
	String expUrl1="https://automationexercise.com/account_created";
	Assert.assertEquals(AC, expUrl1,"[**'ACCOUNT CREATED!' is not visible**]");
	System.out.println("'ACCOUNT CREATED!' is visible\n");
	
	AI.ClickContinue();
	
	boolean LU = AI.LogedInAsUserIsDisplayed();
	Assert.assertEquals(LU,true,"[**'Logged in as username' is not visible**]");
	System.out.println("'Logged in as username'is visible\n");
	
	String str = AI.LogedInAsUser();
	System.out.println(str);
	
	AI.DeleteAcount();
	String AD= driver.getCurrentUrl();
	String expUrl2="https://automationexercise.com/delete_account";
	Assert.assertEquals(AD, expUrl2,"[** 'ACCOUNT DELETED!' is not visible**]");
	System.out.println(" 'ACCOUNT DELETED!' is visible\n");
	
	AI.ClickconDel();
	
}
@AfterMethod 
public void closeApp()
{ 
	driver.close();
}	
}
	
	
	
	
	






