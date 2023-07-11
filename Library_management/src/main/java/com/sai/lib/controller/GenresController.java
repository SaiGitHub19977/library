package com.sai.lib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.lib.service.IGenresService;

@RestController
@RequestMapping("/genres")
public class GenresController {
	@Autowired
    private IGenresService genresService;

    @GetMapping("/getAllGenres")
    public ResponseEntity<List<String>> getAllGenres() {
        List<String> genres = genresService.getAllGenres();
        return ResponseEntity.ok(genres);
    }
}
