package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserLogin {
	 WebDriver driver;
	 By signup = By.xpath("//*[@class='fa fa-lock']");
		By login = By.xpath("//*[text()='Login to your account']");
		By email1 = By.xpath("(//*[@name='email'])[1]");
		By passwd1 = By.xpath("//*[@name='password']");
		By LoginButton = By.xpath("//*[text()='Login']");
		By LogedIn = By.xpath("//*[text()=' Logged in as ']");
		By deleteAct= By.xpath("//*[text()=' Delete Account']");
		By delContinue = By.xpath("//*[text()='Continue']");
		By errormsg=By.xpath("//*[text()='Your email or password is incorrect!']");
		By logOut = By.xpath("//*[text()=' Logout']");		
		
		
		
		public void Dashboard(WebDriver driver) {
			this.driver=driver;
		}
		public void clickSignup() {
			driver.findElement(signup).click();
			}
		public boolean LoginActIsDisplayed() {
			return driver.findElement(login).isDisplayed();
		}
		public void EnterEmailId(String nm) {
			driver.findElement(email1).sendKeys(nm);
		}
		public void EnterPasswd1(String pass) {
			driver.findElement(passwd1).sendKeys(pass);
		}
		public void ClickOnLogin() {
			driver.findElement(LoginButton).click();
		}
		public boolean LogedInAsUserIsDisplayed() {
			return driver.findElement(LogedIn).isDisplayed();
		}
		public String LogedInAsUser() {
			return driver.findElement(LogedIn).getText();
		}
		public void DeleteAcount() {
			driver.findElement(deleteAct).click();
		}
		public void ClickconDel() {
			driver.findElement(delContinue).click();
		}
		public String ErrorMsg() {
			return driver.findElement(errormsg).getText();
		}
		public void ClickLogOut() {
			driver.findElement(logOut).click();
		}
}
