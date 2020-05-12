package com.app.foro.services;

import com.app.foro.models.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario, Integer> {
	
	
	public Usuario findByUsername(String username);
	

}
