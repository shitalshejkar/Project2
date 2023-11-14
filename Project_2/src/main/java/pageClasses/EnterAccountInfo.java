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
	
	public void Dashboard(WebDriver driver) {
		this.driver=driver;
	}
	public boolean EnterAccountInformationIsDisplayed() {
		return driver.findElement(AcInfo).isDisplayed();
	}
	public void ClickTitle() {
		driver.findElement(Title).click();;
	}
	public void EnterPasswd(String pass) {
		driver.findElement(passwd).sendKeys(pass);;
	}
	public WebElement EnterDay() {
		return driver.findElement(day);
		
	}
	public WebElement EnterMonth() {
		return driver.findElement(month);
	}
	public WebElement EnterYear() {
		return driver.findElement(year);
	}
	public WebElement SignUpNewsLetter() {
		return driver.findElement(SignUpNewsLetter);
	}
	public void ClickSignUpNewsLetter() {
		driver.findElement(SignUpNewsLetter).click();
	}
	public WebElement SpecialOffers() {
		return driver.findElement(SpecialOffers);
	}
	public void ClickSpecialOffers() {
		driver.findElement(SpecialOffers).click();
	}
	public WebElement firstName() {
		return driver.findElement(firstName);
	}
	public void EnterfirstName(String FName) {
		driver.findElement(firstName).sendKeys(FName);
	}
	public WebElement lastName() {
		return driver.findElement(lastName);
	}
	public void EnterlastName(String Lname) {
		driver.findElement(lastName).sendKeys(Lname);
	}
	public void EntercompanyName(String CompanyName) {
		driver.findElement(companyName).sendKeys(CompanyName);
	}
	public void EnterAddress1(String Add1) {
		driver.findElement(Address1).sendKeys(Add1);
	}
	public void EnterAddress2(String Add2) {
		driver.findElement(Address2).sendKeys(Add2);
	}

public String EnterAddressGetText() {
	return driver.findElement(Address1).getText();
}
public String EnterAddressGetText2() {
	return driver.findElement(Address2).getText();
}
	public WebElement ClickCountry() {
		return driver.findElement(Country);
	}
	public void EnterState(String state) {
		driver.findElement(State).sendKeys(state);
	}
	public void EnterCity(String city) {
		driver.findElement(City).sendKeys(city);
	}
	public void EnterZipCode(String zipCode) {
		driver.findElement(ZipCode).sendKeys(zipCode);
	}
	public void EnterMobileNo(String mobNo) {
		driver.findElement(MobNo).sendKeys(mobNo);
	}
	public void ClickCreateAccount() {
		driver.findElement(CreateAccount).click();
	}
	public void ClickContinue() {
		driver.findElement(Continue).click();
	}
	public boolean LogedInAsUserIsDisplayed() {
		return driver.findElement(LogedIn).isDisplayed();
	}
	public String LogedInAsUser() {
		return driver.findElement(LogedIn).getText();
	}
	public void DeleteAcount() {
		driver.findElement(deleteAct).click();
	}
	public void ClickconDel() {
		driver.findElement(delContinue).click();
	}
}
