package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String texto;
	private Integer cargaHoraria;
	private Integer totalAulas;
	private Date ano;
	
	public Course() {
		
	}
	
	public Course(String nome, String texto, Integer cargaHoraria, Integer totalAulas) {
		this.nome = nome;
		this.texto = texto;
		this.cargaHoraria = cargaHoraria;
		this.totalAulas = totalAulas;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public Integer getCargaHoraria() {
		return cargaHoraria;
	}


	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}


	public Integer getTotalAulas() {
		return totalAulas;
	}


	public void setTotalAulas(Integer totalAulas) {
		this.totalAulas = totalAulas;
	}


	public Date getAno() {
		return ano;
	}


	public void setAno(Date ano) {
		this.ano = ano;
	}
	
	
	
	
}
