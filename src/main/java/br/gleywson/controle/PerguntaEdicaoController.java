/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.controle;

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
public class PerguntaEdicaoController {
    
    private Pesquisa pesquisa;
    private List<Pesquisa> pesquisas;
    
    @EJB
    private PesquisaFacade pesquisaFacade;
    
 

    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }

    public List<Pesquisa> getPesquisas() {
        pesquisas = pesquisaFacade.findAll();
        return pesquisas;
    }
    
}
