package com.sai.lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.lib.model.Book;
import com.sai.lib.repo.BookRepo;

@Service
public class BookServiceImpl implements IBookService {
	@Autowired
	private BookRepo bookRepo;

	@Override
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public String updateBook(Long bookId, Book updatedBook) {
		return bookRepo.findById(bookId)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setGenresId(updatedBook.getGenresId());
                    // Update other book properties as needed
                    bookRepo.save(book);
                    return "User successfully updated";
                }).orElse("User not found");
  
	}

	@Override
	public List<String> getBooksByGenre(String genre) {
		 return bookRepo.findByGenre(genre);
	}

}
