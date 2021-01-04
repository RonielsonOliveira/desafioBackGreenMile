package com.desafio.rota.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.desafio.rota.models.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario , Long>  {
	Usuario findById(long id);

}
