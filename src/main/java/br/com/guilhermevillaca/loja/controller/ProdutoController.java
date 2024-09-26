package br.com.guilhermevillaca.loja.controller;

import br.com.guilhermevillaca.loja.model.Produto;
import br.com.guilhermevillaca.loja.repository.ProdutoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> get() {
        List<Produto> produtos = new ArrayList<>();
        produtos = (List<Produto>) produtoRepository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @RequestMapping(value = "listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> getById(@PathVariable(value = "id") Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return new ResponseEntity<Produto>(produto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //post
    @RequestMapping(value = "novo", method = RequestMethod.POST)
    public Produto novo(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    //put
    @RequestMapping(value = "atualizar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Produto> atualizar(@PathVariable(value = "id") Integer id, @RequestBody Produto newProduto) {
        Optional<Produto> oldProduto = produtoRepository.findById(id);
        if (oldProduto.isPresent()) {
            Produto produto = oldProduto.get();
            produto.setNome(newProduto.getNome());
            produto.setDescricao(newProduto.getDescricao());
            produto.setCategoria(newProduto.getCategoria());
            produto.setValor(newProduto.getValor());
            produto.setQuantidade_estoque(newProduto.getQuantidade_estoque());
            produtoRepository.save(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete
    @RequestMapping(value = "remover/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Produto> delete(@PathVariable(value = "id") Integer id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            produtoRepository.delete(produto.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
