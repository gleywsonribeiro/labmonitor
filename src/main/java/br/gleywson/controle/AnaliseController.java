/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.controle;

import br.gleywson.modelo.Opcao;
import br.gleywson.modelo.Pergunta;
import br.gleywson.modelo.dao.OpcaoFacade;
import br.gleywson.modelo.dao.PerguntaFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.DragDropEvent;

/**
 *
 * @author gleyw
 */
@ManagedBean
@ViewScoped
public class AnaliseController {

    private Pergunta pergunta;
    private Opcao opcao;
    @EJB
    private PerguntaFacade perguntaFacade;
    @EJB
    private OpcaoFacade opcaoFacade;
    
    private List<Opcao> variaveisDisponiveis;
    private List<Opcao> variaveisAnalisadas;
    
    @PostConstruct
    public void init() {
        variaveisDisponiveis = opcaoFacade.getVariaveisCategoricas();
        variaveisAnalisadas = new ArrayList<Opcao>();
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Opcao getOpcao() {
        return opcao;
    }

    public void setOpcao(Opcao opcao) {
        this.opcao = opcao;
    }

    public List<Opcao> getVariaveisDisponiveis() {
        return variaveisDisponiveis;
    }

    public void setVariaveisDisponiveis(List<Opcao> variaveisDisponiveis) {
        this.variaveisDisponiveis = variaveisDisponiveis;
    }

    public List<Opcao> getVariaveisAnalisadas() {
        return variaveisAnalisadas;
    }

    public void setVariaveisAnalisadas(List<Opcao> variaveisAnalisadas) {
        this.variaveisAnalisadas = variaveisAnalisadas;
    }
    
    public void onCarDrop(DragDropEvent ddEvent) {
        Opcao opcao = ((Opcao) ddEvent.getData());
  
        variaveisAnalisadas.add(opcao);
        variaveisDisponiveis.remove(opcao);
    }
    
}
