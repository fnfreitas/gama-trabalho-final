package br.gama.trabalhoFinal.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import br.gama.trabalhoFinal.model.Solicitacao;

public interface SolicitacaoDAO extends CrudRepository <Solicitacao, Integer> {
    public List<Solicitacao> findByStatus(char status);
    public List<Solicitacao> findAllByData(LocalDate data);
}