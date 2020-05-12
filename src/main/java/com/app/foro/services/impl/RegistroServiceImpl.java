package com.app.foro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.foro.models.entity.Usuario;
import com.app.foro.models.repository.RegistroRepository;
import com.app.foro.services.RegistroService;

@Service
public class RegistroServiceImpl implements RegistroService {

	@Autowired
	public RegistroRepository registroRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() throws Exception {
		return registroRepository.findAll();
	}

	@Override
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Usuario> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Usuario save(Usuario entity) throws Exception {
		return registroRepository.save(entity);
	}

	@Override
	public Usuario update(Usuario entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
