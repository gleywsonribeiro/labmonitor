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
public enum TipoExame {

    SOLICITADO("LAB_SOLICITADO"),
    URGENTE("LAB_URGENTE"),
    PENDENTE("LAB_PENDENTE"),
    SEPSE("LAB_SEPSE"),
    MEDICINA("LAB_MEDICINA");

    private final String descricao;

    private TipoExame(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
