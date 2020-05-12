package com.app.foro.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "perfiles")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Nombre vacio, introduzca un nombre")
	@Column(length = 100)
	private String nombre;
	
	@NotNull(message = "Apellido vacio, introduzca un nombre")
	@Column(length = 100)
	private String apellido;
	
	@Email(message = "Correo invalido")
	@Column(length = 50)
	private String email;
	
	@Column(length = 1000)
	private String descripcion;
	
	@Column(length = 15)
	private Integer telefono;
	
	@Column(length = 60)
	private String direccion;
	
	@NotNull
	@Column(length = 30)
	private String genero;
	
	@Column(length = 30)
	private String pais;
	
	private String foto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@JsonIgnoreProperties("perfil")
	@ManyToOne
	@JoinColumn(name = "carrera_id")
	private Carrera carrera;
	
	@JsonIgnoreProperties("perfil")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil", cascade = CascadeType.ALL)
	private List<Publicacion> publicaciones;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil", cascade = CascadeType.ALL)
	private List<LikeComment> likesComment;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil", cascade = CascadeType.ALL)
	private List<LikePost> likesPost;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil", cascade = CascadeType.ALL)
	private List<Comentario> comentarios;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public List<LikeComment> getLikesComment() {
		return likesComment;
	}

	public void setLikesComment(List<LikeComment> likesComment) {
		this.likesComment = likesComment;
	}

	public List<LikePost> getLikesPost() {
		return likesPost;
	}

	public void setLikesPost(List<LikePost> likesPost) {
		this.likesPost = likesPost;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	
	
	

}
