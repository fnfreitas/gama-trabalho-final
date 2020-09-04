package br.gama.trabalhofinal.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.trabalhofinal.dao.PdvDAO;
import br.gama.trabalhofinal.model.Pdv;

@RestController
@CrossOrigin("*")
public class PdvController {
    
    @Autowired
    private PdvDAO dao;

    //Recuperar lista de PDVs
    @GetMapping("/pdvs")
    public List<Pdv> listarTodos(){
        List<Pdv> lista = (List<Pdv>) dao.findAll();
        return lista;
    }
    
}