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
import br.gleywson.modelo.dao.PesquisaFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author gleywson
 */
@ManagedBean
@ViewScoped
public class EditPerguntaController {

    private Pesquisa pesquisa;
    
    @EJB
    private PesquisaFacade pesquisaFacade;
    
    @EJB
    private PerguntaFacade perguntaFacade;
    
    @PostConstruct
    public void init() {
        String codigo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("pesquisa_id");
        pesquisa = pesquisaFacade.find(Long.parseLong(codigo));
    }
    
    public EditPerguntaController() {
        
    }

    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    public void salvar() {
        for (Pergunta pergunta : pesquisa.getPerguntas()) {
            perguntaFacade.edit(pergunta);
        }
        JsfUtil.addMessage("Todas as alterações foram salvas!");
    }
    
}
