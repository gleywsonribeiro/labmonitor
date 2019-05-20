/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.controle;

import br.gleywson.jsf.util.JsfUtil;
import br.gleywson.modelo.Avaliacao;
import br.gleywson.modelo.Opcao;
import br.gleywson.modelo.Pesquisa;
import br.gleywson.modelo.Resposta;
import br.gleywson.modelo.dao.AvaliacaoFacade;
import br.gleywson.modelo.dao.PesquisaFacade;
import br.gleywson.modelo.dao.RespostaFacade;
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
    private List<Resposta> respostas;
    
    @EJB
    private PesquisaFacade pesquisaFacade;
    @EJB
    private RespostaFacade respostaFacade;
    @EJB
    private AvaliacaoFacade avaliacaoFacade;
    
    @PostConstruct
    public void init() {
        String codigo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cod_pesquisa");
        pesquisa = pesquisaFacade.find(Long.parseLong(codigo));
    }
    
    public AvaliacaoController() {
        this.avaliacao = new Avaliacao();
        this.opcao = new Opcao();
        respostas = new ArrayList<Resposta>();
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
        
        Resposta resposta = new Resposta();
        resposta.setValor(opcao.getPeso());
        
        resposta.setOpcao(opcao);
        resposta.setPergunta(opcao.getPergunta());
        resposta.setAvaliacao(avaliacao);
        
        respostas.add(resposta);
    }
    
    public void salvar() {
        avaliacao.setPesquisa(pesquisa);
        avaliacaoFacade.create(avaliacao);
        for (Resposta resposta : respostas) {
            respostaFacade.create(resposta);
        }
        JsfUtil.addMessage("Pesquisa Realizada com sucesso!");
    }
    
}
