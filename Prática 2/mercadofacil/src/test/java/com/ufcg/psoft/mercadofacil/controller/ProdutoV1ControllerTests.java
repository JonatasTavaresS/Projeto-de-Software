package com.ufcg.psoft.mercadofacil.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufcg.psoft.mercadofacil.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes dp Controladorm de Produtos")
public class ProdutoV1ControllerTests {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    Produto produto;

    @BeforeEach
    void setUp() {
        produto = Produto.builder()
                .id(10L)
                .nome("Produto Base")
                .codigoBarra("123456789")
                .fabricante("Fabricante Dez")
                .preco(125.36)
                .build();
    }

    @Test
    @DisplayName("Quando altero produto com nome válido")
    void alterarProdutoNomeValido() throws Exception {
        produto.setNome("Chiclete");
        String produtoModificadoJSONString = mockMvc.perform(
                        put("/v1/produtos/" + 10)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        Produto produtoModificado = objectMapper.readValue(produtoModificadoJSONString, Produto.class);
        assertEquals("Chiclete", produtoModificado.getNome());
    }
}
