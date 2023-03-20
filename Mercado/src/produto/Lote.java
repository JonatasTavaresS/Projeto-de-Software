package produto;

import java.util.Date;

/**
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class Lote {

    private Produto produto;
    private int quantidade;
    private Date validade;

    public Lote(Produto produto, int quantidade, Date validade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.validade = validade;
    }

}
