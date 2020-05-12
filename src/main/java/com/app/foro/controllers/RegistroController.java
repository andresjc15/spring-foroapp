package com.app.foro.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.foro.models.entity.Carrera;
import com.app.foro.models.entity.Perfil;
import com.app.foro.models.entity.Usuario;
import com.app.foro.services.CarreraService;
import com.app.foro.services.PerfilService;
import com.app.foro.services.RegistroService;
import com.app.foro.services.RolService;

@RestController
@RequestMapping("/api/register")
public class RegistroController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RegistroService registroService;
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private CarreraService carreraService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity< List<Usuario> > fetchFacultades(){
		try {
			List<Usuario> usuarios = registroService.findAll();
			return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Usuario>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> registerPerfil(@Valid @RequestBody Perfil perfil
			, BindingResult result) throws Exception {
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			String passwordBcrypt = passwordEncoder.encode(perfil.getUsuario().getPassword());
			perfil.getUsuario().setPassword(passwordBcrypt);
			perfil.getUsuario().setEnabled(true);
			
			//Carrera newCarrera = carreraService.findById(perfil.getCarrera().getId());
			
			perfil.setCarrera(carreraService.findById(perfil.getCarrera().getId()).get());
			
			Perfil newPerfil = perfilService.save(perfil);
			
			
			return new ResponseEntity<Perfil>(newPerfil, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
	/*
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> registerUser(@RequestBody Usuario usuario, 
			@RequestBody Perfil perfil) {
		try {
			String passwordBcrypt = passwordEncoder.encode(usuario.getPassword());
			usuario.setPassword(passwordBcrypt);
			usuario.setEnabled(true);
			/*usuario.setRoles(Arrays.asList(rolService.findById(1).get()));
			Usuario newUser = registroService.save(usuario);
			
			
			
			
			return new ResponseEntity<Usuario>(newUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
}
