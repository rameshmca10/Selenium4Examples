package testcases;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().maximize();

		// System.out.println(driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr")).size());
		// System.out.println(driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr[1]/td")).size());

		int rows = driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr")).size();
		int cols = driver.findElements(By.xpath("//table[@class='dataTable']//tbody/tr[1]/td")).size();

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {

				System.out.print(
						driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + i + "]/td[" + j + "]"))
								.getText() + "\t");
			}

			System.out.println();
		}

		driver.close();
		
	}

	public void temp() {
		ChromeOptions opt1 = new ChromeOptions();
		// opt.setHeadless(true);

		// DevTools devTools = ((ChromeDriver) driver).getDevTools();
		// devTools.createSession();

		Map<String, String> device = new HashMap<String, String>();
		device.put("deviceName", "iPhone X");

		opt1.setExperimentalOption("mobileEmulation", device);
		// devTools.

		WebDriver driver = new ChromeDriver();

		// https://mycurrentlocation.net
		// http://automationpractice.com/index.php

		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		// Set Chrome window size
		// driver.manage().window().setSize(new Dimension(1552, 840));

		Map<String, Object> mobile = new HashMap<String, Object>() {
			{
				put("width", 300);
				put("height", 600);
				put("mobile", true);
				put("deviceScaleFactor", true);
			}
		};

		((ChromeDriver) driver).executeCdpCommand("", mobile);

		// Enter Firstname
		driver.findElement(By.name("firstname")).click();
		driver.findElement(By.name("firstname"));
		driver.findElement(By.name("firstname")).sendKeys("Tom");
		// Set Lastname
		driver.findElement(By.name("lastname")).click();
		driver.findElement(By.name("lastname")).sendKeys("Wood");
		// Select Gender
		driver.findElement(By.id("sex-0")).click();
		// Select Experience
		driver.findElement(By.id("exp-4")).click();
		// Enter Date
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.id("datepicker")).sendKeys("16-10-2020");
		// Select Profession
		driver.findElement(By.id("profession-1")).click();
		// Select Automation Tool
		driver.findElement(By.id("tool-2")).click();

		// Select Continent
		driver.findElement(By.id("continents")).click();
		WebElement dropdown1 = driver.findElement(By.id("continents"));
		dropdown1.findElement(By.xpath("//option[. = 'Europe']")).click();

		// Select Command
		WebElement dropdown2 = driver.findElement(By.id("selenium_commands"));
		dropdown2.findElement(By.xpath("//option[. = 'Browser Commands']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll Vertical
		js.executeScript("window.scrollTo(0,675.5555419921875)");

		// Click Submit
		driver.findElement(By.id("submit")).click();

		js.executeScript("alert('Welcome to Selenium');");

		driver.close();
	}

}