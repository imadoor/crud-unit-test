package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.RichBloke;
//import com.example.demo.service.RichBlokeImpl;
import com.example.demo.service.RichBlokeService;

@RestController
@RequestMapping("/api/v1")
public class RichBlokeController {
	@Autowired
	private RichBlokeService richBlokeService;
	
	@GetMapping(path="/rb", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RichBloke>> getRichBlokes(){
		
		return new ResponseEntity<List<RichBloke>>(richBlokeService.getRichBlokes(), HttpStatus.OK);
	}
	
	@PostMapping(path="/rb", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RichBloke>> saveRichBlokes(@RequestBody RichBloke richBloke) throws Exception{
		if(richBloke != null) {
			richBlokeService.addRichBloke(richBloke);
			return new ResponseEntity<List<RichBloke>>(richBlokeService.getRichBlokes(), HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
		
		
		
	}
}
