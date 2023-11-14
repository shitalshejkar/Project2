package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC_20_SearchProduct {
	WebDriver driver;
	By search = By.xpath("//*[@name='search']");
	By searchbutton = By.xpath("//*[@id='submit_search']");
 	By searchResult = By.xpath("//*[@class='features_items']");
 	By CartProduct = By.xpath("//*[text()='Colour Blocked Shirt – Sky Blue']");
 	By Cartdiscription = By.xpath("//*[@class='cart_description']");
 	
 	
 	

 	public void Dashboard(WebDriver driver) {
		this.driver=driver;
	}
 public void search(String name) {
		 driver.findElement(search).sendKeys(name);
		 }
 public void Searchbutton() {
	 driver.findElement(searchbutton).click();
	 }

		
 public String searchResult() { 
	 return driver.findElement(searchResult).getText(); }
		
 public void CartProduct() {
		 driver.findElement(CartProduct).click();
		}
 public String Cartdiscription() {
	 return driver.findElement( Cartdiscription).getText();
	}
}
