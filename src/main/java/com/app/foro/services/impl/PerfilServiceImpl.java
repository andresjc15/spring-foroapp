package com.app.foro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.foro.models.entity.Perfil;
import com.app.foro.models.repository.PerfilRepository;
import com.app.foro.services.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Perfil> findAll() throws Exception {
		return perfilRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Perfil> findAll(Pageable pageable) {
		return perfilRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Perfil> findById(Integer id) throws Exception {
		return perfilRepository.findById(id);
	}

	@Transactional
	@Override
	public Perfil save(Perfil entity) throws Exception {
		return perfilRepository.save(entity);
	}

	@Transactional
	@Override
	public Perfil update(Perfil entity) throws Exception {
		return perfilRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		perfilRepository.deleteById(id);
	}
	
}
