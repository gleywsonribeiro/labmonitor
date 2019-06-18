/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.controle;

import br.gleywson.modelo.PerguntaVariavel;
import br.gleywson.modelo.RespostaVariavel;
import br.gleywson.modelo.dao.RespostaFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author gleyw
 */
@ManagedBean
@RequestScoped
public class DashBoardController implements Serializable {

    @EJB
    RespostaFacade respostaFacade;

    private final List<PieChartModel> graficos = new ArrayList<PieChartModel>();
    private final List<PieChartModel> graficosEmpatia = new ArrayList<PieChartModel>();

    private final List<PerguntaVariavel> perguntas = new ArrayList<PerguntaVariavel>();
    private final List<RespostaVariavel> respostas = new ArrayList<RespostaVariavel>();

    @PostConstruct
    public void init() {
        createGraficos();
        createGraficosEmpatia();
    }

    public DashBoardController() {

    }

    private void createGraficos() {
        List<Object[]> dados = respostaFacade.getTotalRespostasPorPergunta(1L);

        for (Object[] dado : dados) {
//            PieChartModel pcm = new PieChartModel();
            //RespostaVariavel rv = new RespostaVariavel(dado[0].toString(), dado[1].toString(), 0);
            PerguntaVariavel pv = new PerguntaVariavel(dado[0].toString());
            RespostaVariavel rv = new RespostaVariavel(dado[0].toString(), dado[1].toString(), Integer.parseInt(dado[2].toString()));

            respostas.add(rv);

            if (!perguntas.contains(pv)) {
                perguntas.add(pv);
            }

        }
        for (PerguntaVariavel pergunta : perguntas) {
            for (RespostaVariavel resposta : respostas) {
                if (pergunta.getPergunta().equals(resposta.getPerguntaVariavel())) {
                    pergunta.getRepostas().add(resposta);
                }
            }
        }

        for (PerguntaVariavel pergunta : perguntas) {
            PieChartModel pcm = new PieChartModel();
            pcm.setTitle(pergunta.getPergunta());
            pcm.setLegendPosition("w");

            for (RespostaVariavel resposta : pergunta.getRepostas()) {
                pcm.set(resposta.getResposta(), resposta.getTotal());
            }
            graficos.add(pcm);
        }
    }

    private void createGraficosEmpatia() {
        List<Object[]> dados = respostaFacade.getTotalEscalaEmpatia(1L);
        PieChartModel pcm = new PieChartModel();
        pcm.setTitle("Escala de Fantasia");
        pcm.setLegendPosition("w");
        
        for (Object[] dado : dados) {
            pcm.set(dado[0].toString(), Integer.parseInt(dado[1].toString()));
        }

    }

    public List<PieChartModel> getGraficos() {
        return graficos;
    }

    public List<PieChartModel> getGraficosEmpatia() {
        return graficosEmpatia;
    }

}
