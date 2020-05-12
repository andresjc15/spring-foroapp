package com.app.foro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.foro.models.entity.Comentario;
import com.app.foro.models.repository.ComentarioRepository;
import com.app.foro.services.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService {
	
	@Autowired
	private  ComentarioRepository comentarioRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Comentario> findAll() throws Exception {
		return comentarioRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Comentario> findAll(Pageable pageable) {
		return comentarioRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Comentario> findById(Integer id) throws Exception {
		return comentarioRepository.findById(id);
	}

	@Transactional
	@Override
	public Comentario save(Comentario entity) throws Exception {
		return comentarioRepository.save(entity);
	}

	@Transactional
	@Override
	public Comentario update(Comentario entity) throws Exception {
		return comentarioRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		comentarioRepository.deleteById(id);
	}
	

}
