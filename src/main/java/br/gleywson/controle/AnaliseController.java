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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.DragDropEvent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author gleyw
 */
@ManagedBean
@ViewScoped
public class AnaliseController implements Serializable {

    private Pergunta pergunta;
    private Opcao opcao;

    @EJB
    private OpcaoFacade opcaoFacade;

//    Trabalhando com picklist
    private DualListModel<Opcao> variaveis;
    private final PieChartModel graficoEmpatia = new PieChartModel();

    @PostConstruct
    public void init() {
        List<Opcao> variaveisDisponiveis = opcaoFacade.getVariaveisCategoricas();
        List<Opcao> variaveisSelecionadas = new ArrayList<Opcao>();
        variaveis = new DualListModel<Opcao>(variaveisDisponiveis, variaveisSelecionadas);
    }

    private void createGraficosEmpatia() {
//        List<Object[]> dados = respostaFacade.getTotalEscalaEmpatia(1L);

        graficoEmpatia.setTitle("Escala de Fantasia");
        graficoEmpatia.setLegendPosition("s");
        graficoEmpatia.setFill(false);
        graficoEmpatia.setShowDataLabels(true);

        for (Object[] dado : dados) {
            graficoEmpatia.set(dado[0].toString(), Integer.parseInt(dado[1].toString()));
        }

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

    public DualListModel<Opcao> getVariaveis() {
        return variaveis;
    }

    public void setVariaveis(DualListModel<Opcao> variaveis) {
        this.variaveis = variaveis;
    }

    public void analisar() {
        System.out.println(variaveis.getTarget());
        createGraficosEmpatia();
    }

    public PieChartModel getGraficoEmpatia() {
        return graficoEmpatia;
    }

}
