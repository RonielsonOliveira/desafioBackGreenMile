package com.desafio.rota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.rota.models.Rota;
import com.desafio.rota.models.Usuario;


public interface RotaRepository  extends JpaRepository <Rota , Long> {
	Rota findById(long id);
	Rota deleteByVeiculo(String veiculo);
}
