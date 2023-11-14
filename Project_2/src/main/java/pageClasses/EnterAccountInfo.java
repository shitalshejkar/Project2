package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnterAccountInfo {
	
	 WebDriver driver;
	 
	By AcInfo= By.xpath("//*[text()='Enter Account Information']");
	By Title = By.xpath("//*[@id='id_gender2']");
	By passwd = By.xpath("//*[@id='password']");
	By day = By.xpath("//*[@id='days']");
	By month = By.xpath("//*[@id='months']");
	By year = By.xpath("//*[@id='years']");
	By SignUpNewsLetter= By.xpath("//*[@id='newsletter']");
	By SpecialOffers= By.xpath("//*[@id='optin']");
	By firstName= By.xpath("//*[@id='first_name']");
	By lastName = By.xpath("//*[@id='last_name']");
	By companyName= By.xpath("//*[@id='company']");
	By Address1= By.xpath("//*[@id='address1']");
	By Address2= By.xpath("//*[@id='address2']");
	By Country= By.xpath("//*[@id='country']");
	By State= By.xpath("//*[@id='state']");
	By City= By.xpath("//*[@id='city']");
	By ZipCode= By.xpath("//*[@id='zipcode']");
	By MobNo= By.xpath("//*[@id='mobile_number']");
    By CreateAccount= By.xpath("//*[text()='Create Account']");
	By Continue =By.xpath("//*[text()='Continue']");
	By LogedIn = By.xpath("//*[text()=' Logged in as ']");
	By deleteAct= By.xpath("//*[text()=' Delete Account']");
	By delContinue = By.xpath("//*[text()='Continue']");
	
	public void dashboard(WebDriver driver) {
		this.driver=driver;
	}
	public boolean enterAccountInformationIsDisplayed() {
		return driver.findElement(AcInfo).isDisplayed();
	}
	public void clickTitle() {
		driver.findElement(Title).click();;
	}
	public void enterPasswd(String pass) {
		driver.findElement(passwd).sendKeys(pass);;
	}
	public WebElement enterDay() {
		return driver.findElement(day);
		
	}
	public WebElement enterMonth() {
		return driver.findElement(month);
	}
	public WebElement enterYear() {
		return driver.findElement(year);
	}
	public WebElement signUpNewsLetter() {
		return driver.findElement(SignUpNewsLetter);
	}
	public void clickSignUpNewsLetter() {
		driver.findElement(SignUpNewsLetter).click();
	}
	public WebElement secialOffers() {
		return driver.findElement(SpecialOffers);
	}
	public void clickSpecialOffers() {
		driver.findElement(SpecialOffers).click();
	}
	public WebElement firstName() {
		return driver.findElement(firstName);
	}
	public void enterfirstName(String FName) {
		driver.findElement(firstName).sendKeys(FName);
	}
	public WebElement lastName() {
		return driver.findElement(lastName);
	}
	public void enterlastName(String Lname) {
		driver.findElement(lastName).sendKeys(Lname);
	}
	public void entercompanyName(String CompanyName) {
		driver.findElement(companyName).sendKeys(CompanyName);
	}
	public void enterAddress1(String Add1) {
		driver.findElement(Address1).sendKeys(Add1);
	}
	public void enterAddress2(String Add2) {
		driver.findElement(Address2).sendKeys(Add2);
	}

public String enterAddressGetText() {
	return driver.findElement(Address1).getText();
}
public String enterAddressGetText2() {
	return driver.findElement(Address2).getText();
}
	public WebElement clickCountry() {
		return driver.findElement(Country);
	}
	public void enterState(String state) {
		driver.findElement(State).sendKeys(state);
	}
	public void enterCity(String city) {
		driver.findElement(City).sendKeys(city);
	}
	public void enterZipCode(String zipCode) {
		driver.findElement(ZipCode).sendKeys(zipCode);
	}
	public void enterMobileNo(String mobNo) {
		driver.findElement(MobNo).sendKeys(mobNo);
	}
	public void clickCreateAccount() {
		driver.findElement(CreateAccount).click();
	}
	public void clickContinue() {
		driver.findElement(Continue).click();
	}
	public boolean logedInAsUserIsDisplayed() {
		return driver.findElement(LogedIn).isDisplayed();
	}
	public String logedInAsUser() {
		return driver.findElement(LogedIn).getText();
	}
	public void deleteAcount() {
		driver.findElement(deleteAct).click();
	}
	public void clickconDel() {
		driver.findElement(delContinue).click();
	}
	
}
