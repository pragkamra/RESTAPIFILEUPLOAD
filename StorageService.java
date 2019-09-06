package com.test.service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.exception.FileReadException;
import com.test.model.WordStorage;
import com.test.persistance.WordRepository;

@Service
public class StorageService {
	
	@Autowired
	WordRepository wordRepo;


	public void uploadandStoreFile(MultipartFile file) {
		Set<String> wordSet = new HashSet<String>();
	
		 if (file.isEmpty()) {
	            throw new FileReadException("Failed to read empty file");
	        }
		 
	      try {
	        	byte[] bytes = file.getBytes();
	            String data = new String(bytes);
	            String[] words = data.split("\\s++");
	            for (String word:words)
	            	wordSet.add(word);	            
	        }
	        catch (IOException e) {
				
			}
	      for(String dat:wordSet) {
	    	  WordStorage wordS = new WordStorage(); 
	    	  wordS.setWord(dat);
	    	  wordRepo.save(wordS);
	      }
		
	}

	public boolean findWord(String searchWord) {
		WordStorage word = wordRepo.findByName(searchWord);
		if (word == null)
			return false;
		else
			return true;		
	}

}
