package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_08_ProductDetailPage {
	
	WebDriver driver;
	 By Product = By.xpath("//*[text()=' Products']");
	 By ViewProduct = By.xpath("(//*[text()='View Product'])[2]"); 
	 By category = By.xpath("(//*[contains(text(),'Category')])[2]"); 
	 By Price = By.xpath("//*[contains(text(),'Rs')]"); 
	 By Aval = By.xpath("//*[contains(text(),'Availability:')]"); 
	 By Cond = By.xpath("//*[contains(text(),'Condition:')]"); 
	 By Brand = By.xpath("//*[contains(text(),'Brand:')]"); 
	 By Search =By.xpath("//*[@id='search_product']");
	 By subscription = By.xpath("//*[text()='Subscription']");
	 By sub_email = By.xpath("//*[@id='susbscribe_email']");
	 By arow_sub =By.xpath("//*[@id='subscribe']");
	 By Sucess_msg = By.xpath("//*[contains(text(),'You have')]");
	 By cart = By.xpath("//*[text()=' Cart']");
	 
	 public void dashboard(WebDriver driver) {
			this.driver=driver;
		}
		 public void clickProduct() {
			driver.findElement(Product).click();;
			}
		 
		 public WebElement viewProduct() {
				return driver.findElement(ViewProduct);
				}
		 public WebElement mousehoverViewProduct() {
			 return driver.findElement(ViewProduct);
			}
		 public void clickViewProduct() {
				 driver.findElement(ViewProduct).click();;
				}
		 public boolean categoryIsDisplayed() {
				return driver.findElement(category).isDisplayed();
				}
		 public boolean priceIsDisplayed() {
				return driver.findElement(Price).isDisplayed();
				}
		 public boolean avalIsDisplayed() {
				return driver.findElement(Aval).isDisplayed();
				}
		 public boolean condIsDisplayed() {
				return driver.findElement(Cond).isDisplayed();
				}
		 public boolean brandIsDisplayed() {
				return driver.findElement(Brand).isDisplayed();
				}
		 public void searchProduct(String Prod) {
				driver.findElement(Search).sendKeys(Prod);
		 }
		public WebElement subscription() {
	           return driver.findElement(subscription);
					}
		public boolean sub() {
			return driver.findElement(subscription).isDisplayed();
			}
		public void enterSubEmail(String em) {
			driver.findElement(sub_email).sendKeys(em);
	 }
		public void clickSubArrow() {
			driver.findElement(arow_sub).click();
			}
		public String successMessg() {
			return driver.findElement(Sucess_msg).getText();
			}
		public void clickCart() {
			driver.findElement(cart).click();
			}
	
		
		}
		 

