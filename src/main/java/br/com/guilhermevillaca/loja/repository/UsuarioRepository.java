/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.guilhermevillaca.loja.repository;

import br.com.guilhermevillaca.loja.model.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author villaca
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
}