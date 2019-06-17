/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.modelo.dao;

import br.gleywson.modelo.Pesquisa;
import br.gleywson.modelo.Resposta;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author gleywson
 */
@javax.ejb.Stateless
public class RespostaFacade extends AbstractFacade<Resposta> {
    
    @PersistenceContext(unitName = "iriPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public RespostaFacade() {
        super(Resposta.class);
    }
    
    public List<Object[]> getTotalRespostasPorPergunta(Long idPesquisa) {
        
        List<Object[]> resultado = getEntityManager().createNativeQuery("select p.descricao pergunta, o.descricao resposta, count(*) total "
                + "from resposta r, pesquisa pes, avaliacao av, pergunta p, opcao o "
                + "where r.avaliacao_id = av.id "
                + "and r.pergunta_id = p.id "
                + "and r.opcao_id = o.id "
                + "group by p.descricao, o.descricao "
                + "order by p.descricao").getResultList();

        for (Object[] linha : resultado) {
//            String pergunta = (String) linha[0];
//            String resposta = (String) linha[1];
//            String total = (String) linha[2];
//            System.out.println(linha[0] + " -> " + linha[1] + ": " + linha[3]);
            for (Object object : linha) {
                System.out.println(object);
            }
            System.out.println("------------");
        }
        
        return resultado;
    }
    
}
