package almosaferWeb;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases extends Parameters {

	@BeforeTest()
	public void setUp() {
		driver.manage().window().maximize();
		driver.get(Url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		WebElement popupScreen = driver.findElement(By.className("sc-iBmynh"));

		WebElement SARButton = driver.findElement(By.className("cta__saudi"));
		if (popupScreen.isDisplayed()) {
			SARButton.click();
		}
	}

	@Test(priority = 1)
	public void verifyingDefaultLangIsEnglish() {

		WebElement htmlTag = driver.findElement(By.tagName("html"));

		String actualLang = htmlTag.getAttribute("lang").toUpperCase();
		String expextedLang = "EN";

		assertEquals(actualLang, expextedLang);

	}

	@Test(priority = 2)
	public void verifingDefaultCurrencyIsSAR() {

		WebElement currencyButton = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"));

		String actualCurrency = currencyButton.getText();
		String expextedCurrency = "SAR";

		assertEquals(actualCurrency, expextedCurrency);
	}

	@Test(priority = 3)
	public void verifyingContactNumber() {
		WebElement numberContainer = driver.findElement(By.className("sc-hUfwpO"));
		String actualNumber = numberContainer.findElement(By.tagName("strong")).getText();
		String expectedNumber = "+966554400000";

		assertEquals(actualNumber, expectedNumber);

	}

	@Test(priority = 4)
	public void verifyingQitafLogoIsDisplayedInFooter() throws InterruptedException {
		WebElement qitafLogo = driver.findElement(By.className("sc-ekulBa"));
		Boolean actualResult = qitafLogo.isDisplayed();
		Boolean expectedResult = true;

		assertEquals(actualResult, expectedResult);

	}

	@Test(priority = 5)
	public void verifyingHotelsTabNotSelectedByDefault() {
		WebElement hotelsTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String actualResult = hotelsTab.getAttribute("aria-selected");
		String expectedResult = "false";
		
		assertEquals(actualResult, expectedResult);

	}
	
	@Test(priority = 6)
	public void randomMethodToChangeLang() {
		Random rand = new Random ();
		int randomIndexForWebsite = rand.nextInt(Websites.length);
		driver.get(Websites[randomIndexForWebsite]);
		
		String currentUrl = driver.getCurrentUrl();
		
		if (currentUrl.contains("ar")) {
			String expectedLang = "ar";
			String actualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			
			assertEquals(actualLang, expectedLang);
		}
		
		else {
			String expectedLang = "en";
			String actualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			 
			assertEquals(actualLang, expectedLang);
		}
		
		
		
		
	}

}
