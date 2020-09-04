package br.gama.trabalhofinal.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id // chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-numeração
    @Column(name = "idfunc")
    private int id;

    @Column(name = "nomefunc", length = 100, nullable = false)
    private String nome;

    @Column(name = "emailfunc", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "racffunc", length = 20, nullable = false, unique = true)
    private String racf;

    @Column(name = "funcionalfunc", nullable = false, unique = true)
    private int funcionalFunc;

    @Column(name = "pswfunc", length = 20, nullable = false)
    private String psw;

    @Column(name = "cargofunc",length = 20)
    private String cargo;

    @Column(name = "linkfoto", length = 200)
    private String linkFoto;

 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
    }
    
}