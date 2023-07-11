package com.sai.lib.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sai.lib.model.Book;
@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
	@Query(value="SELECT b.title FROM book b join genres g on b.genres_id=g.genres_id where g.genre= :genre",nativeQuery=true)
    public List<String> findByGenre(@Param("genre") String genre);

}
