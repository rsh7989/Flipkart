package com.flipkart.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.Baseclass.Baseclass;

public class List_of_books extends Baseclass {

	@FindBy(xpath = "//div[@class='slAVV4']")
	public List<WebElement> load_list;

	@FindBy(xpath = "//a[@class='wjcEIp']")
	public List<WebElement> book_name;

	@FindBy(xpath = "//div[@class='XQDdHH']")
	public List<WebElement> book_ratings;

	@FindBy(xpath = "//div[@class='Nx9bqj']")
	public List<WebElement> book_price;

	public List_of_books() {
		PageFactory.initElements(driver, this);
	}

}
