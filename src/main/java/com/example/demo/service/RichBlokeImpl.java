package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.RichBloke;
import com.example.demo.repository.RichBlokeRepository;

@Service
public class RichBlokeImpl implements RichBlokeService{
	@Autowired
	private RichBlokeRepository richBlokeRepository;
	
	

	public List<RichBloke> getRichBlokes() {
		return richBlokeRepository
				.findAll()
				.stream()
				.collect(Collectors.toList());
	}
	
	public void addRichBloke(RichBloke richBloke) {
		richBlokeRepository.save(richBloke);
		//richBlokeRepository.saveAndFlush(richBloke);
	}

}

