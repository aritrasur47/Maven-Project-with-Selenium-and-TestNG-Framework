package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	// investment amount
	private By investmentAmount = By.xpath(
			"//*[@id='js-content']/main/div/div/span/article/section/div/div/div/div[2]/div[1]/div[2]/div/input");

	// investment term
	private By investmentTerm = By.xpath(
			"//*[@id='js-content']/main/div/div/span/article/section/div/div/div/div[2]/div[2]/div[2]/div/button/div[1]/i");

	// term years
	private By termListYears = By.xpath(
			"//ul[@class=' top-3 absolute z1 left-0 right-0 clearfix list-reset m0 bg-white max-height-15 overflow-scroll']/li[2]");

	// age
	private By ageIs = By.xpath(
			"//*[@id='js-content']/main/div/div/span/article/section/div/div/div/div[2]/div[3]/div[2]/div/button/div[1]/i");

	// age selection
	private By ageSelect = By.xpath(
			"//*[@id='js-content']/main/div/div/span/article/section/div/div/div/div[2]/div[3]/div[2]/div/ul/li[8]/span");

	// gender
	private By genderSelect = By.xpath("//i[@class='icon-radio radio-icon bg-white white']");

	// emailid
	private By email = By.xpath(
			"//*[@id='js-content']/main/div/div/span/article/section/div/div/div/div[2]/div[5]/div[2]/div/input");

	// phone
	private By phoneNumber = By.xpath(
			"//*[@id='js-content']/main/div/div/span/article/section/div/div/div/div[2]/div[6]/div[2]/div/div/div/input");

	// next button
	private By submit = By.xpath(
			"//*[@id='js-content']/main/div/div/span/article/section/div/div/div/div[2]/div[7]/div[2]/button/div[1]/div[2]/i");

	// ===============================

	public WebElement investmentAmnt() {
		return driver.findElement(investmentAmount);
	}

	public WebElement investmentTerm() {
		return driver.findElement(investmentTerm);
	}

	public WebElement termListYears() {
		return driver.findElement(termListYears);
	}

	public WebElement ageIs() {
		return driver.findElement(ageIs);
	}

	public WebElement ageSelect() {
		return driver.findElement(ageSelect);
	}

	public WebElement genderSelect() {
		return driver.findElement(genderSelect);
	}

	public WebElement email() {
		return driver.findElement(email);
	}

	public WebElement phoneNumber() {
		return driver.findElement(phoneNumber);
	}

	public QuotesPage submit() {
		driver.findElement(submit).click();
		return new QuotesPage(driver);
	}
}
