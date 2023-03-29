package com.ufcg.psoft.mercadofacil.service;

@FunctionalInterface
public interface ProdutoValidarCodigoDeBarrasService {

    boolean validar(String codigo);
}
