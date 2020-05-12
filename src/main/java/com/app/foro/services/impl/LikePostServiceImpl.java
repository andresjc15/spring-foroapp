package com.app.foro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.foro.models.entity.LikePost;
import com.app.foro.models.repository.LikePostRepository;
import com.app.foro.services.LikePostService;

@Service
public class LikePostServiceImpl implements LikePostService {

	@Autowired
	private LikePostRepository likePostRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<LikePost> findAll() throws Exception {
		return likePostRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<LikePost> findAll(Pageable pageable) {
		return likePostRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<LikePost> findById(Integer id) throws Exception {
		return likePostRepository.findById(id);
	}

	@Transactional
	@Override
	public LikePost save(LikePost entity) throws Exception {
		return likePostRepository.save(entity);
	}

	@Transactional
	@Override
	public LikePost update(LikePost entity) throws Exception {
		return likePostRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		likePostRepository.deleteById(id);
	}

}
