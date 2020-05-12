package com.app.foro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.foro.models.entity.Carrera;
import com.app.foro.models.repository.CarreraRepository;
import com.app.foro.services.CarreraService;

@Service
public class CarreraServiceImpl implements CarreraService {

	@Autowired
	private CarreraRepository carreraRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Carrera> findAll() throws Exception {
		return carreraRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Carrera> findAll(Pageable pageable) {
		return carreraRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Carrera> findById(Integer id) throws Exception {
		return carreraRepository.findById(id);
	}

	@Transactional
	@Override
	public Carrera save(Carrera entity) throws Exception {
		return carreraRepository.save(entity);
	}

	@Transactional
	@Override
	public Carrera update(Carrera entity) throws Exception {
		return carreraRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		carreraRepository.deleteById(id);
	}

}
