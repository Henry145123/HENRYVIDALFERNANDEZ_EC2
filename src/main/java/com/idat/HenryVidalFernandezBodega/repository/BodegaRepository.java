package com.idat.HenryVidalFernandezBodega.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.HenryVidalFernandezBodega.model.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega,Integer>{

}
