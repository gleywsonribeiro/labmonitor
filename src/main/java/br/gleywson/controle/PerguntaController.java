/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.controle;

import br.gleywson.jsf.util.JsfUtil;
import br.gleywson.modelo.Pergunta;
import br.gleywson.modelo.Pesquisa;
import br.gleywson.modelo.dao.PerguntaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author gleywson
 */
@ManagedBean
@ViewScoped
public class PerguntaController {

    private Pesquisa pesquisa;
    
    private Pergunta pergunta;
    private List<Pergunta> perguntas;
    
    @EJB
    private PerguntaFacade perguntaFacade;
    
    public PerguntaController() {
        pergunta = new Pergunta();
    }
    
    public void salvar() {
        pergunta.setPesquisa(pesquisa);
        if(pergunta.getId() == null) {
            perguntaFacade.create(pergunta);
            JsfUtil.addMessage("Salvo");
        } else {
            perguntaFacade.edit(pergunta);
            JsfUtil.addMessage("Alterado com sucesso!");
        }
        pergunta = new Pergunta();
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public List<Pergunta> getPerguntas() {
        return perguntaFacade.findAll();
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    
}
