package br.gama.trabalhofinal.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dadosolic")
public class Solicitacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numseqsolic")
    private int numSeq;


    @Column(name="nometecnicosolic", length = 100, nullable = false)
    private String nomeTecnico;

    @Column(name="operadorasolic", length = 50, nullable = false)
    private String operadora;

    @Column(name="telefonesolic", length = 20, nullable = false)
    private String telefone;

    @Column(name="docsolic", length = 20, nullable = false)
    private String doc;
     
    @Column(name="data")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data;

    @Column(name="hora")
    private LocalTime hora;

    @Column(name="status", length = 20)
    private String status;

    @ManyToOne
    @JsonIgnoreProperties("solicitacoes")
    private Pdv pdvidsolic;

    public int getNumSeq() {
        return numSeq;
    }

    public void setNumSeq(int numSeq) {
        this.numSeq = numSeq;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pdv getPdvidsolic() {
		return pdvidsolic;
	}

	public void setPdvidsolic(Pdv pdvidsolic) {
		this.pdvidsolic = pdvidsolic;
	}

}