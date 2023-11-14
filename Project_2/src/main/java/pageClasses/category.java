package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class category {
	 WebDriver driver;
	 	By category = By.xpath("//*[@id='accordian']");
	 	By women = By.xpath("//*[@href='#Women']");
	 	By dress = By.xpath("(//*[text()='Dress '])[1]");
	 	By DressProduct = By.xpath("//*[text()='Women - Dress Products']");
	 	By men = By.xpath("//*[@href='#Men']");
	 	By jeans = By.xpath("//*[text()='Jeans ']");
	 	By MenJeans = By.xpath("//*[text()='Men - Jeans Products']");
	 	
	 	public void dashboard(WebDriver driver) {
			this.driver=driver;
		}
	 public String categoryText() {
			return driver.findElement(category).getText();
			}
	 public void women() {
			 driver.findElement(women).click();
			}
	 public void dress() {
		   driver.findElement(dress).click();
		}
	 public String dressProduct() {
			return driver.findElement(DressProduct).getText();
			}
	 public void men() {
		   driver.findElement(men).click();
		}
     public void jeans() {
	        driver.findElement(jeans).click();
	}
     public String menJeans() {
			return driver.findElement(MenJeans).getText();
			}
	
}
