package br.com.guilhermevillaca.loja.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author villaca
 */
@Entity
@Table(name = "Produto")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Produto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private double valor;

    @Column(name = "quantidade_estoque")
    private Integer quantidade_estoque;

    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @ManyToOne
    private Categoria categoria;

    public Produto(String nome, String descricao, double valor, Integer quantidade_estoque, Categoria categoria){
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade_estoque = quantidade_estoque;
        this.categoria = categoria;
    }

}
