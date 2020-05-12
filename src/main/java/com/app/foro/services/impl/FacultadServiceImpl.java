package com.app.foro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.foro.models.entity.Facultad;
import com.app.foro.models.repository.FacultadRepository;
import com.app.foro.services.FacultadService;

@Service
public class FacultadServiceImpl implements FacultadService {

	@Autowired
	private FacultadRepository facultadRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Facultad> findAll() throws Exception {
		return facultadRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Facultad> findAll(Pageable pageable) {
		return facultadRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Facultad> findById(Integer id) throws Exception {
		return facultadRepository.findById(id);
	}

	@Transactional
	@Override
	public Facultad save(Facultad entity) throws Exception {
		return facultadRepository.save(entity);
	}

	@Transactional
	@Override
	public Facultad update(Facultad entity) throws Exception {
		return facultadRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		facultadRepository.deleteById(id);
		
	}

}
