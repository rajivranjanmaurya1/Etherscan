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
	      executor = (JavascriptExecutor) driver;
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
	
	// Method to enter user name
	public void enterUserName(String userName) {
		this.wait.until(ExpectedConditions.visibilityOf(this.txtUserName));
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
		this.wait.until(ExpectedConditions.visibilityOf(this.txtEmailAddress));
		txtEmailAddress.sendKeys(emailAddress);
	}
	
	
	//enter password
	public void enterPassword(String password) {
		this.wait.until(ExpectedConditions.visibilityOf(this.txtPassword));
		txtPassword.sendKeys(password);
	}
	
	
	//confirm password
	public void enterConfirmPassword(String confirmPassword) {
		this.wait.until(ExpectedConditions.visibilityOf(this.txtConfirmPassword));
		txtConfirmPassword.sendKeys(confirmPassword);
	}
	
	public void submitForm() {
		btnCreateAccount.click();
	}
	
	public void acceptCookie() {
		this.wait.until(ExpectedConditions.visibilityOf(this.btnCookie));
		btnCookie.click();
	}
	
	public void accpetTermsConditions() {
	     executor.executeScript("arguments[0].click();", chkBoxTermConditions);
	}

	public void selectCaptcha() {
		 driver.switchTo().frame(0);
		 this.wait.until(ExpectedConditions.visibilityOf(this.chkBoxRecaptcha));
		 chkBoxRecaptcha.click();
		 driver.switchTo().defaultContent();
	}
	
	public void selectNewsLetter() {
		 executor.executeScript("arguments[0].click();", chkBoxNewsletter);
	}
}

