package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ingredientes {

    @Id
    private int id;
    private String nome_ingrediente;
    private Double quantidade_ingrediente_por_unidade;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Produto> recVagaList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_ingrediente() {
        return nome_ingrediente;
    }

    public void setNome_ingrediente(String nome_ingrediente) {
        this.nome_ingrediente = nome_ingrediente;
    }

    public Double getQuantidade_ingrediente_por_unidade() {
        return quantidade_ingrediente_por_unidade;
    }

    public void setQuantidade_ingrediente_por_unidade(Double quantidade_ingrediente_por_unidade) {
        this.quantidade_ingrediente_por_unidade = quantidade_ingrediente_por_unidade;
    }

    public List<Produto> getRecVagaList() {
        return recVagaList;
    }

    public void setRecVagaList(List<Produto> recVagaList) {
        this.recVagaList = recVagaList;
    }

}
