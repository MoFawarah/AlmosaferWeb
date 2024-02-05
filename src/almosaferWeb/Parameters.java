package almosaferWeb;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	Random rand = new Random();

	WebDriver driver = new ChromeDriver();
	String Url = "https://www.almosafer.com/en";

	String[] Websites = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };

	String[] citiesInEnglish = { "Dubai", "Jeddah", "Riyadh" };
	int randomEnglishCity = rand.nextInt(citiesInEnglish.length);

	String[] citiesInArabic = { "دبي", "جدة" };
	int randomArabicCity = rand.nextInt(citiesInArabic.length);

}
