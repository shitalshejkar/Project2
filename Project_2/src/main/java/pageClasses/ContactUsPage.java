package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
	 WebDriver driver;
	 By contactUs  = By.xpath("//*[text()=' Contact us']");
	 By GetInTouch = By.xpath("//*[text()='Get In Touch']"); 
	 By name = By.xpath("//*[@name='name']");
	 By email = By.xpath("//*[@name='email']");
	 By subject = By.xpath("//*[@name='subject']");
	 By messsage = By.xpath("//*[@name='message']");
	 By chooseFile = By.xpath("//*[@type='file']");
	 By submit = By.xpath("//*[@name='submit']");
	 By StatusAlert = By.xpath("//*[@class='status alert alert-success']");
	 By HomeButton = By.xpath("//*[@class='btn btn-success']");
	 //By  = By.xpath("");
	 
	 
	  public void dashboard(WebDriver driver) {
			this.driver=driver;
		}
		 public void clickContactUs() {
			driver.findElement(contactUs).click();
			}
	  public boolean getintouch() {
			return driver.findElement(GetInTouch).isDisplayed();
			}
	  public void entername(String Name) {
			driver.findElement(name).sendKeys(Name);
			}
	  public void enteremail(String Email) {
			driver.findElement(email).sendKeys(Email);
			}
	  public void enatersubject(String Sub) {
			driver.findElement(subject).sendKeys(Sub);
			}
	  public void entermsg(String Msg) {
			driver.findElement(messsage).sendKeys(Msg);
			}
	  public void clickchoosefile(String file) {
			driver.findElement(chooseFile).sendKeys(file);;
			}
	  public void clicksubmit() {
			driver.findElement(submit).click();
			}
	  public String elertsatus() {
			return driver.findElement(StatusAlert).getText();
			}
	  public void elickhome() {
			driver.findElement(HomeButton).click();
			}
	 
	
	}

