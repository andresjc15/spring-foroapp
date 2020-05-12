package com.app.foro.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.foro.models.entity.Categoria;
import com.app.foro.models.entity.Categoria;
import com.app.foro.services.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<Categoria>> fetchCategorias() {
		try {
			List<Categoria> categorias = categoriaService.findAll();
			return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Categoria>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("page/{page}")
	private ResponseEntity<Page<Categoria>> showCategorias(@PathVariable Integer page) {
		try {
			Pageable pageable = PageRequest.of(page, 5);
			Page<Categoria> categorias = categoriaService.findAll(pageable);
			return new ResponseEntity<Page<Categoria>>(categorias, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Page<Categoria>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Categoria> showCategoria(@PathVariable("id") Integer id) {
		try {
			Optional<Categoria> optional = categoriaService.findById(id);
			return new ResponseEntity<Categoria>(optional.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Categoria>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
		try {
			Categoria newCategoria = categoriaService.save(categoria);
			return new ResponseEntity<Categoria>(newCategoria, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Categoria>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> updateCategoria(@PathVariable("id") Integer id, @RequestBody Categoria categoria) {
		try {
			if (id.equals(categoria.getId())) {
				Optional<Categoria> optional = categoriaService.findById(id);
				if (optional.isPresent()) {
					optional.get().setNombre(categoria.getNombre());
					optional.get().setUpdateAt( new Date());
					Categoria updateCategoria = categoriaService.update(optional.get());
					return new ResponseEntity<Categoria>(updateCategoria, HttpStatus.OK);
				} else {
					return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<Categoria>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Categoria>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Categoria> deleteCarrera(@PathVariable("id") Integer id) {
		try {
			Optional<Categoria> optional = categoriaService.findById(id);
			if (optional.isPresent()) {
				categoriaService.deleteById(id);
				return new ResponseEntity<Categoria>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Categoria>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
