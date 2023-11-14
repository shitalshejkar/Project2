package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC_21_AddReview {
	
	WebDriver driver;
	By writeReview = By.xpath("//*[text()='Write Your Review']");
	By Name = By.xpath("//*[@id='name']");
	By email = By.xpath("//*[@id='email']");
	By Addreviewhere = By.xpath("//*[@name='review']");
	By submit = By.xpath("//*[@id='button-review']");
	By successmsg = By.xpath("//*[contains(text(),'Thank you')]");
	
	public void Dashboard(WebDriver driver) {
		this.driver=driver;
	}
	public boolean writeReview() {
		 return driver.findElement(writeReview).isDisplayed();
		 }
	 public void Name(String name) {
		 driver.findElement(Name).sendKeys(name);
		 }
	
	 public void email(String Email) {
		 driver.findElement(email).sendKeys(Email);
		 }
	 
	 public void Addreviewhere(String addreviewhere) {
		 driver.findElement(Addreviewhere).sendKeys(addreviewhere);
		 }
	 
	 public void submit() {
		 driver.findElement(submit).click();
		 }
	 public String successmsg() {
		 return driver.findElement(successmsg).getText();
		 }
	
}
