/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.modelo;

import java.util.Date;

/**
 *
 * @author gleywson
 */
public class Pedido {
    private int codigo;
    private String setor;
    private Date dataPedido;

    public Pedido() {
    }

    public Pedido(int codigo, String setor, Date dataPedido) {
        this.codigo = codigo;
        this.setor = setor;
        this.dataPedido = dataPedido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

  
    
    
}
