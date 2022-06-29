package com.idat.HenryVidalFernandezBodega.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.HenryVidalFernandezBodega.dto.ProductoDTORequest;
import com.idat.HenryVidalFernandezBodega.dto.ProductoDTOResponse;
import com.idat.HenryVidalFernandezBodega.model.Producto;
import com.idat.HenryVidalFernandezBodega.repository.ProductoRepository;

@Service
public class ProductoServiceImpl  implements ProductoService{

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public void guardarProducto(ProductoDTORequest producto) {
		
		Producto p = new Producto();
		p.setProducto(producto.getNombreProducto());
		p.setDescripcion(producto.getDescripcionProducto());
		p.setPrecio(producto.getPrecioProducto());
		p.setStock(producto.getStockProducto());
		repository.save(p);
		
	}

	@Override
	public void actualizarProducto(ProductoDTORequest producto) {
		Producto p = new Producto();
		
		p.setIdProducto(producto.getId());
		p.setProducto(producto.getNombreProducto());
		p.setDescripcion(producto.getDescripcionProducto());
		p.setPrecio(producto.getPrecioProducto());
		p.setStock(producto.getStockProducto());
		
		repository.saveAndFlush(p);
		
	}

	@Override
	public void eliminarProducto(Integer id) {
		
		repository.deleteById(id);
	}

	@Override
	public List<ProductoDTOResponse> listarProductos() {
		
		
		List<ProductoDTOResponse> listar = new ArrayList<>();
		
		ProductoDTOResponse dto = null;
		
		List<Producto> p = repository.findAll();
		
		for (Producto productos : p) {
			
			dto = new ProductoDTOResponse();
			
			dto.setDescripcionProducto(productos.getDescripcion());
			dto.setNombreProducto(productos.getProducto());
			dto.setPrecioProducto(productos.getPrecio());
			dto.setStockProducto(productos.getStock());
			dto.setId(productos.getIdProducto());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public ProductoDTOResponse obtenerProductoId(Integer id) {

		Producto productos = repository.findById(id).orElse(null);
		ProductoDTOResponse dto = new ProductoDTOResponse();
		
		dto.setDescripcionProducto(productos.getDescripcion());
		dto.setNombreProducto(productos.getProducto());
		dto.setPrecioProducto(productos.getPrecio());
		dto.setStockProducto(productos.getStock());
		dto.setId(productos.getIdProducto());
		
		return dto;
	}

}
