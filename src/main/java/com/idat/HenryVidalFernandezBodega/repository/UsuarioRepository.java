package com.idat.HenryVidalFernandezBodega.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.HenryVidalFernandezBodega.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

}
