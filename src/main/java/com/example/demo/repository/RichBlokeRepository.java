package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.RichBloke;

public interface RichBlokeRepository extends JpaRepository<RichBloke, Long>{

}
