package produto;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class Facade {

    private ProdutoService produtoService;

    public Facade() {
        this.produtoService = new ProdutoService();
    }

    public void criaProduto(String nome, String fabricacao, double preco) {
        this.produtoService.criaProduto(nome, fabricacao, preco);
    }

}
