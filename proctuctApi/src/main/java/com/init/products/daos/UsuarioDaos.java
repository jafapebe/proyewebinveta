package com.init.products.daos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.init.products.entitys.Usuarios;

public interface UsuarioDaos extends JpaRepository<Usuarios, Long> {

}
