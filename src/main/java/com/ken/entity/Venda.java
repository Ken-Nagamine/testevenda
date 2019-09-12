/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ken.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ken
 */
@Entity
@Table(name="venda")
public class Venda implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate data_venda;
    
    private BigDecimal valor;
    
    private int vendedor_id;
    
    private String vendedor_nome;

    public Venda() {
    }

    public Venda(LocalDate data_venda, BigDecimal valor, int vendedor_id, String vendedor_nome) {
        this.data_venda = data_venda;
        this.valor = valor;
        this.vendedor_id = vendedor_id;
        this.vendedor_nome = vendedor_nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData_venda() {
        return data_venda;
    }

    public void setData_venda(LocalDate data_venda) {
        this.data_venda = data_venda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getVendedor_id() {
        return vendedor_id;
    }

    public void setVendedor_id(int vendedor_id) {
        this.vendedor_id = vendedor_id;
    }

    public String getVendedor_nome() {
        return vendedor_nome;
    }

    public void setVendedor_nome(String vendedor_nome) {
        this.vendedor_nome = vendedor_nome;
    }
   
}
