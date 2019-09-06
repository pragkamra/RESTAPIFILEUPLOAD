package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.exception.FileReadException;
import com.test.service.StorageService;

@RestController
public class FileController {
	
	@Autowired
	StorageService  storageService;
	
	 @RequestMapping(value = "/uploadFile", method = RequestMethod.POST,
	            consumes = {"multipart/form-data"})
	  public String upload(@RequestParam MultipartFile file) {

	        storageService.uploadandStoreFile(file);

	        return "File Upoaded Successfully";
	    }
	 
	    
	    @GetMapping(value = "/searchWord")
	    public boolean searchWord(@RequestParam String searchWord) {
	    	boolean isWordFound =  storageService.findWord(searchWord);
	    	if (isWordFound)
	    		return true;
	    	
			return false;
	    }
	    

}
