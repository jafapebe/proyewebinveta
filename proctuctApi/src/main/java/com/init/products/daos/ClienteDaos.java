package com.init.products.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.products.entitys.Clientes;

public interface ClienteDaos extends JpaRepository<Clientes,Long>{

}