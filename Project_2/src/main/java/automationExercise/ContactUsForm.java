package automationExercise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageClasses.ContactUsPage;

public class ContactUsForm {
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
	public void signin() throws Exception {
	
		ContactUsPage cu = new ContactUsPage();
		cu.dashboard(driver);;
		cu.clickContactUs();
		
		boolean git = cu.getintouch();
		Assert.assertEquals(git, true, "'GET IN TOUCH' is not visible");
		System.out.println("'GET IN TOUCH' is visible");
		
		cu.entername("Aparna");
		cu.enteremail("Aparnakota9@gmail.com");
		cu.enatersubject("Subjectxyz");
		cu.entermsg("Message_ABCDx");
		cu.clickchoosefile("C:\\Users\\my lap\\Pictures\\ap_dp.PNG");
		cu.clicksubmit();
		
		driver.switchTo().alert().accept();
		String str = cu.elertsatus();
		System.out.println(str);
		
		cu.elickhome();
		
		String hp = driver.getCurrentUrl();
		String expUrl = "https://automationexercise.com/";
		Assert.assertEquals(hp, expUrl, "[**HomePageIsNotVissible**]");
		System.out.println("User landed to home page successfully successfully\n");
	}
	
	@AfterMethod 
	public void closeApp()
	{ 
		driver.close();
	}	
	
	
	
	
	}

