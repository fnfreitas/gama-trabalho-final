package br.gama.trabalhofinal.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    /*

    //buscar um pedido por número do pedido
    @GetMapping("/pedido/{id}")
    public ResponseEntity<Pedido> buscaPorId(@PathVariable int id){
        Pedido pedido = dao.findById(id).orElse(null);

        if(pedido != null){
            return ResponseEntity.ok(pedido);
        }else{
            return ResponseEntity.notFound().build();
        }
    }



    //listar todos os pedidos por status
    @GetMapping("/pedidos/status/{status}")
    public List<Pedido> buscaPorStatus(@PathVariable char status){
        List<Pedido> lista = dao.findByStatus(status);
        return lista;
    }

    //atualizar o status do pedido
    @PutMapping("/pedidos/status")
    public ResponseEntity<Boolean> alterarStatus(@RequestBody Pedido pedidoUser){
        Pedido pedido = dao.findById(pedidoUser.getNumPedido()).orElse(null);

        if(pedido != null){
            pedido.setStatus(pedidoUser.getStatus());
            dao.save(pedido);
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.ok(false);
        }

    }

        //listar todos os pedidos por data
        @GetMapping("/pedidos/data")
        public List<Pedido> buscaPorData(@RequestParam(name="dataagendamento") String dataAgendamento){
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate data = LocalDate.parse(dataAgendamento, fmt);
            return dao.findAllByData(data);
        }
        */
}