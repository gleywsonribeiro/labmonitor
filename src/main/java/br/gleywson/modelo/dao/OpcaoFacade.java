/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.modelo.dao;

import br.gleywson.modelo.Opcao;
import br.gleywson.modelo.Tipo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gleywson
 */
@javax.ejb.Stateless
public class OpcaoFacade extends AbstractFacade<Opcao> {

    @PersistenceContext(unitName = "iriPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OpcaoFacade() {
        super(Opcao.class);
    }
    
    public List<Opcao> getVariaveisCategoricas() {
        return getEntityManager().createQuery("SELECT o FROM Pergunta AS p, Opcao AS o WHERE o.pergunta = p AND p.tipo = :tipo")
                .setParameter("tipo", Tipo.NORMAL).getResultList();
    }
    
}
