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

    private PieChartModel pieChartModel;
    private List<PieChartModel> graficos = new ArrayList<PieChartModel>();
    private List<PerguntaVariavel> perguntas = new ArrayList<PerguntaVariavel>();
    private List<RespostaVariavel> respostas = new ArrayList<RespostaVariavel>();

    @PostConstruct
    public void init() {
        createPieModel();
        createGraficos();
    }

    public DashBoardController() {

    }

    public void emitir() {
        respostaFacade.getTotalRespostasPorPergunta(1601L);
    }

    private void createPieModel() {
        pieChartModel = new PieChartModel();

        pieChartModel.set("Brand 1", 1);
        pieChartModel.set("Brand 2", 2);
        pieChartModel.set("Brand 3", 3);
        pieChartModel.set("Brand 4", 4);

        pieChartModel.setTitle("Simple Pie");
        pieChartModel.setLegendPosition("w");
    }

    private void createGraficos() {
        List<Object[]> dados = respostaFacade.getTotalRespostasPorPergunta(102L);

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
                //pieChartModel.set("Brand 2", 2);
                pcm.set(resposta.getResposta(), resposta.getTotal());
            }
            graficos.add(pcm);
        }
    }

    public PieChartModel getPieChartModel() {
        return pieChartModel;
    }

    public void setPieChartModel(PieChartModel pieChartModel) {
        this.pieChartModel = pieChartModel;
    }

    public List<PieChartModel> getGraficos() {
        return graficos;
    }

    public void setGraficos(List<PieChartModel> graficos) {
        this.graficos = graficos;
    }

}
