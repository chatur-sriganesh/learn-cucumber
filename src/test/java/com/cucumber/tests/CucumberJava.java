package com.cucumber.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumber.utils.ReadObjects;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CucumberJava {
	WebDriver driver = null;

	@Before
	public void setup() {
		ReadObjects.readLocatorPropertyFile();
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}

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
		String locator = ReadObjects.getLocatorValueFromProperties(element, screen);
		WebElement clickableElement = this.returnWebElement(locator);
		clickableElement.click();
	}

	private WebElement returnWebElement(String crudeLocator) {
		String locatorType = crudeLocator.split("->")[0];
		String locator = crudeLocator.split("->")[1];
		switch (locatorType) {
		case "css":
			return this.driver.findElement(By.cssSelector(locator));

		case "xpath":
			return this.driver.findElement(By.xpath(locator));

		case "id":
			return this.driver.findElement(By.id(locator));

		default:
			System.out.println("Valid locator type not specified");
			break;
		}
		return null;
	}

	@And("^I open application$")
	public void i_open_application() throws Throwable {
		this.driver.get("http://demo.testfire.net");
	}

	@And("^I open application \"([^\"]*)\"$")
	public void i_open_application(String webSite) throws Throwable {
		this.driver.get(webSite);

	}

	@And("^I enter \"([^\"]*)\" value in \"([^\"]*)\" field on \"([^\"]*)\" screen$")
	public void i_enter_value_in_field_on_screen(String textValue, String fieldElement, String screenName) {
		String crudeLocator = ReadObjects.getLocatorValueFromProperties(fieldElement, screenName);
		WebElement field = this.returnWebElement(crudeLocator);
		field.sendKeys(textValue);
	}

	@Then("^I verify \"([^\"]*)\" on \"([^\"]*)\" is \"([^\"]*)\"$")
	public void i_verify_expected_with_actual(String element, String screenName, String expectedValue) {

		String crudeLocator = ReadObjects.getLocatorValueFromProperties(element, screenName);
		WebElement actualElement = this.returnWebElement(crudeLocator);
		Assert.assertEquals(expectedValue, actualElement.getText().toString());
	}

}
