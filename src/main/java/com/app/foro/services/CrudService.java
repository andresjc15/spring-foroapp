package com.app.foro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T, ID> {
	List<T> findAll() throws Exception;
	Page<T> findAll(Pageable pageable);
	Optional<T> findById( ID id ) throws Exception;
	T save( T entity ) throws Exception;
	T update( T entity ) throws Exception;	
	void deleteById( ID id ) throws Exception;
}