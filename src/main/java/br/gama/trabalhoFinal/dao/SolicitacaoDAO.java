package br.gama.trabalhofinal.dao;

//import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gama.trabalhofinal.model.Solicitacao;

public interface SolicitacaoDAO extends CrudRepository <Solicitacao, Integer> {
    public List<Solicitacao> findByStatus(String status);
    //public List<Solicitacao> findAllByData(LocalDate data);
}