/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.modelo;

/**
 *
 * @author gleywson
 */
public enum Tipo {
    NORMAL("Normal"),
    AUTOMATICO("Automático");

    private final String descricao;

    private Tipo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
