package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.domain.RichBloke;
import com.example.demo.service.RichBlokeService;

import jdk.jfr.Experimental;

@SpringBootTest
class RichBlokeControllerTest {

	@InjectMocks
	RichBlokeController richBlokeController;

	@Mock
	private RichBlokeService richBlokeService;
	
	
	@Test
	void getRichBloke_Should_return_a_list_of_rich_blokes() {
		List<RichBloke> theRich = new ArrayList<>();
		RichBloke richBloke1 = new RichBloke();
		richBloke1.setLastName("Borat");
		
		theRich.add(richBloke1);
		
		when(richBlokeService.getRichBlokes())
		.thenReturn(theRich);
		
		ResponseEntity<List<RichBloke>> response = richBlokeController.getRichBlokes();
		System.out.println(response.getBody());
		assert(response.getBody()).equals(theRich);
		
	}
	
//	@Test
//	void saveRichBlokes_with_invalid_arguments_should_fail() {
//		RichBloke richBloke1 = new RichBloke();
//		richBloke1.setLastName("Borat");
//		ResponseEntity<List<RichBloke>> response = richBlokeController.saveRichBlokes(null);
//		assert(response.getStatusCode()).equals(HttpStatus.BAD_REQUEST);
//	}
	

	
}
