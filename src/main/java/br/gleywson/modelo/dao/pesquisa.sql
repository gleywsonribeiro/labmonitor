SELECT av.id, 
       pes.descricao, 
       p.descricao pergunta, 
       o.descricao opcao 
FROM   avaliacao av, 
       pesquisa pes, 
       resposta r, 
       pergunta p, 
       opcao o 
WHERE  pes.id = av.pesquisa_id 
       AND r.avaliacao_id = av.id 
       AND r.pergunta_id = p.id 
       AND r.opcao_id = o.id 
       AND av.id IN (SELECT av.id 
                     FROM   avaliacao av, 
                            pesquisa pes, 
                            resposta r, 
                            pergunta p, 
                            opcao o 
                     WHERE  pes.id = av.pesquisa_id 
                            AND r.avaliacao_id = av.id 
                            AND r.pergunta_id = p.id 
                            AND r.opcao_id = o.id 
                            AND p.descricao = 'Sexo' 
                            AND o.descricao = 'Masculino') 
ORDER  BY av.id, 
          p.descricao, 
          o.descricao 