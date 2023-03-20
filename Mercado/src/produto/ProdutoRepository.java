package produto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class ProdutoRepository {

    private Map<Integer, Produto> produtos;

    public ProdutoRepository() {
        this.produtos = new HashMap<>();
    }

    public void add(Produto produto) {
        this.produtos.put(produto.getId(), produto);
    }

    public Produto get(int id) {
        return this.produtos.get(id);
    }

}
