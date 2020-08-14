package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.RichBloke;


public interface RichBlokeService {
	List<RichBloke> getRichBlokes();
	
	void addRichBloke(RichBloke richBloke);
}
