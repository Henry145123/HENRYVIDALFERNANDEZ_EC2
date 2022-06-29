package com.idat.HenryVidalFernandezBodega.service;

import java.util.List;

import com.idat.HenryVidalFernandezBodega.dto.ProductoDTORequest;
import com.idat.HenryVidalFernandezBodega.dto.ProductoDTOResponse;

public interface ProductoService {
	
	void guardarProducto(ProductoDTORequest producto);
	void actualizarProducto(ProductoDTORequest producto);
	void eliminarProducto(Integer id);
	List<ProductoDTOResponse> listarProductos();
	ProductoDTOResponse obtenerProductoId(Integer id);

}
