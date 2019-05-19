/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.controle;

import br.gleywson.modelo.Avaliacao;
import br.gleywson.modelo.Opcao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gleyw
 */
@ManagedBean
@ViewScoped
public class AvaliacaoController {

    private Avaliacao avaliacao;
    
    
    public AvaliacaoController() {
        this.avaliacao = new Avaliacao();
    }
    
    

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    public void addResposta(Object opcao) {
        Opcao op = (Opcao) opcao;
        System.out.println(op.getDescricao());
        System.out.println(op.getPergunta().getDescricao());
    }
    
}
