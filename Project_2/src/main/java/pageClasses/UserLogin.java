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
		
		
		
		public void dashboard(WebDriver driver) {
			this.driver=driver;
		}
		public void clickSignup() {
			driver.findElement(signup).click();
			}
		public boolean loginActIsDisplayed() {
			return driver.findElement(login).isDisplayed();
		}
		public void enterEmailId(String nm) {
			driver.findElement(email1).sendKeys(nm);
		}
		public void enterPasswd1(String pass) {
			driver.findElement(passwd1).sendKeys(pass);
		}
		public void clickOnLogin() {
			driver.findElement(LoginButton).click();
		}
		public boolean logedInAsUserIsDisplayed() {
			return driver.findElement(LogedIn).isDisplayed();
		}
		public String logedInAsUser() {
			return driver.findElement(LogedIn).getText();
		}
		public void deleteAcount() {
			driver.findElement(deleteAct).click();
		}
		public void clickconDel() {
			driver.findElement(delContinue).click();
		}
		public String errorMsg() {
			return driver.findElement(errormsg).getText();
		}
		public void clickLogOut() {
			driver.findElement(logOut).click();
		}
		
}
