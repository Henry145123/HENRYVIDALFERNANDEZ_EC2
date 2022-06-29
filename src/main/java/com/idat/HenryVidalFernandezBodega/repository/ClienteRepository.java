package com.idat.HenryVidalFernandezBodega.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.HenryVidalFernandezBodega.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

}
