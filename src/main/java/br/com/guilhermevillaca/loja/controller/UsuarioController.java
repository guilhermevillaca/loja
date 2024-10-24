/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.guilhermevillaca.loja.controller;

import br.com.guilhermevillaca.loja.model.Produto;
import br.com.guilhermevillaca.loja.model.Usuario;
import br.com.guilhermevillaca.loja.repository.UsuarioRepository;
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
@RequestMapping(value = "usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> get() {
        return ResponseEntity.ok((List<Usuario>) usuarioRepository.findAll());
    }

    @RequestMapping(value = "listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> getById(@PathVariable(value = "id") Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //post
    @RequestMapping(value = "novo", method = RequestMethod.POST)
    public Usuario novo(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //put
    @RequestMapping(value = "atualizar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> atualizar(@PathVariable(value = "id") Integer id, @RequestBody Usuario newUsuario) {
        Optional<Usuario> oldUsuario = usuarioRepository.findById(id);
        if (oldUsuario.isPresent()) {
            Usuario usuario = oldUsuario.get();
            usuario.setLogin(newUsuario.getLogin());
            usuario.setPessoa(newUsuario.getPessoa());
            usuario.setSenha(newUsuario.getSenha());
            usuarioRepository.save(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete
    @RequestMapping(value = "remover/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> delete(@PathVariable(value = "id") Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
