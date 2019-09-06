package com.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_words")
public class WordStorage implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "word_ID", unique = true, nullable = false)
	private Long word_id;
	
	/**
	 * @return the word_id
	 */
	public Long getWord_id() {
		return word_id;
	}

	/**
	 * @param word_id the word_id to set
	 */
	public void setWord_id(Long word_id) {
		this.word_id = word_id;
	}

	@Column(name="word")
	private String word;

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}
	  
	

}
