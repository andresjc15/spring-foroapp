package com.app.foro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.foro.models.entity.Publicacion;
import com.app.foro.services.PublicacionService;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {
	
	@Autowired
	private PublicacionService publicacionService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<Publicacion>> fetchPublicaciones() {
		try {
			List<Publicacion> publicaciones = publicacionService.findAll();
			return new ResponseEntity<List<Publicacion>>(publicaciones, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Publicacion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("page/{page}")
	private ResponseEntity<Page<Publicacion>> showPublicaciones(@PathVariable Integer page) {
		try {
			Pageable pageable = PageRequest.of(page, 5);
			Page<Publicacion> publicaciones = publicacionService.findAll(pageable);
			return new ResponseEntity<Page<Publicacion>>(publicaciones, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Page<Publicacion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
