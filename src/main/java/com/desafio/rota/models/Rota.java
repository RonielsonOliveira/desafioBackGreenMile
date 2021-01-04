package com.desafio.rota.models;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rota implements Serializable {

	public Rota(String veiculo) {
		super();
		this.veiculo = veiculo;
	}

	public Rota(long id, String status, String veiculo, ArrayList<Stop> stops) {
		super();
		this.id = id;
		this.status = status;
		this.veiculo = veiculo;
		this.stops = stops;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String status = "pendente";
	private String veiculo;
	private ArrayList<Stop> stops = new ArrayList<Stop>();

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public Stop buscarStop(long idStop) {
		for (Stop s : stops) {
			if (s.getId() == idStop) {
				return s;
			}

		}
		return null;

	}

	public void checkStop(long idStop) {
		for (Stop s : stops) {
			if (s.getId() == idStop) {
				s.setCheck(true);
			}

		}
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public ArrayList<Stop> getStops() {
		return stops;
	}

	public void setStops(ArrayList<Stop> stops) {
		this.stops = stops;
	}

	public void addStop(Stop stop) {
		stops.add(stop);
	}

	public void deletarStop(Stop stop) {
		for (Stop s : stops) {
			if (buscarStop(s) == true) {
				stops.remove(s);
			}
		}

	}

	public boolean buscarStop(Stop stop) {
		for (int i = 0; i <= stops.size(); i++) {
			if (stops.get(i).equals(stop)) {
				return true;
			}
		}
		return false;
	}

	public boolean verificarStop(Stop stop) {
		for (int i = 0; i < stops.size();) {
			if (stops.get(i).getCheck() == true) {
				i++;
			} else {
				return false;
			}

		}
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
