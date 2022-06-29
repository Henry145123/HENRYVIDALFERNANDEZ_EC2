package com.idat.HenryVidalFernandezBodega.dto;

public class UsuarioDTOResponse {

	private Integer id;
	private String usuario;
	private String contrasenia;
	
	private String rolUsuario;
	

	private String token;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRolUsuario() {
		return rolUsuario;
	}
	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UsuarioDTOResponse(String token) {
		super();
		this.token = token;
	}

	public UsuarioDTOResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
