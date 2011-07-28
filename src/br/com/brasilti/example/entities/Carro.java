package br.com.brasilti.example.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Version
	private Integer version;

	private Boolean active;

	private String modelo;

	private Integer ano;

	private BigDecimal preco;

	@ManyToOne
	private Marca marca;

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Carro carro = (Carro) obj;
		return new EqualsBuilder().append(this.modelo, carro.modelo).append(this.marca, carro.marca).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.modelo).append(this.marca).toHashCode();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Long getId() {
		return id;
	}

	public Integer getVersion() {
		return version;
	}

	public Boolean getActive() {
		return active;
	}

}
