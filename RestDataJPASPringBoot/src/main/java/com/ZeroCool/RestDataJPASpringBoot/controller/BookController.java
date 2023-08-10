package com.ZeroCool.RestDataJPASpringBoot.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ZeroCool.RestDataJPASpringBoot.entities.Book;
import com.ZeroCool.RestDataJPASpringBoot.repository.BookRepository;

@RestController
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/api/books")
	public List<Book> findAll(){
		// recuperar y devolver todos los libros de base de datos
		return bookRepository.findAll();
	}

	
	@GetMapping("/api/books/{id}")
	public ResponseEntity<Book> findOneById(@PathVariable Long id) {
		
		Optional<Book> bookOpt = bookRepository.findFirstById(id);
		//Opcion 1
		if(bookOpt.isPresent())
			return ResponseEntity.ok(bookOpt.get());
		else
			return ResponseEntity.notFound().build();
		


	}
	
	// Crear un nuevo libro en base de datos
	
    @PostMapping("/api/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        // Crear un nuevo libro en la base de datos
        Book newBook = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @PutMapping("/api/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> existingBookOpt = bookRepository.findById(id);
        
        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            // ... Actualizar otros campos según tus necesidades ...
            
            Book updated = bookRepository.save(existingBook);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/api/books")
    public ResponseEntity<Void> deleteAllBooks() {
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        
        if (bookOpt.isPresent()) {
            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
