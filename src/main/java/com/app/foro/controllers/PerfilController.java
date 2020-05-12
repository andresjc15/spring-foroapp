package com.app.foro.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import com.app.foro.models.entity.Perfil;
import com.app.foro.models.entity.Publicacion;
import com.app.foro.services.PerfilService;
import com.app.foro.services.PublicacionService;
import com.app.foro.services.UsuarioService;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilController {

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PublicacionService publicacionService;

	@GetMapping
	public ResponseEntity<List<Perfil>> showPerfiles() {
		try {
			List<Perfil> perfiles = perfilService.findAll();
			return new ResponseEntity<List<Perfil>>(perfiles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Perfil>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("page/{page}")
	private ResponseEntity<Page<Perfil>> showPerfiles(@PathVariable Integer page) {
		try {
			Pageable pageable = PageRequest.of(page, 5);
			Page<Perfil> perfiles = perfilService.findAll(pageable);
			return new ResponseEntity<Page<Perfil>>(perfiles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Page<Perfil>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Perfil> showPerfil(@PathVariable("id") Integer id) {
		try {
			Optional<Perfil> optional = perfilService.findById(id);
			return new ResponseEntity<Perfil>(optional.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Perfil>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Perfil> updatePerfil(@PathVariable("id") Integer id, @RequestBody Perfil perfil) {
		try {
			if (id.equals(perfil.getId())) {
				Optional<Perfil> optional = perfilService.findById(id);
				if (optional.isPresent()) {
					optional.get().setNombre(perfil.getNombre());
					optional.get().setUpdateAt(new Date());
					Perfil updatePerfil = perfilService.update(optional.get());
					return new ResponseEntity<Perfil>(updatePerfil, HttpStatus.OK);
				} else {
					return new ResponseEntity<Perfil>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<Perfil>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Perfil>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Perfil> deletePerfilFacultad(@PathVariable("id") Integer id) {
		try {
			Optional<Perfil> optional = perfilService.findById(id);
			if (optional.isPresent()) {
				perfilService.deleteById(id);
				return new ResponseEntity<Perfil>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Perfil>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Perfil>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/{id}/publicaciones")
	public ResponseEntity<?> createPublicacion(@Valid @RequestBody Publicacion publicacion, @PathVariable Integer id,
			BindingResult result) {

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			publicacion.setPerfil(perfilService.findById(id).get());//acomodar id
			Publicacion newPublicacion = publicacionService.save(publicacion);
			return new ResponseEntity<Publicacion>(newPublicacion, HttpStatus.CREATED);
		} catch (Exception e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

}
