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
import javax.persistence.Query;

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

    public List<Object[]> getEmpatiaPorVariavelCategoria(List<Opcao> lista) {

        String sql = "SELECT CASE p.qualificador \n"
                + "         WHEN 'PT' THEN 'Escala de Tomada de Perspectiva' \n"
                + "         WHEN 'FS' THEN 'Escala de Fantasia' \n"
                + "         WHEN 'EC' THEN 'Escala de Consideração Empática' \n"
                + "         WHEN 'PD' THEN 'Escala de Angústia Pessoal' \n"
                + "         ELSE 'Escala de Fantasia' \n"
                + "       END escala, \n"
                + "       Sum(o.peso) \n"
                + "FROM   avaliacao av, \n"
                + "       pesquisa pes, \n"
                + "       resposta r, \n"
                + "       pergunta p, \n"
                + "       opcao o \n"
                + "WHERE  pes.id = av.pesquisa_id \n"
                + "       AND r.avaliacao_id = av.id \n"
                + "       AND r.pergunta_id = p.id \n"
                + "       AND r.opcao_id = o.id \n"
                + "       AND p.tipo = 'AUTOMATICO' \n";

        sql += "AND av.id IN (SELECT av.id \n"
                + "                     FROM   avaliacao av, \n"
                + "                            pesquisa pes, \n"
                + "                            resposta r, \n"
                + "                            pergunta p, \n"
                + "                            opcao o \n"
                + "                     WHERE  pes.id = av.pesquisa_id \n"
                + "                            AND r.avaliacao_id = av.id \n"
                + "                            AND r.pergunta_id = p.id \n"
                + "                            AND r.opcao_id = o.id \n";

        if (!lista.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            builder.append("(");

            for (int i = 0; i < lista.size() - 1; i++) {
                builder.append(lista.get(i).getId()).append(",");
            }
            builder.append(lista.get(lista.size() - 1).getId() + ") ");
            sql += "AND o.id in " + builder.toString();
        }

        sql += ") ";

        sql += "GROUP  BY qualificador ";

        Query query = getEntityManager().createNativeQuery(sql);

        List<Object[]> resultado = query.getResultList();

        return resultado;
    }

}
