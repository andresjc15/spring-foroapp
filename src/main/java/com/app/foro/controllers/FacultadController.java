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

import com.app.foro.models.entity.Carrera;
import com.app.foro.models.entity.Facultad;
import com.app.foro.services.CarreraService;
import com.app.foro.services.FacultadService;

@RestController
@RequestMapping("/api/facultades")
public class FacultadController {
	
	@Autowired
	private FacultadService facultadService;
	
	@Autowired
	private CarreraService carreraService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Facultad> > fetchFacultades(){
		try {
			List<Facultad> facultades = facultadService.findAll();
			return new ResponseEntity<List<Facultad>>(facultades, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Facultad>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("page/{page}")
	private ResponseEntity<Page<Facultad>> showFacultades(@PathVariable Integer page) {
		try {
			Pageable pageable = PageRequest.of(page, 5);
			Page<Facultad> facultades = facultadService.findAll(pageable);
			return new ResponseEntity<Page<Facultad>>(facultades, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Page<Facultad>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Facultad> showFacultad(@PathVariable("id") Integer id) {
		try {
			Optional<Facultad> optional = facultadService.findById(id);
			return new ResponseEntity<Facultad>(optional.get(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Facultad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Facultad > saveFacultad(@RequestBody Facultad facultad){
		try {
			Facultad newFacultad = facultadService.save(facultad);
			return new ResponseEntity<Facultad>(newFacultad, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Facultad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Facultad> updateFacultad(@PathVariable("id") Integer id,
			@RequestBody Facultad facultad) {
		try {
			if(id.equals(facultad.getId())) {
				Optional<Facultad> optional = facultadService.findById(id);
				if(optional.isPresent()) {
					optional.get().setId(facultad.getId());
					optional.get().setNombre(facultad.getNombre());
					optional.get().setUpdateAt( new Date());
					Facultad updateFacultad = facultadService.update(optional.get());
					return new ResponseEntity<Facultad>(updateFacultad,
							HttpStatus.OK);
				} else {
					return new ResponseEntity<Facultad>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<Facultad>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Facultad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Facultad> deleteFacultad(@PathVariable("id") Integer id){
		try {
			Optional<Facultad> optional = facultadService.findById(id);
			if(optional.isPresent()) {
				facultadService.deleteById(id);
				return new ResponseEntity<Facultad>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Facultad>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Facultad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{id}/carreras")
	public ResponseEntity<List<Carrera>> showAlquiler(@PathVariable("id") Integer id){
		try {
			Optional<Facultad> optional = facultadService.findById(id);
			if(optional.isPresent()) {
				return new ResponseEntity<List<Carrera>>(
						optional.get().getCarreras(),HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Carrera>>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Carrera>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/{id}/carreras", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Carrera> saveCarrera(@PathVariable("id") Integer id,
			@RequestBody Carrera carrera){
		try {
			Optional<Facultad> optional = facultadService.findById(id);
			if(optional.isPresent()) {
				carrera.setFacultad( optional.get() );
				Carrera nuevaCarrera = carreraService.save(carrera);
				return new ResponseEntity<Carrera>(nuevaCarrera, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Carrera>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Carrera>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/*
	@GetMapping(path = "/{id}/carreras/page/{page}")
	public ResponseEntity<Page<Carrera>> showAlquilerPage(@PathVariable("id") Integer id,
			@PathVariable("page") Integer page){
		try {
			Optional<Facultad> optional = facultadService.findById(id);
			if(optional.isPresent()) {
				Pageable pageable = PageRequest.of(page, 5);
				Page<Carrera> carreras = carreraService.findAll(pageable);
				return new ResponseEntity<Page<Carrera>>( HttpStatus.OK);
			} else {
				return new ResponseEntity<Page<Carrera>>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Page<Carrera>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/

}
