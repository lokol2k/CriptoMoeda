package br.com.cryptoProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Campo nome obrigatorio")
	@Size(min=2,max=50,message="Nome deve conter {min} ate {max} caracteres")
	@Column(nullable = false, unique=true)
	private String nome;
	
	@NotBlank(message="Campo email obrigatorio")
	@Email(message = "email invalido")
	@Column(nullable = false, unique=true)
	private String email;
	
	@Column(nullable = false)
	@NotBlank(message="Campo Senha obrigatorio")
	private String password;
	
	@Transient
	@Column(nullable = false)
	//@NotBlank(message="Campo Confirmar Senha obrigatorio")
	private String confirmPassword;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}


