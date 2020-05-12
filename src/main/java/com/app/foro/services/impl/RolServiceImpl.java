package com.app.foro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.foro.models.entity.Role;
import com.app.foro.models.repository.RolRepository;
import com.app.foro.services.RolService;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Role> findAll() throws Exception {
		return rolRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Role> findAll(Pageable pageable) {
		return rolRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Role> findById(Integer id) throws Exception {
		return rolRepository.findById(id);
	}

	@Transactional
	@Override
	public Role save(Role entity) throws Exception {
		return rolRepository.save(entity);
	}

	@Transactional
	@Override
	public Role update(Role entity) throws Exception {
		return rolRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		rolRepository.deleteById(id);
	}

}
