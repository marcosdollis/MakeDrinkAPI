
package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Producao {
    
    @Id
    private int id;
    private int ordem_producao;
    private int quantidade;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_criacao;
    @ManyToOne
    private Produto produto_cod;
    @ManyToOne
    private Ingredientes ingrediente_cod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdem_producao() {
        return ordem_producao;
    }

    public void setOrdem_producao(int ordem_producao) {
        this.ordem_producao = ordem_producao;
    }

    public int getProtocolo() {
        return quantidade;
    }

    public void setProtocolo(int protocolo) {
        this.quantidade = protocolo;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Produto getProduto_cod() {
        return produto_cod;
    }

    public void setProduto_cod(Produto produto_cod) {
        this.produto_cod = produto_cod;
    }

    public Ingredientes getIngrediente_cod() {
        return ingrediente_cod;
    }

    public void setIngrediente_cod(Ingredientes ingrediente_cod) {
        this.ingrediente_cod = ingrediente_cod;
    }
    
    
}
