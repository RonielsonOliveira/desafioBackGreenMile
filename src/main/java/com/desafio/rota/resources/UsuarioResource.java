package com.desafio.rota.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.rota.models.Rota;
import com.desafio.rota.models.Stop;
import com.desafio.rota.models.Usuario;
import com.desafio.rota.repository.RotaRepository;
import com.desafio.rota.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/api")
public class UsuarioResource {
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	RotaRepository rotaRepository;

	@GetMapping("/usuarios")
	public List<Usuario> listaUsuario() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/usuario/{id}")
	public Usuario listarUsuarioUnico(@PathVariable(value = "id") long id) {
		return usuarioRepository.findById(id);

	}

	@PostMapping("/usuario")
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping("/usuario/{id}")
	public void deletarUsuario(@RequestBody Usuario usuario, @PathVariable(value = "id") long id) {
		usuarioRepository.deleteById(id);
	}

	@PostMapping("/usuario/{id}/{idRota}")
	public Usuario deletarRota(@RequestBody Rota rota, @PathVariable(value = "id") long id,
			@PathVariable(value = "idRota") long idRota) {
		Rota r = usuarioRepository.findById(id).buscarRota(idRota);
		Usuario u = usuarioRepository.findById(id);
		u.getRotas().remove(r);
		return usuarioRepository.save(u);

	}

	@PostMapping("/usuario/{id}/{idRota}/{idStop}")
	public Usuario deletarStop(@RequestBody Rota rota, @PathVariable(value = "id") long id,
			@PathVariable(value = "idRota") long idRota, @PathVariable(value = "idStop") long idStop) {
		Usuario u = usuarioRepository.findById(id);
		Rota r = u.buscarRota(idRota);
		Stop s = r.buscarStop(idStop);
		r.getStops().remove(s);
		if (r.getStops().size() == 0) {
			u.getRotas().remove(r);
		}
		return usuarioRepository.save(u);

	}

	@PostMapping("/usuario/{id}/{idRota}/check/{idStop}")
	public Usuario checkStop(@RequestBody Rota rota, @PathVariable(value = "id") long id,
			@PathVariable(value = "idRota") long idRota, @PathVariable(value = "idStop") long idStop) {
		Usuario u = usuarioRepository.findById(id);
		Rota r = u.buscarRota(idRota);
		Stop s = r.buscarStop(idStop);
		s.setCheck(true);

		if (r.verificarStop(s) != false) {
			r.setStatus("Confirmada");
		}
		return usuarioRepository.save(u);
	}

	@PutMapping("/usuario")
	public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
