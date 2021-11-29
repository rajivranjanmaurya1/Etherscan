package com.etherscan.pages;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserRegistrationPage {
	
	private WebDriver driver;
	private JavascriptExecutor executor;
	private WebDriverWait wait;
	
	public UserRegistrationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	      PageFactory.initElements(driver, this);
	      this.executor = (JavascriptExecutor) this.driver;
	}


	@FindBy(id="ContentPlaceHolder1_txtUserName")
    private WebElement txtUserName;
	
	@FindBy(id="ContentPlaceHolder1_txtEmail")
    private WebElement txtEmailAddress;	
	
	@FindBy(id="ContentPlaceHolder1_txtPassword")
    private WebElement txtPassword;
	
	@FindBy(id="ContentPlaceHolder1_txtPassword2")
    private WebElement txtConfirmPassword;
	
	@FindBy(id="ContentPlaceHolder1_btnRegister")
    private WebElement btnCreateAccount;
	
	@FindBy(id="ContentPlaceHolder1_MyCheckBox")
    private WebElement chkBoxTermConditions;
	
	@FindBy(id="ContentPlaceHolder1_SubscribeNewsletter")
    private WebElement chkBoxNewsletter;	
	
	@FindBy(id="recaptcha-anchor")
    private WebElement chkBoxRecaptcha;
	
	@FindBy(xpath="//div[@class='invalid-feedback' or @class='alert alert-danger']")
	private List<WebElement> errorMessage;
	
	@FindBy(id="btnCookie")
	private WebElement btnCookie;
	
	@FindBy(xpath=".//label[@for='ContentPlaceHolder1_SubscribeNewsletter']//span")
	private WebElement lbl_newsLetterLabel;
	
	@FindBy(xpath=".//label[@for='ContentPlaceHolder1_MyCheckBox']//span")
	private WebElement lbl_termConditionLabel;
	
	@FindBy(xpath=".//label[@for='ContentPlaceHolder1_MyCheckBox']//span//a")
	private WebElement lnk_termCondition;
	
	@FindBy(xpath=".//label[@for='ContentPlaceHolder1_SubscribeNewsletter']//span//a")
	private WebElement lnk_newsLetter;
	
	// Method to enter user name
	public void enterUserName(String userName) {
		wait.until(ExpectedConditions.visibilityOf(txtUserName));
		txtUserName.sendKeys(userName);
	}

	//Method to get the message
	public String getErrorMessage() {
		String errorMessagefromUI=null;
		for (WebElement webElement : errorMessage) {
			if (!webElement.getText().equals("")){
				errorMessagefromUI = webElement.getText();
				break;
			}
		}
		return errorMessagefromUI;
	}
	
	//enter email address
	public void enterEmailAddress(String emailAddress) {
		wait.until(ExpectedConditions.visibilityOf(txtEmailAddress));
		txtEmailAddress.sendKeys(emailAddress);
	}
	
	
	//enter password
	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(txtPassword));
		txtPassword.sendKeys(password);
	}
	
	
	//confirm password
	public void enterConfirmPassword(String confirmPassword) {
		wait.until(ExpectedConditions.visibilityOf(txtConfirmPassword));
		txtConfirmPassword.sendKeys(confirmPassword);
	}
	
	public void submitForm() {
		wait.until(ExpectedConditions.visibilityOf(btnCreateAccount));
		btnCreateAccount.click();
	}
	
	public void acceptCookie() {
		wait.until(ExpectedConditions.visibilityOf(btnCookie));
		btnCookie.click();
	}
	
	public void accpetTermsConditions() {
	     executor.executeScript("arguments[0].click();", chkBoxTermConditions);
	}

	public void selectCaptcha() {
		 driver.switchTo().frame(0);
		 wait.until(ExpectedConditions.visibilityOf(chkBoxRecaptcha));
		 chkBoxRecaptcha.click();
		 driver.switchTo().defaultContent();
	}
	
	public void selectNewsLetter() {
		 executor.executeScript("arguments[0].click();", chkBoxNewsletter);
	}
	
	public String getTermConditionLabel() {
		wait.until(ExpectedConditions.visibilityOf(lbl_termConditionLabel));
		return lbl_termConditionLabel.getText();
	}
	
	
	public String getNewsLetterLabel() {
		wait.until(ExpectedConditions.visibilityOf(lbl_newsLetterLabel));
		return lbl_newsLetterLabel.getText();
	}
	
	public void clickTermConditionLink() {
		wait.until(ExpectedConditions.visibilityOf(lnk_termCondition));
		lnk_termCondition.click();
	}
	
	public void clickNewsLetterLink() {
		wait.until(ExpectedConditions.visibilityOf(lnk_newsLetter));
		lnk_newsLetter.click();
	}
}

