package com.test.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.test.model.WordStorage;

public interface WordRepository extends JpaRepository<WordStorage, Long>{
	
	@Query(value = "SELECT * FROM tbl_words WHERE word = :word", nativeQuery = true)
	WordStorage findByName(@Param("word") String word);

}
