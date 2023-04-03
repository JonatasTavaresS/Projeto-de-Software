package com.ufcg.psoft.mercadofacil.utils;

import com.ufcg.psoft.mercadofacil.model.Produto;

public class TestUtils {

    public static Produto criarProduto(Long id, String nome, String fabricante, String codigoDeBarras, double preco) {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setId(id);
        produto.setCodigoBarra(codigoDeBarras);
        produto.setFabricante(fabricante);
        return produto;
    }
}
