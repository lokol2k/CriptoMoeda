package br.com.cryptoProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import br.com.cryptoProject.commons.Price;

@Entity
public class CriptoMoeda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Transient
	private CriptoMoedaCoingecko coingecko;
	
	@Transient
	private Price price;
	
//	@Transient
//	private String priceString;
	
	@NotBlank(message="Campo nome obrigatorio")
	@Column(nullable = false)
	private String nome;
	
	@NotBlank(message="Campo codigo obrigatorio")
	@Column(nullable = false, unique=true)
	private String codigo;
	
	@NotBlank(message="Campo url_projeto obrigatorio")
	@Column(nullable = false)
	private String url_projeto;
	
	public String getCodigo() {
		return codigo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl_projeto() {
		return url_projeto;
	}

	public void setUrl_projeto(String url_projeto) {
		this.url_projeto = url_projeto;
	}

	public CriptoMoedaCoingecko getCoingecko() {
		return coingecko;
	}

	public void setCoingecko(CriptoMoedaCoingecko coingecko) {
		this.coingecko = coingecko;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

//	public String getPriceString() {
//		return priceString;
//	}
//
//	public void setPriceString(String priceString) {
//		this.priceString = priceString;
//	}
//	

	
}
