/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.repositorio;

import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Preferencia;
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
public class CandidatoPersiste {
    @PersistenceContext(unitName =  "DAC_PU")
    protected EntityManager em;
    
    /***
     * Método busca todos os canidatos que tenha perfil que atenda uma preferncia repassada.
     * @param preferencia - Preferência usada como argumento de busca.
     * @return Lista de candidatos
     */
    public List<Candidato> findCandidatoByPreferencia(Preferencia preferencia){
        Query q = em.createQuery("Select c from Candidato as c LEFT JOIN c.preferencias as p where p.preferencia =:preferencia ");
        q.setParameter("preferencia", preferencia.getPreferencia());
        return q.getResultList();
    }
    /***
     * Método busca por candidatos que atenda a uma das preferencias repassadas na lista de preferencias.
     * @param preferencias - Lista de preferencias.
     * @return Lista de candidatos
     */
    public List<Candidato> findCandidatosByPreferencias(List<Preferencia> preferencias){
        List<Candidato>  candidatos = new LinkedList<>();
        for (Preferencia preferencia : preferencias) {
            candidatos.addAll(findCandidatoByPreferencia(preferencia));
        }
        return candidatos;
                
    }
}
