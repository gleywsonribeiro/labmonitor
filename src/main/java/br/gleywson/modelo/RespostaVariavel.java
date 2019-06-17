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
public class RespostaVariavel {
    private String perguntaVariavel;
    private String resposta;
    private int total;

    public RespostaVariavel() {
    }

    public RespostaVariavel(String perguntaVariavel, String resposta, int total) {
        this.perguntaVariavel = perguntaVariavel;
        this.resposta = resposta;
        this.total = total;
    }

    
    
    

    public String getPerguntaVariavel() {
        return perguntaVariavel;
    }

    public void setPerguntaVariavel(String perguntaVariavel) {
        this.perguntaVariavel = perguntaVariavel;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.resposta != null ? this.resposta.hashCode() : 0);
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
        final RespostaVariavel other = (RespostaVariavel) obj;
        if ((this.resposta == null) ? (other.resposta != null) : !this.resposta.equals(other.resposta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RespostaVariavel{" + "perguntaVariavel=" + perguntaVariavel + ", resposta=" + resposta + ", total=" + total + '}';
    }
    
    
    
    
}
