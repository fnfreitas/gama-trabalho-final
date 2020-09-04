package br.gama.trabalhofinal.dao;

//import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;

import br.gama.trabalhofinal.model.Funcionario;
//import br.gama.trabalhofinal.model.Solicitacao;

public interface FuncionarioDAO extends CrudRepository<Funcionario, Integer> {
    public Funcionario findByEmailAndPsw(String email, String senha);

    public Funcionario findByEmailOrRacf(String email, String racf);
/*
    @Query(value = "Select p from Solicitacao p INNER JOIN Funcionario u ON u.id = p.solicitante.id WHERE u.id = :id And p.status = 'P'")
    public List<Solicitacao> buscaPendentesPorId(@Param("id") Integer id);
//*/
}