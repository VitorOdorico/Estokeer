package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovimentacaoDeArmazem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordemMovimentacao;
    private Date dataDeMovimentacao;
    private String observacaoMovimentacao;

    public Date getDataDeMovimentacao() {
        return dataDeMovimentacao;
    }

    public void setDataDeMovimentacao(Date dataDeMovimentacao) {
        this.dataDeMovimentacao = dataDeMovimentacao;
    }

    public String getObservacaoMovimentacao() {
        return observacaoMovimentacao;
    }

    public void setObservacaoMovimentacao(String observacaoMovimentacao) {
        this.observacaoMovimentacao = observacaoMovimentacao;
    }
    
    
}
