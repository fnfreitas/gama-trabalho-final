package br.gama.trabalhofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.gama.trabalhofinal.dao.FuncionarioDAO;
import br.gama.trabalhofinal.model.Funcionario;


@RestController
@CrossOrigin("*")
public class FuncionarioController {

    @Autowired
    private FuncionarioDAO dao;

    @PostMapping("/funcionario/login")
    public ResponseEntity<Funcionario> fazerLogin(@RequestBody Funcionario user) {

        Funcionario userFinded = dao.findByEmailOrRacf(user.getEmail(), user.getRacf());

        if (userFinded != null) {
            if (userFinded.getPsw().equals(user.getPsw())) {
                userFinded.setPsw("*********");
                //userFinded.setSolicitacao(null);
                return ResponseEntity.ok(userFinded);
            } else {
                return ResponseEntity.status(403).build();
            }
        } else {

            return ResponseEntity.status(404).build();
        }
    }

    //listar todos os funcionarios
    @GetMapping("/funcionarios")
    public List<Funcionario> listarTodos(){
        List<Funcionario> lista = (List<Funcionario>) dao.findAll();
        return lista;
    }
}