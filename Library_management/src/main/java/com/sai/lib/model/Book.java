package com.sai.lib.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long bookId;
	private String title;
	private String author;
	
	@ManyToOne()
	@JoinColumn(name="genresId",nullable=false)
	private Genres genresId;

}
