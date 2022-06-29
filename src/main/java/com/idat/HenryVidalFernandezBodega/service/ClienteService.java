package com.idat.HenryVidalFernandezBodega.service;

import java.util.List;

import com.idat.HenryVidalFernandezBodega.dto.ClienteDTORequest;
import com.idat.HenryVidalFernandezBodega.dto.ClienteDTOResponse;

public interface ClienteService {
	
	void guardarCliente(ClienteDTORequest cliente);
	void actualizarCliente(ClienteDTORequest cliente);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarClientes();
	ClienteDTOResponse obtenerClienteId(Integer id);

}
