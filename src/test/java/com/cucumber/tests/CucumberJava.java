package com.cucumber.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CucumberJava {
	WebDriver driver = null;

	@Given("^I  open the \"([^\"]*)\" browser$")
	public void i_open_the_browser(String browser) throws Throwable {
		System.out.println("OPENING BROWSER!!!");

		switch (browser) {

		case "firefox": {
			System.setProperty("webdriver.gecko.driver", "C:\\<username>\\BrowserDrivers\\geckodriver.exe");
			this.driver = new FirefoxDriver();
			break;
		}
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "C:\\<username>\\BrowserDrivers\\chromedriver.exe");
			this.driver = new ChromeDriver();
			break;
		}
		default:
			System.out.println("No Browser Found");
		}
	}

	@And("^I click \"([^\"]*)\" button on \"([^\\\"]*)\" screen$")
	public void i_click_button(String element, String screen) throws Throwable {

	}

}
