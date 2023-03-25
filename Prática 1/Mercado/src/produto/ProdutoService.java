package produto;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService() {
        this.produtoRepository = new ProdutoRepository();
    }

    public void criaProduto(String nome, String fabricacao, double preco) {
        Produto produto = new Produto(nome, fabricacao, preco);
        this.produtoRepository.add(produto);
    }

}
