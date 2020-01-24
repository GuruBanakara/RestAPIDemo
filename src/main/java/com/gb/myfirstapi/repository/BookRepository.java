package com.gb.myfirstapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gb.myfirstapi.bean.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByAuthorName(String authorName);

	

}
