package Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Product implements Serializable{
    @Id
    private Long sku;
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dataDeCriacao;
    private String lote;
    private Integer quantidade;
    private BigDecimal valorPorUnidade;
    private String descricao;
    private String localDeArmazenamento;
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValorPorUnidade() {
        return valorPorUnidade;
    }

    public void setValorPorUnidade(BigDecimal valorPorUnidade) {
        this.valorPorUnidade = valorPorUnidade;
    }
    
    public String getNome() {
        return nome;
    }

 

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLote() {
        return lote;
    }

    public void setLocalDeArmazenamento(String localDeArmazenamento) {
        this.localDeArmazenamento = localDeArmazenamento;
    }

    public String getLocalDeArmazenamento() {
        return localDeArmazenamento;
    }

    public Long getSku() {
        return sku;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
