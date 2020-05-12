package com.app.foro.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.foro.models.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByUsername(String username);
	
	
	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUsername2(String username);
	

}
