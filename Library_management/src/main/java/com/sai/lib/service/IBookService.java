package com.sai.lib.service;

import java.util.List;

import com.sai.lib.model.Book;

public interface IBookService {
	public Book addBook(Book book);
	public String updateBook(Long bookId, Book updatedBook);
	public List<String> getBooksByGenre(String genre);
}

