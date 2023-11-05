package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lote implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFabricacao;
    private String lote;
    private Date dataDeFabricacao;
    private Integer quantidade;
    private String observacoes;

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setDataDeFabricacao(Date dataDeFabricacao) {
        this.dataDeFabricacao = dataDeFabricacao;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getLote() {
        return lote;
    }

    public Date getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getObservacoes() {
        return observacoes;
    }
}
   
