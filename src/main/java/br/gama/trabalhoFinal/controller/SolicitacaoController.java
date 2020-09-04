package br.gama.trabalhofinal.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import br.gama.trabalhofinal.dao.SolicitacaoDAO;
import br.gama.trabalhofinal.model.Solicitacao;

@RestController
@CrossOrigin("*")
public class SolicitacaoController {
    
    @Autowired
    private SolicitacaoDAO dao;

    //listar solicitações por status
    @GetMapping("/solicitacao/status/{status}")
    public List<Solicitacao> buscaPorStatus(@PathVariable char status){
        List<Solicitacao> lista = dao.findByStatus(status);
        return lista;
    }

    //listar todos as Solicitações
    @GetMapping("/solicitacoes")
    public List<Solicitacao> listarTodos(){
        List<Solicitacao> lista = (List<Solicitacao>) dao.findAll();
        return lista;
    }

 
    @PostMapping("/solicitacao/nova")
    public ResponseEntity<Solicitacao> novaSolicitacao(@RequestBody Solicitacao solicit) {
        try {
            Solicitacao novo = dao.save(solicit); // salva o usuário no BD
            return ResponseEntity.ok(novo); // retorna os dados do usuário inserido no BD
        } catch (Exception ex) {
            return ResponseEntity.status(400).build(); // 400 = bad request (dados incorretos)
        }
    }

    
    //atualizar o status da solicitação
    @PutMapping("/solicitacao/status")
    public ResponseEntity<Boolean> alterarStatus(@RequestBody Solicitacao solicitacaoId){
        Solicitacao solicitacao = dao.findById(solicitacaoId.getNumSeq()).orElse(null);

        System.out.println(solicitacaoId.getNumSeq());

        if(solicitacao != null){
            solicitacao.setStatus(solicitacaoId.getStatus());
            dao.save(solicitacao);
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.ok(false);
        }

    }

    //buscar um pedido por número do pedido
    @GetMapping("/solicitacao/{id}")
    public ResponseEntity<Solicitacao> buscaPorId(@PathVariable int id){
        Solicitacao solicitacao = dao.findById(id).orElse(null);

        if(solicitacao != null){
            return ResponseEntity.ok(solicitacao);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}