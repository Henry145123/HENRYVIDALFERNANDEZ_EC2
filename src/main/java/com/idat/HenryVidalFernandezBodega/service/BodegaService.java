package com.idat.HenryVidalFernandezBodega.service;

import java.util.List;

import com.idat.HenryVidalFernandezBodega.dto.BodegaDTORequest;
import com.idat.HenryVidalFernandezBodega.dto.BodegaDTOResponse;

public interface BodegaService {
	
	void guardarBodega(BodegaDTORequest bodega);
	void actualizarBodega(BodegaDTORequest bodega);
	void eliminarBodega(Integer id);
	List<BodegaDTOResponse> listarBodegas();
	BodegaDTOResponse obtenerBodegaId(Integer id);

}
