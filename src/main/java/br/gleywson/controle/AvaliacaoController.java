/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.controle;

import br.gleywson.modelo.Avaliacao;
import br.gleywson.modelo.Opcao;
import java.util.ArrayList;
import java.util.List;
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
    private Opcao opcao;
    private List<Opcao> opcoes;
    
    public AvaliacaoController() {
        this.avaliacao = new Avaliacao();
        this.opcao = new Opcao();
        opcoes = new ArrayList<Opcao>();
    }
    
    

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Opcao getOpcao() {
        return opcao;
    }

    public void setOpcao(Opcao opcao) {
        this.opcao = opcao;
    }
    
    public void addResposta() {
        
        System.out.println(opcao.getDescricao());
        System.out.println(opcao.getPergunta().getDescricao());
    }
    
}
