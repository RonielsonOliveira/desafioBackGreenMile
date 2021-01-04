package com.desafio.rota.models;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
	public Usuario() {
		super();
	}

	public Usuario(long id) {
		super();
		this.id = id;
	}

	public Usuario(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Usuario(long id, String nome, ArrayList<Rota> rotas) {
		super();
		this.id = id;
		this.nome = nome;
		this.rotas = rotas;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private ArrayList<Rota> rotas = new ArrayList<Rota>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(ArrayList<Rota> rotas) {
		this.rotas = rotas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Rota buscarRota(long idrota) {
		for (Rota r : rotas) {
			if (r.getId() == idrota) {
				return r;
			}
		}
		return null;

	}

	public void DeteleRota(int idrota) {
		for (int i = 0; i < rotas.size(); i++) {
			Rota r = rotas.get(i);
			if (r.getId() == idrota) {
				this.rotas.remove(r);
			}
		}
	}
}
