package SYMBO.ULIPE2E;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.annotations.Listeners;
import pageObjects.LandingPage;
import pageObjects.QuotesPage;
import resources.Base;

//@Listeners(SYMBO.ULIPE2E.Listeners.class)
public class UlipHome extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(UlipHome.class);

	@BeforeTest
	public void initialize() {
		driver = initializeDriver();
		log.info("Driver initialized.");
		driver.get(prop.getProperty("url"));
		log.trace("==Ulip execution begins==");
		log.trace("Navigated to ULIP Home page.");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "getData")
	public void ulipHomeNavigation(String investmentAmnt, String email, String password) throws InterruptedException {
		LandingPage land = new LandingPage(driver);

		land.investmentAmnt().sendKeys(investmentAmnt);
		land.investmentTerm().click();
		land.termListYears().click();
		land.ageIs().click();
		land.ageSelect().click();
		land.genderSelect().click();
		land.email().sendKeys(email);
		land.phoneNumber().sendKeys(password);
		Thread.sleep(2000);
		log.info("All data are successfully filled in ULIP investement page.");

		QuotesPage quotes = land.submit();
		Thread.sleep(29000);
		// QuotesPage quotes = new QuotesPage(driver);

		log.trace("== Quotes Found ==");
		
		List<WebElement> quotesList = quotes.insurerQuotes();
		for (WebElement eachQuote : quotesList) {
			String insurerName = getInsurerName(quotes.getLogoFromQuotes(eachQuote).getAttribute("src"));
			String investAmount = quotes.investmentAmount(eachQuote).getText();

			Assert.assertEquals(investAmount, "₹ 9,00,000");
			log.info(insurerName + " :: " + investAmount);
		}

		log.info("All data are successfully validated in Quotes page.");
		log.trace("== ULIP Execution ends ==");	
	}

	public String getInsurerName(String imgSrc) {
		String insurerName = imgSrc;

		switch (imgSrc) {
		case "https://www.symboinsurance.com/images/aegon_logo.png":
			insurerName = "AEGON";
			break;

		case "https://www.symboinsurance.com/images/FGILILogo.jpg":
			insurerName = "FG";
			break;
		}
		return insurerName;
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][3];
		data[0][0] = "900000";
		data[0][1] = "test@symbo.com";
		data[0][2] = "9200917231";

		return data;
	}

	@AfterTest
	public void browserQuit() {
		// driver.close();
		driver.quit();
	}
}
