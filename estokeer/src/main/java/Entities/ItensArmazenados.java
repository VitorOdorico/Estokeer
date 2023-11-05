/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ve743
 */
@Entity
public class ItensArmazenados implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer ordemDeTransferencia;
    private String quantidadeArmazenado;

    public String getQuantidadeArmazenado() {
        return quantidadeArmazenado;
    }

    public void setQuantidadeArmazenado(String quantidadeArmazenado) {
        this.quantidadeArmazenado = quantidadeArmazenado;
    }
    
    
}
