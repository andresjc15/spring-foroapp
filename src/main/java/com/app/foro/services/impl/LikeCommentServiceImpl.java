package com.app.foro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.foro.models.entity.LikeComment;
import com.app.foro.models.repository.LikeCommentRepository;
import com.app.foro.services.LikeComenntService;

@Service
public class LikeCommentServiceImpl implements LikeComenntService {
	
	@Autowired
	private LikeCommentRepository likeCommentRepository;

	@Transactional(readOnly = true)
	@Override
	public List<LikeComment> findAll() throws Exception {
		return likeCommentRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Page<LikeComment> findAll(Pageable pageable) {
		return likeCommentRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<LikeComment> findById(Integer id) throws Exception {
		return likeCommentRepository.findById(id);
	}

	@Transactional
	@Override
	public LikeComment save(LikeComment entity) throws Exception {
		return likeCommentRepository.save(entity);
	}

	@Transactional
	@Override
	public LikeComment update(LikeComment entity) throws Exception {
		return likeCommentRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		likeCommentRepository.deleteById(id);
	}
	
	

}
