/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {
    
    @Id
    private int id;
    private String nome_produto;
    private double quantidade_desejada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public double getQuantidade_desejada() {
        return quantidade_desejada;
    }

    public void setQuantidade_desejada(double quantidade_desejada) {
        this.quantidade_desejada = quantidade_desejada;
    }
    
}
