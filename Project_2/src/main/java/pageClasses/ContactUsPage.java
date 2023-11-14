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
	 
	 
	  public void Dashboard(WebDriver driver) {
			this.driver=driver;
		}
		 public void ClickContactUs() {
			driver.findElement(contactUs).click();
			}
	  public boolean GetInTouch() {
			return driver.findElement(GetInTouch).isDisplayed();
			}
	  public void Entername(String Name) {
			driver.findElement(name).sendKeys(Name);
			}
	  public void EnterEmail(String Email) {
			driver.findElement(email).sendKeys(Email);
			}
	  public void Enatersubject(String Sub) {
			driver.findElement(subject).sendKeys(Sub);
			}
	  public void EnterMsg(String Msg) {
			driver.findElement(messsage).sendKeys(Msg);
			}
	  public void ClickChooseFile(String file) {
			driver.findElement(chooseFile).sendKeys(file);;
			}
	  public void ClickSubmit() {
			driver.findElement(submit).click();
			}
	  public String ElertSatus() {
			return driver.findElement(StatusAlert).getText();
			}
	  public void ClickHome() {
			driver.findElement(HomeButton).click();
			}
	 // public void () {
			//driver.findElement()
			//}
}
