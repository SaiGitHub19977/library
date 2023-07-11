package com.sai.lib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sai.lib.model.Book;
import com.sai.lib.service.IBookService;

@RestController
@RequestMapping("/books")
public class BookController {
    
	@Autowired
	private IBookService bookService;
	
	@GetMapping("/hello")
	public ResponseEntity<String> getHello(){
		return ResponseEntity.ok("hello");
	} 

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("user Created successfully");
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable Long bookId, @RequestBody Book updatedBook) {
        String updated = bookService.updateBook(bookId, updatedBook);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/getAllBooksByGenre")
    public ResponseEntity<List<String>> getBooksByGenre(@RequestParam("genre") String genre) {
        List<String> books = bookService.getBooksByGenre(genre);
        return ResponseEntity.ok(books);
    }
}
