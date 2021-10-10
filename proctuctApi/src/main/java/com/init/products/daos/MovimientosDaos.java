package com.init.products.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.products.entitys.Movimientos;

public interface MovimientosDaos extends JpaRepository<Movimientos, Long> {
	

}
