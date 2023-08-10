package com.ZeroCool.RestDataJPASpringBoot.service;

import com.ZeroCool.RestDataJPASpringBoot.entities.Book;

public class BookPriceCalculator {

	public double calculatorPrice(Book book) {
		double price = book.getPrice();
		
		if(book.getPages() > 300 ) {
			price += 5;
		}
		// envio
		price += 2.99;
		return price;
	}
}
