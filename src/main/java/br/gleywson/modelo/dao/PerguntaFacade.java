/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.modelo.dao;

import br.gleywson.modelo.Pergunta;
import br.gleywson.modelo.Tipo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gleywson
 */
@javax.ejb.Stateless
public class PerguntaFacade extends AbstractFacade<Pergunta> {

    @PersistenceContext(unitName = "iriPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerguntaFacade() {
        super(Pergunta.class);
    }
    
    public List<Pergunta> getVariaveisCategoricas() {
         return getEntityManager().createQuery("SELECT p FROM Pergunta AS p WHERE p.tipo = :tipo", Pergunta.class)
                .setParameter("tipo", Tipo.NORMAL).getResultList();
    }
    
}
