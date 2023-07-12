package com.sai.lib.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.sai.lib.model.Genres;
import com.sai.lib.repo.GenresRepo;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class GenresServiceImplTest {
	    @Mock
	    private GenresRepo genresRepo;
	    
	    @InjectMocks
	    private GenresServiceImpl genresServiceImpl;
	    
	    @Test
	    public void testGetAllGenres() {
	    	Genres g=new Genres(1l,"fiction");
	        when(genresRepo.findAll()).thenReturn(List.of(g));
	        
	        List<Genres> list=genresServiceImpl.getAllGenres();
	        assertEquals(list.get(0).getGenre(),"fiction");
	    }
}
