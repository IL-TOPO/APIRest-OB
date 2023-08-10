package com.ZeroCool.RestDataJPASpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class RestDataJpasPringBootApplication {
		public static void main(String[] args) {
			SpringApplication.run(RestDataJpasPringBootApplication.class, args);
		}
		
//		// CRUD
//		// Crear libro
//		Book book1 = new Book(null, "Homo Deus", "Yual Noah", 450, 29.99, LocalDate.of(2018,12,1),true);
//		Book book2 = new Book(null, "Homo Sapiens", "Yual Noah", 450, 19.99, LocalDate.of(2013,12,1),true);
//		// Almacenar libro
//		System.out.println("Número de libros en base de datos: " + repository.findAll().size());
//
//		repository.save(book1);
//		repository.save(book2);
//
//		// Recuperar libro
//		System.out.println("Número de libros en base de datos: " + repository.findAll().size());
//
//		// Borrar libro
//		//repository.deleteById(1L);
//
//		//System.out.println("Número de libros en base de datos: " + repository.findAll().size());
		


}
