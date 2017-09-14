/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.repositorio;

import br.edu.ifpb.dac.shared.entity.Avaliacao;
import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Funcionario;
import br.edu.ifpb.dac.shared.entity.Inscricao;
import br.edu.ifpb.dac.shared.entity.Vaga;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author laerton
 */
@Stateless
public class AvalicaoPersiste {
    @PersistenceContext(unitName =  "DAC_PU")
    protected EntityManager em;
    /***
     * Método busca avaliação a partir da inscrição.
     * @param inscricao - Inscrição usada como paramentro
     * @return Avaliação localizada
     */
    public Avaliacao findAvaliacaoByInscricao(Inscricao inscricao) {
        Query q =  em.createQuery("Select p from Avaliacao as p where p.inscricao =:inscricao", Avaliacao.class);
        q.setParameter("inscricao", inscricao);
        return (Avaliacao) q.getSingleResult();
    }
    
    /***
     * Método busca todas as avaliações agendadas para um candidato
     * @param candidato - Candidato usado como filtro
     * @return Lista de avaliações
     */
    public List<Avaliacao> findAllAvaliacaoByCandidato(Candidato candidato){
        Query q =  em.createQuery("Select p from Avaliacao as p where p.inscricao.inscrito.id =:id", Avaliacao.class);
        q.setParameter("id", candidato.getId());
        return q.getResultList();
    }
    
    /***
     * Método busca todas as avaliação agendadas filtradas por uma vaga
     * @param vaga - Vaga usada como filtro
     * @return  - Lista de avaliações
     */
    public List<Avaliacao> findAllAvaliacaoByVaga(Vaga vaga){
        Query q =  em.createQuery("Select p from Avaliacao as p where p.inscricao.vaga =:vaga", Avaliacao.class);
        q.setParameter("vaga", vaga);
        return q.getResultList();
    }
    /***
     * Método encarregado de buscar por todos as avaliações encontradas para um avaliador
     * @param funcionario - Funcionario avaliador
     * @return - Lista de avaliações 
     */
    public List<Avaliacao> findAllAvaliacaoByAvaliador(Funcionario funcionario){
        Query q =  em.createQuery("Select p from Avaliacao as p where p.avaliador =:avaliador", Avaliacao.class);
        q.setParameter("avaliador", funcionario);
        return q.getResultList();
    }
}
