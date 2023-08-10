package com.ZeroCool.RestDataJPASpringBoot.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ZeroCool.RestDataJPASpringBoot.entities.Book;

class BookPriceCalculatorTest extends BookPriceCalculator {

	@Test
	void testCalculatorPrice() {
		
		// configuracion de la prueba
		Book book = new Book(1L, "el señor de los anillos 2", "Tolkien", 1000, 49.99, LocalDate.now(), true);
		BookPriceCalculator calculator = new BookPriceCalculator();
		
		// se ejecuta el comportamiendo a testear
		double price = calculator.calculatorPrice(book);
		System.out.println(price);
		
		//comprobaciones aserciones
		
		assertTrue(price > 0);
		assertEquals(57.980000000000004, price);
		
	}

}
