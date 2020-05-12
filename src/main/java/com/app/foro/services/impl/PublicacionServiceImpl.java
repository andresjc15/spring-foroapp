package com.app.foro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.foro.models.entity.Publicacion;
import com.app.foro.models.repository.PublicacionRepository;
import com.app.foro.services.PublicacionService;

@Service
public class PublicacionServiceImpl implements PublicacionService {

	@Autowired
	private PublicacionRepository publicacionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Publicacion> findAll() throws Exception {
		return publicacionRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Publicacion> findAll(Pageable pageable) {
		return publicacionRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Publicacion> findById(Integer id) throws Exception {
		return publicacionRepository.findById(id);
	}

	@Transactional
	@Override
	public Publicacion save(Publicacion entity) throws Exception {
		return publicacionRepository.save(entity);
	}

	@Transactional
	@Override
	public Publicacion update(Publicacion entity) throws Exception {
		return publicacionRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		publicacionRepository.deleteById(id);
	}
	

}
