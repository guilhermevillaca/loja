package br.com.guilhermevillaca.loja.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author villaca
 */
@Entity
@Table(name = "Categoria")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @JoinColumn(name = "categoria_pai_id", referencedColumnName = "id")
    @ManyToOne
    private Categoria categoria;

    public Categoria(String nome, String descricao, Categoria categoria){
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
    }

}
