package com.etherscan.helpers;

import org.openqa.selenium.WebDriver;
import com.etherscan.pages.UserRegistrationPage;

public class UserRegistrationHelper {
	
	WebDriver driver;
	UserRegistrationPage userRegistrationPage;
	
	public UserRegistrationHelper(WebDriver driver) {
		this.driver=driver;
		userRegistrationPage = new UserRegistrationPage(this.driver); 
	}
	
	public void goToUserRegistrationPage() {
		driver.get("https://etherscan.io/register");
		userRegistrationPage.acceptCookie();
	}
	
	public void enterUserName(String userName) {
		userRegistrationPage.enterUserName(userName);
	}
	
	public String getErrorMessage() {
		String errorMessage;
		errorMessage = userRegistrationPage.getErrorMessage();
		errorMessage = errorMessage.replace("\n", "");
		return errorMessage;
	}
	
	public void enterEmailAddress(String emailAddress) {
		userRegistrationPage.enterEmailAddress(emailAddress);
	}
	
	
	public void enterpassword(String password) {
		userRegistrationPage.enterPassword(password);
	}
	
	
	public void confirmPassword(String confirmPassword) {
		userRegistrationPage.enterConfirmPassword(confirmPassword);
	}
	
	public void submitForm() {
		userRegistrationPage.submitForm();
	}
	
	public void accpetTermsConditions() {
		userRegistrationPage.accpetTermsConditions();
	}

	public void selectCaptcha() {		
		userRegistrationPage.selectCaptcha();
	}
	
	public void selectNewsLetter() {		
		userRegistrationPage.selectNewsLetter();
	}

}
