package com.sai.lib.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.sai.lib.model.Book;
import com.sai.lib.model.Genres;
import com.sai.lib.repo.BookRepo;
import com.sai.lib.service.BookServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {
	@Mock
    private BookRepo bookRepo;
    
    @InjectMocks
    private BookServiceImpl bookServiceImpl;
    
    @Test
    public void testAddBook() {
    	Genres g=new Genres();
    	g.setGenresId(1l);
        // Create a test book
        Book book = new Book();
        book.setTitle("The Great Gatsby");
        book.setAuthor("F. Scott Fitzgerald");
        book.setGenresId(g);
        
        // Mock the repository save method
        when(bookRepo.save(book)).thenReturn(book);
        
        // Add the book
        Book addedBook = bookServiceImpl.addBook(book);
        
        // Verify the save method was called and book was returned
        verify(bookRepo).save(book);
        assertEquals(book, addedBook);
    }

}


