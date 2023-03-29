package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoValidarCodigoDeBarrasServiceTest {

    @Autowired
    ProdutoValidarCodigoDeBarrasService driver;
    @MockBean
    ProdutoRepository<Produto, Long> produtoRepository;
    Produto produto;

    @Test
    @DisplayName("Validar código de barras")
    void validarCodigoDeBarras() {
        String codigo = "4012345678901";

        int step1 = 0;
        int step2 = 0;
        for (int i = 12; i > 0 ; i -= 2) {
            step1 += Integer.parseInt(codigo.substring(i-1, i));
            step2 += Integer.parseInt(codigo.substring(i-2, i-1));
        }
        int total = step1 * 3 + step2;

        int digito = 10 - total % 10;

        boolean resultado = digito == Integer.parseInt(codigo.substring(12));
        assertEquals(resultado, driver.validar(codigo));
    }
}