package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_12_Cartpage {
	 WebDriver driver;
	 By Products = By.xpath("//*[text()=' Products']");
	 By AddtoCart = By.xpath("(//*[text()='Add to cart'])[1]"); 
	 By Continue = By.xpath("//*[text()='Continue Shopping']");
	 By AddtoCart2 = By.xpath("(//*[text()='Add to cart'])[2]");
	 By viewCart = By.xpath("//*[text()='View Cart']");
	 By bluetop1 = By.xpath("(//*[text()='Blue Top'])[1]");
	 By menTshirt1 = By.xpath("(//*[text()='Men Tshirt'])[1]");
			 By bluetop = By.xpath("(//*[text()='Blue Top'])[2]");
			 By menTshirt = By.xpath("(//*[text()='Men Tshirt'])[2]");
			 By product_1 = By.xpath("//*[@id='product-1']");
			 By product_2 = By.xpath("//*[@id='product-2']");
	By Quantity = By.xpath("//*[@id='quantity']");		 
		 
			 
	  public void Dashboard(WebDriver driver) {
			this.driver=driver;
		}
		 public void CickProduct() {
			driver.findElement(Products).click();
			}
		 public void AddtoCart() {
				driver.findElement(AddtoCart).click();
				}
		 public void Continue() {
				driver.findElement(Continue).click();
				}
		 public void AddtoCart2() {
				driver.findElement(AddtoCart2).click();
				}
		 public void viewCart() {
				driver.findElement(viewCart).click();
				}
		 public String bluetop() {
				return driver.findElement(bluetop).getText();
				}
		 public String menTshirt() {
				return driver.findElement(menTshirt).getText();
				}
		 
		 public WebElement bluetop1() {
				return driver.findElement(bluetop);
				}
		 public WebElement menTshirt1() {
				return driver.findElement(menTshirt);
				}
		 public String Product1() {
				return driver.findElement(product_1).getText();
				}
		 public String Product2() {
				return driver.findElement(product_2).getText();
				}
		 public  WebElement ProdQuantity(){
		 return driver.findElement(Quantity);
				}
		 
}
