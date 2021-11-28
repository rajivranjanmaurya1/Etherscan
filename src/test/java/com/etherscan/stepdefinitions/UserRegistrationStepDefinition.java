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
	
//	@After
//	public void ScreenShot(Scenario scenario) {
//		if(scenario.isFailed())
//		{
//			scenario.embed(((TakesScreenshot)SuiteInit.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
//		}
//	}
	
	

	// @Test(priority=0 , description="User visits plats website" )
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
		System.out.println(actualErrorMessage);
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
	
	
	
	
	
	
//	
//	
//	// @Test(priority=1, description="User enters username and password")
//	@When("^user enters username and password$")
//	public void user_enters_username_and_password() throws Exception {
//
//		//Login home = Login.navigateTo(driver, Util.getURLFromResource("homepage.url", FileType.TEST_DATA_FILE));
//		Login lg = Login.getObject(driver);
//		Login userprofile = lg.login2(Util.getValFromResource("user.name", FileType.TEST_DATA_FILE),
//				Util.getValFromResource("user.password", FileType.TEST_DATA_FILE));
//		Assert.assertEquals(userprofile.getfieldValue(), Util.getValFromResource("user.name", FileType.TEST_DATA_FILE),
//				"Value not Entered properly");
//	}
//
//	// @Test(priority=2, description = "User then clicks on login
//	// button",dependsOnMethods = { "user_enters_username_and_password" })
//	@When("^user clicks on login button$")
//	public void user_clicks_on_login_button() throws Exception {
//		Login lg = Login.getObject(driver);
//		lg.loginButton();
//
//	}
//
//	// @Test(priority=3, description =" user is able to see log out link")
//	@Then("^user is logged in successully$")
//	public void user_is_logged_in_successully() throws Exception {
//		Home hm = Home.getObject(driver);
//		Assert.assertEquals(hm.getUserLoginStatus(), false, "User is not logged in");
//	}
//	
//	
//	@Then("^page title should be \"([^\"]*)\"$")
//	public void page_title_should_be(String expectedPageTitle) throws Throwable {
//		Assert.assertEquals(driver.getTitle().trim(), expectedPageTitle,"Title Mismatch");	}
	
	
	@AfterStep
	public void addScreenshot(Scenario scenario){

		//validate if scenario has failed
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

