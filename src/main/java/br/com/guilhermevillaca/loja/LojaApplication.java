package br.com.guilhermevillaca.loja;

import br.com.guilhermevillaca.loja.model.Categoria;
import br.com.guilhermevillaca.loja.repository.CategoriaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LojaApplication {

    @Autowired
    CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(LojaApplication.class, args);
    }

    @GetMapping("hello")
    public ResponseEntity<List<Categoria>> Hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        //return String.format("Hello " + name);

        List<Categoria> categorias = new ArrayList<>();
        categorias = (List<Categoria>) categoriaRepository.findAll();
        return ResponseEntity.ok(categorias);
    }

}
