package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC_14_PlaceOrder {
	 WebDriver driver;
	 By Products = By.xpath("//*[text()=' Products']");
	By AddtoCart1 = By.xpath("(//*[text()='Add to cart'])[1]");
	 By AddtoCart = By.xpath("(//*[text()='Add to cart'])[2]");
	 By ViewCart =By.xpath("//*[text()='View Cart']");
	 By ProceedToCart =By.xpath("//*[text()='Proceed To Checkout']");
	 By Register_Login =By.xpath("//*[text()='Register / Login']");
	 By cart = By.xpath("//*[text()=' Cart']");
	 By DeliveryAdd  = By.xpath("//*[@id='address_delivery']");
	 By BillingAdd = By.xpath("//*[@id='address_invoice']");
	 By CartInfo = By.xpath("//*[@id='cart_info']");
	 By Comment = By.xpath("//*[@name='message']");
	 By placeOrder = By.xpath("//*[text()='Place Order']");
	 By nameOncard = By.xpath("//*[@name='name_on_card']");
	 By cardNumber = By.xpath("//*[@name='card_number']");
	 By cvc = By.xpath("//*[@name='cvc']");
	 By expiry_month = By.xpath("//*[@name='expiry_month']");
	 By expiry_year = By.xpath("//*[@name='expiry_year']");
	 By Pay_submit = By.xpath("//*[@id='submit']");
	 By successMsg = By.xpath("//*[contains(text(),'Congratulations!')]");
	 By deleteAccnt = By.xpath("//*[text()=' Delete Account']");
	 By deleteConfirm = By.xpath("//*[contains(text(),'Your account has been permanently deleted!')");
	 By Continue = By.xpath("//*[text()='Continue']");
	 By Removeproduct = By.xpath("//*[@class='cart_quantity_delete']");
	 By EmptyCart = By.xpath("//*[@id='empty_cart']");
	 
	 
	 public void dashboard(WebDriver driver) {
		this.driver=driver;
	      }
	 public void clickProduct() {
		driver.findElement(Products).click();
		}
	 
			
	 public WebElement addtoCart1() {
			return driver.findElement(AddtoCart1);
			}
	 public void clickAddtoCart() {
			driver.findElement(AddtoCart).click();
			}
	 public void viewCart() {
			driver.findElement(ViewCart).click();
			}
	 public void proceedToCart() {
			driver.findElement(ProceedToCart).click();
			}
	 public void register_Login() {
			driver.findElement(Register_Login).click();
			}
	 public void cart() {
			driver.findElement(cart).click();
			}
	 public String deliveryAdd() {
			return driver.findElement(DeliveryAdd).getText();
			}
	 public String billingAdd() {
			return driver.findElement(BillingAdd).getText();
			}
	 public String cartInfo() {
			return driver.findElement(CartInfo).getText();
			}
	 public void comment(String msg) {
			driver.findElement(Comment).sendKeys(msg);
			}
	 public void placeOrder() {
			driver.findElement(placeOrder).click();
			}
	 public void nameOncard(String name) {
			driver.findElement(nameOncard).sendKeys(name);
			}
	 public void cardNumber(String cno) {
			driver.findElement(cardNumber).sendKeys(cno);
			}
	 public void cvc(String CVC) {
			driver.findElement(cvc).sendKeys(CVC);
			}
	 public void expiry_month(String Expmon) {
			driver.findElement(expiry_month).sendKeys(Expmon);
			}
	 public void expiry_year(String Expyr) {
			driver.findElement(expiry_year).sendKeys(Expyr);
			}
	 public void pay_submit() {
			driver.findElement(Pay_submit).click();
			}
	 public String successMsg() {
			return driver.findElement(successMsg).getText();
			}
	 public void deleteAccnt() {
			driver.findElement(deleteAccnt).click();
			}
	 public String deleteConfirm() {
			return driver.findElement(deleteConfirm).getText();
			}
	 public void continued() {
			driver.findElement(Continue).click();
			}
	 public void removeproduct() {
				driver.findElement(Removeproduct).click();
				} 
	 public String emptyCart() {
			return driver.findElement(EmptyCart).getText();
			}
	
	 
}
