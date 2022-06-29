package com.idat.HenryVidalFernandezBodega.service;

import java.util.List;

import com.idat.HenryVidalFernandezBodega.dto.UsuarioDTORequest;
import com.idat.HenryVidalFernandezBodega.dto.UsuarioDTOResponse;

public interface UsuarioService {
	
	void guardarUsuario(UsuarioDTORequest usuario);
	void actualizarUsuario(UsuarioDTORequest usuario);
	void eliminarUsuario(Integer id);
	List<UsuarioDTOResponse> listarUsuarios();
	UsuarioDTOResponse obtenerUsuarioId(Integer id);

}
