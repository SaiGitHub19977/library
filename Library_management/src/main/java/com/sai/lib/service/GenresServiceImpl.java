package com.sai.lib.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.lib.model.Genres;
import com.sai.lib.repo.GenresRepo;


@Service
public class GenresServiceImpl implements IGenresService {
	
	@Autowired
	private GenresRepo genresRepo;

	@Override
	 public List<Genres> getAllGenres() {
         return genresRepo.findAll();
         //return list.stream().map(e->e.getGenre()).collect(Collectors.toList());
    }

}
