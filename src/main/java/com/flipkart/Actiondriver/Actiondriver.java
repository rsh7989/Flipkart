package com.flipkart.Actiondriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.Baseclass.Baseclass;

public class Actiondriver extends Baseclass {

	public static void implictwait(WebDriver driver, int seconds) {

		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public static void pageloadtimeout(WebDriver driver, int seconds) {

		driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
	}

	public static void explicitwait(WebDriver driver, Duration seconds, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static boolean isdisplayed(WebElement element) {

		boolean flag = false;
		try {
			element.isDisplayed();
			flag = true;
		} finally {

			if (flag) {
				System.out.println(element.getText() + " Element is Displayed");
			} else {
				System.out.println(element.getText() + " Element is not located/diaplayed");
			}
		}

		return flag;
	}

	public static boolean isenabled(WebElement element) {

		boolean flag = false;
		try {
			element.isEnabled();
			flag = true;
		} finally {

			if (flag) {
				System.out.println(element.getText() + " Element is Enabled");
			} else {
				System.out.println(element.getText() + " Element is disabled");
			}
		}

		return flag;
	}

	public static void movetoelement(WebElement element, WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(element);

	}

}
