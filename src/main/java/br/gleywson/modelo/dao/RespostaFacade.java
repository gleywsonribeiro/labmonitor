/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.modelo.dao;

import br.gleywson.modelo.Resposta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
                //                + "and av.pesquisa_id = " + idPesquisa + " "
                + "group by p.descricao, o.descricao "
                + "order by p.descricao");

        List<Object[]> resultado = query.getResultList();
        return resultado;
    }

    public List<Object[]> getTotalEscalaEmpatia(Long idPesquisa) {
        Query query = getEntityManager().createNativeQuery("select case p.qualificador\n"
                + "         when 'PT' then\n"
                + "          'Escala de Tomada de Perspectiva'\n"
                + "         when 'FS' then\n"
                + "          'Escala de Fantasia'\n"
                + "         when 'EC' then\n"
                + "          'Escala de Consideração Empática'\n"
                + "         when 'PD' then\n"
                + "          'Escala de Angústia Pessoal'\n"
                + "       end escala,\n"
                + "       sum(o.peso)\n"
                + "  from resposta r, avaliacao av, pesquisa pes, pergunta p, opcao o\n"
                + " where av.pesquisa_id = pes.id\n"
                + "   and r.avaliacao_id = av.id\n"
                + "   and r.opcao_id = o.id\n"
                + "   and r.pergunta_id = p.id\n"
                + "   and p.tipo = 'AUTOMATICO'\n"
                + " group by qualificador");

        List<Object[]> resultado = query.getResultList();
        return resultado;
    }

}
