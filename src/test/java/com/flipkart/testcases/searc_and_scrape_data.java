package com.flipkart.testcases;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.Actiondriver.Actiondriver;
import com.flipkart.Baseclass.Baseclass;
import com.flipkart.pageobject.Indexpage;
import com.flipkart.pageobject.List_of_books;

public class searc_and_scrape_data extends Baseclass {

	public static Indexpage index;
	public static List_of_books booklist;

	@BeforeMethod
	public void setup() {
		launchwebpage();
	}

	@AfterMethod
	public void teaardown() {
		driver.quit();
	}

	@Test
	public static void searchbook() {

		Indexpage index = new Indexpage();
   
	  // Launching webapplication and searching required products
		Actiondriver.isdisplayed(index.search_box);
		index.search_box.sendKeys("Hindi Books");

		Actiondriver.isdisplayed(index.submit_btn);
		index.submit_btn.click();

		booklist = new List_of_books();

		System.out.println(booklist.load_list.size());

	  // Iteration for extracting the data like name,rating and price of book one by one and storing it in jsonarray	
		for (int i = 0; i < booklist.load_list.size(); i++) {

			JSONObject bookmetadata = new JSONObject();

			Actiondriver.isdisplayed(booklist.book_name.get(i));
			bookmetadata.put("Book Name", booklist.book_name.get(i).getText());

			Actiondriver.isdisplayed(booklist.book_ratings.get(i));
			bookmetadata.put("Book Rating", booklist.book_ratings.get(i).getText());

			Actiondriver.isdisplayed(booklist.book_price.get(i));
			bookmetadata.put("Book Price", booklist.book_price.get(i).getText().replaceAll("[^a-zA-Z0-9]", ""));

			scrapedata.put(bookmetadata);

		// Extracted data is written in structured json file format	
			try {
				FileWriter file = new FileWriter("hindi_books.json", false);
				file.write(scrapedata.toString());
				file.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println(scrapedata.toString());
	}

}
