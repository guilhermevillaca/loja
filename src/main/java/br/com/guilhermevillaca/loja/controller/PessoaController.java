package br.com.guilhermevillaca.loja.controller;

import br.com.guilhermevillaca.loja.model.Pessoa;
import br.com.guilhermevillaca.loja.repository.PessoaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author villaca
 */
@RestController
@RequestMapping(value = "pessoa")
public class PessoaController {
    
    @Autowired
    PessoaRepository pessoaRepository;
    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public ResponseEntity<List<Pessoa>> get() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas = (List<Pessoa>) pessoaRepository.findAll();
        return ResponseEntity.ok(pessoas);
    }

}
