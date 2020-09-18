package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuotesPage {
	public WebDriver driver;

	public QuotesPage(WebDriver driver) {
		this.driver = driver;
	}

	private By insurerQuotes = By.xpath("//div[@class='clearfix'] //div[@class='quote-card']");
	private By getLogoFromQuotes = By.xpath(".//img[@class='height-logo']");
	private By investmentAmount = By.xpath(".//span[@class='h2 bold']");

	public List<WebElement> insurerQuotes() {
		return driver.findElements(insurerQuotes);
	}

	public WebElement getLogoFromQuotes(WebElement quote) {
		return quote.findElement(getLogoFromQuotes);
	}

	public WebElement investmentAmount(WebElement quote) {
		return quote.findElement(investmentAmount);
	}
}
