package br.com.guilhermevillaca.loja.controller;

import br.com.guilhermevillaca.loja.model.Pessoa;
import br.com.guilhermevillaca.loja.model.Pessoa;
import br.com.guilhermevillaca.loja.repository.PessoaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
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

    @RequestMapping(value = "listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> getById(@PathVariable(value = "id") Integer id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //post
    @RequestMapping(value = "novo", method = RequestMethod.POST)
    public Pessoa novo(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    //put
    @RequestMapping(value = "atualizar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pessoa> atualizar(@PathVariable(value = "id") Integer id, @RequestBody Pessoa newPessoa) {
        Optional<Pessoa> oldPessoa = pessoaRepository.findById(id);
        if (oldPessoa.isPresent()) {
            Pessoa pessoa = oldPessoa.get();
            pessoa.setNome(newPessoa.getNome());
            pessoaRepository.save(pessoa);
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete
    @RequestMapping(value = "remover/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Pessoa> delete(@PathVariable(value = "id") Integer id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
