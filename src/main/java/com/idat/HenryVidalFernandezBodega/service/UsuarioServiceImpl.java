package com.idat.HenryVidalFernandezBodega.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.HenryVidalFernandezBodega.dto.UsuarioDTORequest;
import com.idat.HenryVidalFernandezBodega.dto.UsuarioDTOResponse;
import com.idat.HenryVidalFernandezBodega.model.Usuario;
import com.idat.HenryVidalFernandezBodega.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl  implements UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public void guardarUsuario(UsuarioDTORequest usuario) {
		
		Usuario u = new Usuario();
		
		u.setUsuario(usuario.getUsuario());
		u.setPassword(usuario.getContrasenia());
		u.setRol(usuario.getRolUsuario());

		repository.save(u);
		
	}

	@Override
	public void actualizarUsuario(UsuarioDTORequest usuario) {
		
		Usuario u = new Usuario();
		
		u.setIdUsuario(usuario.getId());
		u.setUsuario(usuario.getUsuario());
		u.setPassword(usuario.getContrasenia());
		u.setRol(usuario.getRolUsuario());
		
		repository.saveAndFlush(u);
		
	}

	@Override
	public void eliminarUsuario(Integer id) {
		
		repository.deleteById(id);
	}

	@Override
	public List<UsuarioDTOResponse> listarUsuarios() {
		
		
		List<UsuarioDTOResponse> listar = new ArrayList<>();
		
		UsuarioDTOResponse dto = null;
		
		List<Usuario> u = repository.findAll();
		
		for (Usuario usuario : u) {
			
			dto = new UsuarioDTOResponse();
			
			dto.setId(usuario.getIdUsuario());
			dto.setUsuario(usuario.getUsuario());
			dto.setContrasenia(usuario.getPassword());
			dto.setRolUsuario(usuario.getRol());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public UsuarioDTOResponse obtenerUsuarioId(Integer id) {

		Usuario usuario = repository.findById(id).orElse(null);
		UsuarioDTOResponse dto = new UsuarioDTOResponse();
		
		dto.setId(usuario.getIdUsuario());
		dto.setUsuario(usuario.getUsuario());
		dto.setContrasenia(usuario.getPassword());
		dto.setRolUsuario(usuario.getRol());
		
		return dto;
	}

}
