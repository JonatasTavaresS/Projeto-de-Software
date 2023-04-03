package com.ufcg.psoft.mercadofacil.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "produtos")
public class Produto {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @JsonProperty("nome")
    @Column(nullable = false)
    private String nome;
    @JsonProperty("preco")
    @Column(nullable = false)
    private double preco;
    @JsonProperty("codigoBarra")
    @Column(nullable = false)
    private String codigoBarra;
    @JsonProperty("fabricante")
    @Column(nullable = false)
    private String fabricante;
}
