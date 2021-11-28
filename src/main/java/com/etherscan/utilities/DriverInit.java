package com.etherscan.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInit {

	public WebDriver driver;

	public WebDriver getDriver() {
		
		String browser = PropertyFileReader.getProperty(System.getProperty("user.dir")+"/src/test/resources/configuration.properties", "browser");
		switch (browser){

		case "chrome": {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/test/resources/chromedriver.exe");
			this.driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;			
		}

		case "firefox": {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/resources/geckodriver.exe");
			this.driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;			
		}
		}
		return driver;
	}		
}
