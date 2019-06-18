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

        Query query = getEntityManager().createNativeQuery("select p.descricao pergunta, o.descricao resposta, count(*) total "
                + "from resposta r, avaliacao av, pergunta p, opcao o "
                + "where r.avaliacao_id = av.id "
                + "and r.pergunta_id = p.id "
                + "and r.opcao_id = o.id "
                + "and av.pesquisa_id = " + idPesquisa + " "
                + "group by p.descricao, o.descricao "
                + "order by p.descricao");

        List<Object[]> resultado = query.getResultList();
        return resultado;
    }

    public List<Object[]> getTotalEscalaEmpatia(Long idPesquisa) {
        Query query = getEntityManager().createNativeQuery("select p.qualificador, count(*) "
                + "from resposta r, avaliacao av, pesquisa pes, pergunta p, opcao o "
                + "where av.pesquisa_id = pes.id "
                + "and r.avaliacao_id = av.id "
                + "and r.opcao_id = o.id "
                + "and r.pergunta_id = p.id "
                + "and pes.id = "+idPesquisa+" "
                + "and p.tipo = 'AUTOMATICO' "
                + "group by qualificador");

        List<Object[]> resultado = query.getResultList();
        return resultado;
    }

}
