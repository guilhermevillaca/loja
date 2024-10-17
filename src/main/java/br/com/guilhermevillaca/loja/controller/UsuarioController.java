/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.guilhermevillaca.loja.controller;

import br.com.guilhermevillaca.loja.model.Usuario;
import br.com.guilhermevillaca.loja.repository.UsuarioRepository;
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
@RequestMapping(value = "usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> get() {
        return ResponseEntity.ok((List<Usuario>) usuarioRepository.findAll());
    }

}
