package com.syrine.instruments.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Instrument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInstrument;
	
	@NotNull
	@Size(min = 4, max = 15)
	private String nomInstrument;
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixInstrument;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;

	@ManyToOne
	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Instrument [idInstrument=" + idInstrument + ", nomInstrument=" + nomInstrument + ", prixInstrument="
				+ prixInstrument + ", dateCreation=" + dateCreation + "]";
	}

	public Long getIdInstrument() {
		return idInstrument;
	}

	public void setIdInstrument(Long idInstrument) {
		this.idInstrument = idInstrument;
	}

	public String getNomInstrument() {
		return nomInstrument;
	}

	public void setNomInstrument(String nomInstrument) {
		this.nomInstrument = nomInstrument;
	}

	public Double getPrixInstrument() {
		return prixInstrument;
	}

	public void setPrixInstrument(Double prixInstrument) {
		this.prixInstrument = prixInstrument;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Instrument() {
		super();
	}

	public Instrument(String nomInstrument, Double prixInstrument, Date dateCreation) {
		super();
		this.nomInstrument = nomInstrument;
		this.prixInstrument = prixInstrument;
		this.dateCreation = dateCreation;
	}
}
