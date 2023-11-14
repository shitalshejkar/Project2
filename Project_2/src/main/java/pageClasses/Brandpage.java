package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Brandpage {
	WebDriver driver;
 	By Brand = By.xpath("//*[text()='Brands']");
 	By Brands = By.xpath("//*[@class='brands-name']");
 	By Brandname = By.xpath("//*[text()='Polo']");
 	By Brandname2 = By.xpath("//*[text()='H&M']");
 	

 	public void Dashboard(WebDriver driver) {
		this.driver=driver;
	}
 public boolean Brand() {
		return driver.findElement(Brand).isDisplayed();
		}
 public String Brands() {
		return driver.findElement(Brands).getText();
		}
 public void Brandname() {
		 driver.findElement(Brandname).click();
		}
 public void Brandname2() {
	 driver.findElement(Brandname2).click();
	}
 
}
