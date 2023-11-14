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
	
	WebElement month = AI.enterDay();
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
	AI.enterAddress1("Hyderabad");
	
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
	
	AI.deleteAcount();
	String AD= driver.getCurrentUrl();
	String expUrl2="https://automationexercise.com/delete_account";
	Assert.assertEquals(AD, expUrl2,"[** 'ACCOUNT DELETED!' is not visible**]");
	System.out.println(" 'ACCOUNT DELETED!' is visible\n");
	
	AI.clickconDel();
	
}
@AfterMethod 
public void closeApp()
{ 
	driver.close();
}	
}
	
	
	
	
	






