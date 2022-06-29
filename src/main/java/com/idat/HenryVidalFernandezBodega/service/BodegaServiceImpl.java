package com.idat.HenryVidalFernandezBodega.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.HenryVidalFernandezBodega.dto.BodegaDTORequest;
import com.idat.HenryVidalFernandezBodega.dto.BodegaDTOResponse;
import com.idat.HenryVidalFernandezBodega.model.Bodega;
import com.idat.HenryVidalFernandezBodega.repository.BodegaRepository;

@Service
public class BodegaServiceImpl  implements BodegaService{

	@Autowired
	private BodegaRepository repository;
	
	@Override
	public void guardarBodega(BodegaDTORequest bodega) {
		
		Bodega b = new Bodega();
		
		b.setNombre(bodega.getNombreBodega());
		b.setDireccion(bodega.getDireccionBodega());
		b.setProducto(bodega.getProducto());
		repository.save(b);
		
	}

	@Override
	public void actualizarBodega(BodegaDTORequest bodega) {
		
		Bodega b = new Bodega();
		b.setIdBodega(bodega.getId());
		b.setNombre(bodega.getNombreBodega());
		b.setDireccion(bodega.getDireccionBodega());
		b.setProducto(bodega.getProducto());
		repository.saveAndFlush(b);
		
	}

	@Override
	public void eliminarBodega(Integer id) {
		
		repository.deleteById(id);
	}

	@Override
	public List<BodegaDTOResponse> listarBodegas() {
		
		
		List<BodegaDTOResponse> listar = new ArrayList<>();
		
		BodegaDTOResponse dto = null;
		
		List<Bodega> b = repository.findAll();
		
		for (Bodega bodega : b) {
			
			dto = new BodegaDTOResponse();
			
			dto.setId(bodega.getIdBodega());
			dto.setNombreBodega(bodega.getNombre());
			dto.setDireccionBodega(bodega.getDireccion());
			dto.setProducto(bodega.getProducto());
		
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public BodegaDTOResponse obtenerBodegaId(Integer id) {

		Bodega bodega = repository.findById(id).orElse(null);
		BodegaDTOResponse dto = new BodegaDTOResponse();
		
		dto.setId(bodega.getIdBodega());
		dto.setNombreBodega(bodega.getNombre());
		dto.setDireccionBodega(bodega.getDireccion());
		dto.setProducto(bodega.getProducto());
	
	
		
		return dto;
	}

}
