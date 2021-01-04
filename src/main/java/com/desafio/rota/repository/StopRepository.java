package com.desafio.rota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.rota.models.Rota;
import com.desafio.rota.models.Stop;
import com.desafio.rota.models.Usuario;

public interface StopRepository extends JpaRepository <Stop , Long> {
	Stop findById(long id);
}
