select av.id, pes.descricao, p.descricao pergunta, o.descricao opcao
from avaliacao av, pesquisa pes, resposta r, pergunta p, opcao o
where pes.id = av.pesquisa_id
and r.avaliacao_id = av.id
and r.pergunta_id = p.id
and r.opcao_id = o.id
and av.id in (select av.id
from avaliacao av, pesquisa pes, resposta r, pergunta p, opcao o
where pes.id = av.pesquisa_id
and r.avaliacao_id = av.id
and r.pergunta_id = p.id
and r.opcao_id = o.id
and p.descricao = 'Sexo'
and o.descricao = 'Masculino')
order by av.id, p.descricao, o.descricao