/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.controle;

import br.gleywson.modelo.Avaliacao;
import br.gleywson.modelo.Opcao;
import br.gleywson.modelo.Pesquisa;
import br.gleywson.modelo.dao.PesquisaFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author gleyw
 */
@ManagedBean
@ViewScoped
public class AvaliacaoController {

    Pesquisa pesquisa = new Pesquisa();
    
    private Avaliacao avaliacao;
    private Opcao opcao;
    private List<Opcao> opcoes;
    
    @EJB
    private PesquisaFacade pesquisaFacade;
    
    @PostConstruct
    public void init() {
        String codigo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cod_pesquisa");
        System.out.println("Fui chamado!");
        System.out.println(codigo);
        pesquisa = pesquisaFacade.find(Long.parseLong(codigo));
    }
    
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

    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }
    
    
    
    public void addResposta() {
        
        System.out.println(opcao.getDescricao());
        System.out.println(opcao.getPergunta().getDescricao());
    }
    
}
