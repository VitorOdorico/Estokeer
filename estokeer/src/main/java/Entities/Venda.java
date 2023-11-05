package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenda;
    private Date dataVenda;
    private Date dataDoFaturamento;

    public Date getDataVenda() {
        return dataVenda;
    }

    public Date getDataDoFaturamento() {
        return dataDoFaturamento;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void setDataDoFaturamento(Date dataDoFaturamento) {
        this.dataDoFaturamento = dataDoFaturamento;
    }
 
 
}
