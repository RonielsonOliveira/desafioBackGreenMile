package com.desafio.rota.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stop implements Serializable {

	public Stop() {
		super();
	}

	public Stop(float lat, float lng, String descricao, int raioDeEntrega) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.descricao = descricao;
		this.raioDeEntrega = raioDeEntrega;
	}

	public Stop(long id, float lat, float lng, String descricao, int raioDeEntrega) {
		super();
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.descricao = descricao;
		this.raioDeEntrega = raioDeEntrega;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private float lat;
	private float lng;
	private String descricao;
	private int raioDeEntrega;
	private boolean check = false;

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getRadioDeEntrega() {
		return raioDeEntrega;
	}

	public void setRadioDeEntrega(int radioDeEntrega) {
		this.raioDeEntrega = radioDeEntrega;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRaioDeEntrega() {
		return raioDeEntrega;
	}

	public void setRaioDeEntrega(int raioDeEntrega) {
		this.raioDeEntrega = raioDeEntrega;
	}

	public boolean isCheck() {
		return check;
	}

	public boolean getCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
}
