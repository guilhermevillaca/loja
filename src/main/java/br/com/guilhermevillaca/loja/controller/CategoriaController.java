package br.com.guilhermevillaca.loja.controller;

import br.com.guilhermevillaca.loja.model.Categoria;
import br.com.guilhermevillaca.loja.repository.CategoriaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author villaca
 */
@RestController
@RequestMapping(value = "categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    
    //get
    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> get() {
        List<Categoria> categorias = new ArrayList<>();
        categorias = (List<Categoria>) categoriaRepository.findAll();
        return ResponseEntity.ok(categorias);
    }

    
    //get por id
    @RequestMapping(value = "listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> getById(@PathVariable(value = "id") Integer id) {
        
        Optional<Categoria> categoria = categoriaRepository.findById(id);
         if (categoria.isPresent()) {
            return new ResponseEntity<Categoria>(categoria.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    
    //post
    @RequestMapping(value="novo", method = RequestMethod.POST)
    public Categoria novo(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    
    //put
    
     @RequestMapping(value = "atualizar/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Categoria> atualizar(@PathVariable(value = "id") Integer id,  @RequestBody Categoria newCategoria)
    {
        Optional<Categoria> oldCategoria = categoriaRepository.findById(id);
        if(oldCategoria.isPresent()){
            Categoria categoria = oldCategoria.get();  
            categoria.setNome(newCategoria.getNome());
            categoria.setDescricao(newCategoria.getDescricao());
            categoria.setCategoria(newCategoria.getCategoria());
            categoriaRepository.save(categoria);
            return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //delete
    @RequestMapping(value = "remover/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Categoria> delete(@PathVariable(value = "id") Integer id)
    {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()){
            categoriaRepository.delete(categoria.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    

}
