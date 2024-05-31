package com.flipkart.Baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Baseclass {

	public static Properties prop;

	public static WebDriver driver;

	public static JSONArray scrapedata = new JSONArray();

	@BeforeSuite
	public void loadconfig() throws IOException {

		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
		}

		catch (FileNotFoundException fp) {
			fp.printStackTrace();
		}

		catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public void launchwebpage() {

		String browsername = prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("IE")) {

			driver = new InternetExplorerDriver();
		}
		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

	}

	@AfterSuite
	public void aftersuite() {

	}

}
