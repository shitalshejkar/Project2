package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_25_26 {
	WebDriver driver;//*[@id='slider']
	By scrollUp = By.xpath("//*[@id='scrollUp']");
	By Scrooledup = By.xpath("//*[@id='slider']");
	
	
	
	
	public void dashboard(WebDriver driver) {
		this.driver=driver;
	}
 public void scrollUp() {
		 driver.findElement(scrollUp).click();
		 }
 public WebElement  scrolledupIntoView() {
	 return driver.findElement(Scrooledup);
	 }
 public String  scrolledup() {
	 return driver.findElement(Scrooledup).getText();
	 }
}
