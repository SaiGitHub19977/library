package com.sai.lib.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.lib.model.Genres;
@Repository
public interface GenresRepo extends JpaRepository<Genres, Long> {

}
