package br.com.guilhermevillaca.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.guilhermevillaca.loja.model.Categoria;
import br.com.guilhermevillaca.loja.model.Pessoa;
import br.com.guilhermevillaca.loja.model.Produto;
import br.com.guilhermevillaca.loja.model.Usuario;
import br.com.guilhermevillaca.loja.repository.CategoriaRepository;
import br.com.guilhermevillaca.loja.repository.PessoaRepository;
import br.com.guilhermevillaca.loja.repository.ProdutoRepository;
import br.com.guilhermevillaca.loja.repository.UsuarioRepository;

import java.util.Arrays;

@Component
public class DBInsert implements CommandLineRunner{

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria("Eletrônicos", "Produtos eletrônicos em geral", null);
        categoriaRepository.save(cat1);
        Categoria cat2 = new Categoria("Roupas", "Roupas para todas as estações", null);
        categoriaRepository.save(cat2);        
        // Categorias Filhas
        Categoria cat3 = new Categoria("Celulares", "Smartphones e acessórios", cat1);
        categoriaRepository.save(cat3);
        Categoria cat4 = new Categoria("TVs", "Televisões de alta definição", cat1);
        categoriaRepository.save(cat4);
        Categoria cat5 = new Categoria("Camisetas", "Camisetas casuais", cat2);
        categoriaRepository.save(cat5);
        Categoria cat6 = new Categoria("Calças", "Calças jeans e de tecido", cat2);
        categoriaRepository.save(cat6);
        Categoria cat7 = new Categoria("Capas de celular", "Capas protetoras para smartphones", cat3);
        categoriaRepository.save(cat7);
        Categoria cat8 = new Categoria("Fones de ouvido", "Fones de ouvido com fio e sem fio", cat3);
        categoriaRepository.save(cat8);
        Categoria cat9 = new Categoria("Smart TVs", "Televisões inteligentes", cat4);
        categoriaRepository.save(cat9);
        Categoria cat10 = new Categoria("Roupas íntimas", "Roupas íntimas para todas as idades", cat5);        
        categoriaRepository.save(cat10);

         // Produtos
        Produto prod1 = new Produto("iPhone 12", "Smartphone da Apple", 4000, 50, cat3);
        produtoRepository.save(prod1);
        Produto prod2 = new Produto("Samsung Galaxy S21", "Smartphone da Samsung", 3500, 60, cat3);
        produtoRepository.save(prod2);
        Produto prod3 = new Produto("Xiaomi Redmi Note 10", "Smartphone da Xiaomi", 2000, 30, cat3);
        produtoRepository.save(prod3);
        Produto prod4 = new Produto("LG K42", "Smartphone da LG", 1500, 40, cat3);
        produtoRepository.save(prod4);
        Produto prod5 = new Produto("Sony Bravia XBR-65X855D", "TV 4K da Sony", 6000, 20, cat4);
        produtoRepository.save(prod5);
        Produto prod6 = new Produto("Samsung QLED Q80T", "TV QLED da Samsung", 5500, 15, cat4);
        produtoRepository.save(prod6);
        Produto prod7 = new Produto("Philips 32PHG5813", "TV Full HD da Philips", 1800, 25, cat4);
        produtoRepository.save(prod7);
        Produto prod8 = new Produto("Camiseta básica branca", "Camiseta básica de algodão", 30, 100, cat5);
        produtoRepository.save(prod8);
        Produto prod9 = new Produto("Camiseta estampada", "Camiseta estampada com desenhos", 35, 80, cat5);
        produtoRepository.save(prod9);
        Produto prod10 = new Produto("Calça jeans masculina", "Calça jeans para homens", 80, 70, cat6);
        produtoRepository.save(prod10);
        Produto prod11 = new Produto("Calça legging feminina", "Calça legging confortável", 50, 90, cat6);
        produtoRepository.save(prod11);
        Produto prod12 = new Produto("Capa de silicone para iPhone", "Capa protetora de silicone", 20, 200, cat7);
        produtoRepository.save(prod12);
        Produto prod13 = new Produto("Capa rígida para Samsung Galaxy", "Capa protetora rígida", 15, 150, cat7);
        produtoRepository.save(prod13);
        Produto prod14 = new Produto("Fone de ouvido Bluetooth", "Fone de ouvido sem fio", 100, 120, cat8);
        produtoRepository.save(prod14);
        Produto prod15 = new Produto("Fone de ouvido com fio", "Fone de ouvido convencional", 50, 180, cat8);
        produtoRepository.save(prod15);
        Produto prod16 = new Produto("Smart TV LG 55UN7310PSC", "TV 4K da LG", 3500, 10, cat9);
        produtoRepository.save(prod16);
        Produto prod17 = new Produto("Smart TV Philips 43PUG6513", "TV 4K da Philips", 2500, 15, cat9);
        produtoRepository.save(prod17);
        Produto prod18 = new Produto("Conjunto de lingerie preta", "Conjunto de lingerie feminina", 40, 60, cat10);
        produtoRepository.save(prod18);
        Produto prod19 = new Produto("Cueca boxer masculina", "Cueca boxer confortável", 25, 100, cat10);
        produtoRepository.save(prod19);
        Produto prod20 = new Produto("Cueca infantil masculina", "Cueca infantil", 20, 150, cat10);
        produtoRepository.save(prod20);


        Pessoa p1 = new Pessoa("João Silva");
        pessoaRepository.save(p1);
        Pessoa p2 = new Pessoa("Maria Oliveira");
        pessoaRepository.save(p2);
        Pessoa p3 = new Pessoa("Carlos Souza");
        pessoaRepository.save(p3);
        Pessoa p4 = new Pessoa("Ana Costa");
        pessoaRepository.save(p4);
        Pessoa p5 = new Pessoa("Pedro Fernandes");
        pessoaRepository.save(p5);
        Pessoa p6 = new Pessoa("Lucia Mendes");
        pessoaRepository.save(p6);
        Pessoa p7 = new Pessoa("Marcos Lima");
        pessoaRepository.save(p7);
        Pessoa p8 = new Pessoa("Fernanda Ribeiro");
        pessoaRepository.save(p8);
        Pessoa p9 = new Pessoa("José Almeida");
        pessoaRepository.save(p9);
        Pessoa p10 = new Pessoa("Paula Moreira");
        pessoaRepository.save(p10);

         // Criando os objetos Usuario e associando-os às respectivas pessoas
        Usuario u1 = new Usuario("joaosilva", "senha123", p1);
        usuarioRepository.save(u1);
        Usuario u2 = new Usuario("mariaoliveira", "senha123", p2);
        usuarioRepository.save(u2);
        Usuario u3 = new Usuario("carlossouza", "senha123", p3);
        usuarioRepository.save(u3);
        Usuario u4 = new Usuario("anacosta", "senha123", p4);
        usuarioRepository.save(u4);
        Usuario u5 = new Usuario("pedrofernandes", "senha123", p5);
        usuarioRepository.save(u5);
        Usuario u6 = new Usuario("luciamendes", "senha123", p6);
        usuarioRepository.save(u6);
        Usuario u7 = new Usuario("marcoslima", "senha123", p7);
        usuarioRepository.save(u7);
        Usuario u8 = new Usuario("fernandaribeiro", "senha123", p8);
        usuarioRepository.save(u8);
        Usuario u9 = new Usuario("josealmeida", "senha123", p9);
        usuarioRepository.save(u9);
        Usuario u10 = new Usuario("paulamoreira", "senha123", p10);
        usuarioRepository.save(u10);

        System.out.println("----------All Data saved into Database----------------------");        
    }


}
