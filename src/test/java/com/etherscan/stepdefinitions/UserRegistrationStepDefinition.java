package com.etherscan.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.etherscan.helpers.UserRegistrationHelper;
import com.etherscan.utilities.DriverInit;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationStepDefinition {

	public  static Scenario scenario;
	private  WebDriver driver;
	public UserRegistrationHelper userRegistrationHelper;
	public DriverInit driverInit;

	@Before
	public void beforeScenario(Scenario scenario) {
		driverInit = new DriverInit();
		this.scenario = scenario;
		this.driver = driverInit.getDriver();
		userRegistrationHelper = new UserRegistrationHelper(this.driver);
	}
	

	@Given("^user is on user registration page$")
	public void user_is_on_user_registration_page() throws Exception {
		userRegistrationHelper.goToUserRegistrationPage();
	}
	
	
	@When("^user provides \"([^\"]*)\" as user name$")
	public void user_enters_user_name(String userName)	{
		userRegistrationHelper.enterUserName(userName);
	}
	
	
	@Then("^user should see \"([^\"]*)\" message$")
	public void user_see_error_message(String expectedErrorMessage) throws Exception {
		String actualErrorMessage  = userRegistrationHelper.getErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Incorrect error message is displayed. Expected is: " + expectedErrorMessage + " Actual is: "+ actualErrorMessage );
	}
	
	
	@When("^user provides \"([^\"]*)\" as email address$")
	public void user_enters_email_address(String emailAddress)	{
		userRegistrationHelper.enterEmailAddress(emailAddress);
	}
	
	
	@When("^user provides \"([^\"]*)\" as password$")
	public void user_enters_password(String password)	{
		userRegistrationHelper.enterpassword(password);
	}
	
	
	
	@When("^user provides \"([^\"]*)\" as confirm password$")
	public void user_enters_confirm_password(String confirmPassword)	{
		userRegistrationHelper.confirmPassword(confirmPassword);
	}
	
	
	@Then("^user should see below message$")
	public void user_sees_error(DataTable errorMessage) throws Exception {
		String expectedErrorMessage = errorMessage.asList().get(0);
		String actualErrorMessage  = userRegistrationHelper.getErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Incorrect error message is displayed. Expected is: " + expectedErrorMessage + " Actual is: "+ actualErrorMessage );
	}

	
	@When("^user creates account$")
	public void user_creates_account()	{
		userRegistrationHelper.submitForm();
	}
	
	
	@When("^user accepts terms and contions$")
	public void user_accepts_terms_and_conditions()	{
		userRegistrationHelper.accpetTermsConditions();
	}
	
	
	@When("^user selects captcha$")
	public void select_captcha() {
		userRegistrationHelper.selectCaptcha();
	}
	
	@When("^user subscribs to newsletter$")
	public void subscribe_newsletter() {
		userRegistrationHelper.selectNewsLetter();
	}
	
	
	@Then("^user should see \"([^\"]*)\" news letter text$")
	public void validate_new_letter_text(String expectedNewsLetterText)	{
		String actualNewLetterText  = userRegistrationHelper.getNewsLetterText();
		Assert.assertEquals(actualNewLetterText, expectedNewsLetterText, "Incorrect news letter text is displayed. Expected is: " + expectedNewsLetterText + " Actual is: "+ actualNewLetterText );
	}
	
	@Then("^user should see \"([^\"]*)\" term and conditions text$")
	public void validate_term_condition_text(String expectedTermConditionText)	{
		String actualTermConditionText  = userRegistrationHelper.getTermConditionText();
		Assert.assertEquals(actualTermConditionText, expectedTermConditionText, "Incorrect terms and conditions text is displayed. Expected is: " + expectedTermConditionText + " Actual is: "+ actualTermConditionText );
	}
	
	
	@When("^user clicks \"([^\"]*)\" link$")
	public void user_click_link(String link)	{
		userRegistrationHelper.clickLink(link);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Then("^user should see page with title \"([^\"]*)\" opened in new tab$")
	public void validate_new_page_title(String expectedPageTitle)	{
		String actualPageTitle  = userRegistrationHelper.getNewTabPageTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "Incorrect news letter text is displayed. Expected is: " + expectedPageTitle + " Actual is: "+ actualPageTitle );
	}

	
	@AfterStep
	public void addScreenshot(Scenario scenario){
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image"); 
		}
		
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		driver.quit();
	}
	

}

