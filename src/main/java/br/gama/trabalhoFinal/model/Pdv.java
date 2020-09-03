package br.gama.trabalhoFinal.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name ="pdv")
public class Pdv {

    @Id //chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-numeração
    @Column(name="id")
    private int id;

    @Column(name="numero_ponto", nullable = false)
    private int numeroPonto;

    @Column(name="nome", length = 100, nullable = false)
    private String nome;

    @Column(name="endereco", length = 100, nullable = false)
    private String email;

    @Column(name="telefone", length = 20, nullable = false)
    private String telefone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pdvId")
    @JsonIgnoreProperties("pdvId")
    private List<Solicitacao> solicitacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroPonto() {
        return numeroPonto;
    }

    public void setNumeroPonto(int numeroPonto) {
        this.numeroPonto = numeroPonto;
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

    public String getCpf() {
        return telefone;
    }

    public void setCpf(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Solicitacao> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

   

}