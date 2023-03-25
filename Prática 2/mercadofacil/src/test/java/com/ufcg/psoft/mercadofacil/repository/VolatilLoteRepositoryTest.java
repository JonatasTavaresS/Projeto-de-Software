package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VolatilLoteRepositoryTest {

    @Autowired
    VolatilLoteRepository driver;

    Lote lote;
    Lote resultado;
    Produto produto;

    @BeforeEach
    void setup() {
        produto = Produto.builder()
                .id(1L)
                .nome("Produto Base")
                .codigoBarra("123456789")
                .fabricante("Fabricante Base")
                .preco(125.36)
                .build();
        lote = Lote.builder()
                .id(1L)
                .numeroDeItens(100)
                .produto(produto)
                .build();
    }

    @AfterEach
    void tearDown() {
        produto = null;
        driver.deleteAll();
    }

    @Test
    @DisplayName("Adicionar o primeiro Lote no repositório de dados")
    void salvarPrimeiroLote() {
        resultado = driver.save(lote);

        assertEquals(driver.findAll().size(), 1);
        assertEquals(resultado.getId().longValue(), lote.getId().longValue());
        assertEquals(resultado.getProduto(), produto);
    }

    @Test
    @DisplayName("Adicionar o segundo Lote (ou posterior) no repositório de dados")
    void salvarSegundoLoteOuPosterior() {
        Produto produtoExtra = Produto.builder()
                .id(2L)
                .nome("Produto Extra")
                .codigoBarra("987654321")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();
        Lote loteExtra = Lote.builder()
                .id(2L)
                .numeroDeItens(100)
                .produto(produtoExtra)
                .build();
        driver.save(lote);

        resultado = driver.save(loteExtra);

        assertEquals(driver.findAll().size(), 2);
        assertEquals(resultado.getId().longValue(), loteExtra.getId().longValue());
        assertEquals(resultado.getProduto(), produtoExtra);
    }

    @Test
    @DisplayName("Encontrar Lote existente no repositório de dados")
    void encontrarLoteExistente() {
        driver.save(lote);
        assertEquals(driver.find(1L), lote);
    }

    @Test
    @DisplayName("Encontrar Lote inexistente no repositório de dados")
    void encontrarLoteInexistente() {
        assertNull(driver.find(2L));
        assertNull(driver.find(null));
    }

    @Test
    @DisplayName("Atualizar primeiro Lote no repositório de dados")
    void atualizarUnicoLote() {
        driver.save(lote);
        lote.setId(4L);

        assertEquals(1, driver.findAll().size());
        assertEquals(lote, driver.update(lote));
        assertEquals(1, driver.findAll().size());
    }

    @Test
    @DisplayName("Atualizar segundo Lote (ou posterior) no repositório de dados")
    void atualizarSegundoLoteOuPosterior() {
        driver.save(lote);
        Produto produtoExtra = Produto.builder()
                .id(2L)
                .nome("Produto Extra")
                .codigoBarra("987654321")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();
        Lote loteExtra = Lote.builder()
                .id(2L)
                .numeroDeItens(100)
                .produto(produtoExtra)
                .build();
        driver.save(loteExtra);
        loteExtra.setId(4L);

        assertEquals(2, driver.findAll().size());
        assertEquals(loteExtra, driver.update(loteExtra));
        assertEquals(2, driver.findAll().size());
    }

    @Test
    @DisplayName("Deletar primeiro Lote no repositório de dados")
    void deletarPrimeiroLote() {
        driver.save(lote);
        assertEquals(driver.findAll().size(), 1);
        driver.delete(lote);
        assertEquals(driver.findAll().size(), 0);
    }

    @Test
    @DisplayName("Deletar segundo Lote (ou posterior) no repositório de dados")
    void deletarSegundoLoteOuPosterior() {
        driver.save(lote);
        Produto produtoExtra = Produto.builder()
                .id(2L)
                .nome("Produto Extra")
                .codigoBarra("987654321")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();
        Lote loteExtra = Lote.builder()
                .id(2L)
                .numeroDeItens(100)
                .produto(produtoExtra)
                .build();
        driver.save(loteExtra);

        assertEquals(driver.findAll().size(), 2);
        driver.delete(loteExtra);
        assertEquals(driver.findAll().size(), 1);
    }

    @Test
    @DisplayName("Deletar todos os Lotes com único Lote no repositório de dados")
    void deletarUnicoLotes() {
        driver.save(lote);
        assertEquals(driver.findAll().size(), 1);
        driver.deleteAll();
        assertEquals(driver.findAll().size(), 0);
    }

    @Test
    @DisplayName("Deletar todos os Lotes com vários Lotes no repositório de dados")
    void deletarTodosLotes() {
        driver.save(lote);
        Produto produtoExtra = Produto.builder()
                .id(2L)
                .nome("Produto Extra")
                .codigoBarra("987654321")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();
        Lote loteExtra = Lote.builder()
                .id(2L)
                .numeroDeItens(100)
                .produto(produtoExtra)
                .build();
        driver.save(loteExtra);

        assertEquals(driver.findAll().size(), 2);
        driver.deleteAll();
        assertEquals(driver.findAll().size(), 0);
    }

}
