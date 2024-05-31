package com.flipkart.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.Baseclass.Baseclass;

public class Indexpage extends Baseclass {

	@FindBy(xpath = "//input[@type='text']")
	public WebElement search_box;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement submit_btn;

	public Indexpage() {
		PageFactory.initElements(driver, this);
	}
}
