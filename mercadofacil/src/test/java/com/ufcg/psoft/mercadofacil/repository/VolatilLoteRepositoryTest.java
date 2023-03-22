package com.ufcg.psoft.mercadofacil.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;

@SpringBootTest
public class VolatilLoteRepositoryTest {

    @Autowired
    VolatilLoteRepository driver;
    Lote lote;
    Produto produto;

    @Test
    @DisplayName("Inserir o primeiro lote no banco de dados")
    void inserirPrimeiroLoteNoBanco() {
        // Definir dados de teste
        produto = Produto.builder()
                .id(1L)
                .nome("Arroz")
                .preco(1.00)
                .codigoBarra("123456789")
                .fabricante("Arroz do Brasil")
                .build();
        lote = Lote.builder()
                .id(10L)
                .numeroDeItens(100)
                .produto(produto)
                .build();

        // Realizar procedimento de teste
        Lote resultado = driver.save(lote);

        // Verificar resultado
        assertEquals(resultado.getId().longValue(), lote.getId().longValue());
        assertEquals(resultado, lote);
        assertEquals(driver.findAll().size(), 1);
    }

}
