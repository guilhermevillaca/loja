
package br.com.guilhermevillaca.loja.repository;

import br.com.guilhermevillaca.loja.model.Produto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author villaca
 */
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
    
}
