package com.app.foro.controllers;

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

import com.app.foro.models.entity.Carrera;
import com.app.foro.models.entity.Facultad;
import com.app.foro.services.CarreraService;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {

	@Autowired
	private CarreraService carreraService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<List<Carrera>> fetchCarreras() {
		try {
			List<Carrera> carreras = carreraService.findAll();
			return new ResponseEntity<List<Carrera>>(carreras, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Carrera>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("page/{page}")
	private ResponseEntity<Page<Carrera>> showCarreras(@PathVariable Integer page) {
		try {
			Pageable pageable = PageRequest.of(page, 5);
			Page<Carrera> carreras = carreraService.findAll(pageable);
			return new ResponseEntity<Page<Carrera>>(carreras, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Page<Carrera>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Carrera> showCarrera(@PathVariable("id") Integer id) {
		try {
			Optional<Carrera> optional = carreraService.findById(id);
			return new ResponseEntity<Carrera>(optional.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Carrera>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Carrera> saveCarrera(@RequestBody Carrera carrera) {
		try {
			Carrera newCarrera = carreraService.save(carrera);
			return new ResponseEntity<Carrera>(newCarrera, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Carrera>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Carrera> updateCarrera(@PathVariable("id") Integer id, @RequestBody Carrera carrera) {
		try {
			if (id.equals(carrera.getId())) {
				Optional<Carrera> optional = carreraService.findById(id);
				if (optional.isPresent()) {
					optional.get().setNombre(carrera.getNombre());
					Carrera updateCarrera = carreraService.update(optional.get());
					return new ResponseEntity<Carrera>(updateCarrera, HttpStatus.OK);
				} else {
					return new ResponseEntity<Carrera>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<Carrera>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Carrera>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Carrera> deleteCarrera(@PathVariable("id") Integer id) {
		try {
			Optional<Carrera> optional = carreraService.findById(id);
			if (optional.isPresent()) {
				carreraService.deleteById(id);
				return new ResponseEntity<Carrera>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Carrera>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Carrera>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
