package com.idat.HenryVidalFernandezBodega.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.HenryVidalFernandezBodega.dto.ClienteDTORequest;
import com.idat.HenryVidalFernandezBodega.dto.ClienteDTOResponse;
import com.idat.HenryVidalFernandezBodega.model.Cliente;
import com.idat.HenryVidalFernandezBodega.repository.ClienteRepository;

@Service
public class ClienteServiceImpl  implements ClienteService{

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		
		Cliente c = new Cliente();
		
		c.setNombre(cliente.getNombreCliente());
		c.setDireccion(cliente.getDireccionCliente());
		c.setDni(cliente.getDireccionCliente());
		repository.save(c);
		
	}

	@Override
	public void actualizarCliente(ClienteDTORequest cliente) {
		Cliente c = new Cliente();
		
		c.setIdCliente(cliente.getId());
		c.setNombre(cliente.getNombreCliente());
		c.setDireccion(cliente.getDireccionCliente());
		c.setDni(cliente.getDireccionCliente());
		
		repository.saveAndFlush(c);
		
	}

	@Override
	public void eliminarCliente(Integer id) {
		
		repository.deleteById(id);
	}

	@Override
	public List<ClienteDTOResponse> listarClientes() {
		
		
		List<ClienteDTOResponse> listar = new ArrayList<>();
		
		ClienteDTOResponse dto = null;
		
		List<Cliente> c = repository.findAll();
		
		for (Cliente cliente : c) {
			
			dto = new ClienteDTOResponse();
			
			dto.setDireccionCliente(cliente.getDireccion());
			dto.setNombreCliente(cliente.getNombre());
			dto.setDniCliente(cliente.getDni());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {

		Cliente cliente = repository.findById(id).orElse(null);
		ClienteDTOResponse dto = new ClienteDTOResponse();
		
		dto.setDireccionCliente(cliente.getDireccion());
		dto.setNombreCliente(cliente.getNombre());
		dto.setDniCliente(cliente.getDni());
	
		
		return dto;
	}

}
