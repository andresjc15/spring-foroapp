package com.app.foro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.foro.models.entity.Categoria;
import com.app.foro.models.repository.CategoriaRepository;
import com.app.foro.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Categoria> findAll() throws Exception {
		return categoriaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Categoria> findAll(Pageable pageable) {
		return categoriaRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Categoria> findById(Integer id) throws Exception {
		return categoriaRepository.findById(id);
	}

	@Transactional
	@Override
	public Categoria save(Categoria entity) throws Exception {
		return categoriaRepository.save(entity);
	}

	@Transactional
	@Override
	public Categoria update(Categoria entity) throws Exception {
		return categoriaRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		categoriaRepository.deleteById(id);
	}

}
