/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.controle;

import br.gleywson.modelo.dao.RespostaFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author gleyw
 */
@ManagedBean
@RequestScoped
public class DashBoardController implements Serializable {

    @EJB
    RespostaFacade respostaFacade;
    
    public DashBoardController() {
        
    }
    
    public void emitir() {
        respostaFacade.getTotalRespostasPorPergunta(1L);
    }
    
}
