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
	 
	 public void Dashboard(WebDriver driver) {
			this.driver=driver;
		}
		 public void ClickProduct() {
			driver.findElement(Product).click();;
			}
		 
		 public WebElement ViewProduct() {
				return driver.findElement(ViewProduct);
				}
		 public WebElement mousehoverViewProduct() {
			 return driver.findElement(ViewProduct);
			}
		 public void ClickViewProduct() {
				 driver.findElement(ViewProduct).click();;
				}
		 public boolean categoryIsDisplayed() {
				return driver.findElement(category).isDisplayed();
				}
		 public boolean PriceIsDisplayed() {
				return driver.findElement(Price).isDisplayed();
				}
		 public boolean AvalIsDisplayed() {
				return driver.findElement(Aval).isDisplayed();
				}
		 public boolean CondIsDisplayed() {
				return driver.findElement(Cond).isDisplayed();
				}
		 public boolean BrandIsDisplayed() {
				return driver.findElement(Brand).isDisplayed();
				}
		 public void SearchProduct(String Prod) {
				driver.findElement(Search).sendKeys(Prod);
		 }
		public WebElement Subscription() {
	           return driver.findElement(subscription);
					}
		public boolean Sub() {
			return driver.findElement(subscription).isDisplayed();
			}
		public void EnterSubEmail(String em) {
			driver.findElement(sub_email).sendKeys(em);
	 }
		public void ClickSubArrow() {
			driver.findElement(arow_sub).click();
			}
		public String SuccessMessg() {
			return driver.findElement(Sucess_msg).getText();
			}
		public void ClickCart() {
			driver.findElement(cart).click();
			}
		
		}
		 

