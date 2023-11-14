package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
	
		 WebDriver driver;
	 	By signup = By.xpath("//*[@class='fa fa-lock']");
	 	By NewUser =By.xpath("//*[text()='New User Signup!']");
		 By uName = By.xpath("//*[@name='name']");
		 By Email = By.xpath("(//*[@name='email'])[2]");
		 By SignUpButton = By.xpath("//*[text()='Signup']");
		By errormsg = By.xpath("//*[text()='Email Address already exist!']");
		
		 public void dashboard(WebDriver driver) {
				this.driver=driver;
			}
		 public void clicksignup() {
				driver.findElement(signup).click();
				}
		 public boolean signupisdisplayed() {
				return driver.findElement(signup).isDisplayed();
			}
		 
		 public void enterusername(String user) {
				driver.findElement(uName).sendKeys(user);
			}
		 public void enteremail(String pass) {
				driver.findElement(Email).sendKeys(pass);
			}
		 public void clicksignupButton() {
				driver.findElement(SignUpButton).click();
			}
		 public String errormsg() {
				return driver.findElement(errormsg).getText();
			}
		
	}
		
