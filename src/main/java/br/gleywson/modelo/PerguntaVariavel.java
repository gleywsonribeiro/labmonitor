/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gleywson
 */
public class PerguntaVariavel {
    private String pergunta;
    private final List<RespostaVariavel> repostas = new ArrayList<RespostaVariavel>();

    public PerguntaVariavel() {
    }

    
    
    public PerguntaVariavel(String pergunta) {
        this.pergunta = pergunta;
    }
    
    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public List<RespostaVariavel> getRepostas() {
        return repostas;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.pergunta != null ? this.pergunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PerguntaVariavel other = (PerguntaVariavel) obj;
        if ((this.pergunta == null) ? (other.pergunta != null) : !this.pergunta.equals(other.pergunta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PerguntaVariavel{" + "pergunta=" + pergunta + '}';
    }
    
    
    
}
