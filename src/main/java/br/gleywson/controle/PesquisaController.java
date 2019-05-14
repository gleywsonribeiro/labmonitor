/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.controle;

import br.gleywson.jsf.util.JsfUtil;
import br.gleywson.modelo.Pesquisa;
import br.gleywson.modelo.dao.PesquisaFacade;
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
public class PesquisaController {

    private Pesquisa pesquisa;
    private List<Pesquisa> pesquisas;
    
    @EJB
    private PesquisaFacade pesquisaFacade;
    
    
    
    public PesquisaController() {
        pesquisa = new Pesquisa();
    }
    
    public void salvar() {
        if(pesquisa.getId() == null) {
            pesquisaFacade.create(pesquisa);
            JsfUtil.addMessage("Salvo com sucesso!");
        } else {
            pesquisaFacade.edit(pesquisa);
            JsfUtil.addMessage("Atualizado com sucesso!");
        }
        
        
    }

    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }

    public List<Pesquisa> getPesquisas() {
        return pesquisaFacade.findAll();
    }
    
    
    
}
