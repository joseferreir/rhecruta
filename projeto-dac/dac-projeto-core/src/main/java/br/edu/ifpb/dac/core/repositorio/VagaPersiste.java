/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.repositorio;

import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Preferencia;
import br.edu.ifpb.dac.shared.entity.Vaga;
import java.util.LinkedList;
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
public class VagaPersiste {
    
    @PersistenceContext(unitName =  "DAC_PU")
    protected EntityManager em;
    
    /***
     * Método busca todas as vagas que houver referência a preferencia repassada.
     * @param preferencia - Preferencia a ser usada na busca
     * @return Lista de vagas encontradas
     */
    public List<Vaga> findByPreferencia(Preferencia preferencia) {
        Query q = em.createQuery("Select v from Vaga as v LEFT JOIN v.preferencias as p where p.preferencia =:preferencia ");
        q.setParameter("preferencia", preferencia.getPreferencia());
        return q.getResultList();
    }
    
    /***
     * Busca vagas disponíveis a partid e uma lista de preferencias repassadas.
     * @param preferencias - Lista de preferencias a ser usada.
     * @return Retorna uma lista de vagas encontradas.
     */
    public List<Vaga> findByPreferencias(List<Preferencia> preferencias){
        List<Vaga> retorno = new LinkedList<>();
        for (Preferencia preferencia : preferencias) {
            retorno.addAll(findByPreferencia(preferencia));
        }
        return  retorno;
    }
    
    /***
     * Lista todos os candidatos inscritos em uma vaga
     * @param vaga - Vaga para argumento de busca
     * @return - Lista de candidatos
     */
    public List<Candidato> findByCandidatosForVaga(Vaga vaga){
        Query q = em.createQuery("Select c from Candidato as c LEFT JOIN c.inscricoes as i where i.vaga =:vaga ");
        q.setParameter("vaga", vaga);
        return q.getResultList();
    }
}
