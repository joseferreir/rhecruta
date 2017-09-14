/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.repositorio;

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
public class PersistePreferencia {
    @PersistenceContext(unitName =  "DAC_PU")
    protected EntityManager em;
    
    public Preferencia findPreferencia(String Descricao){
        Preferencia resultado = null;
        Query q = em.createQuery("Select f from Preferencia as f where f.preferencia=:descricao ", Preferencia.class);
        q.setParameter("descricao", Descricao);
        try {
            resultado =  (Preferencia) q.getSingleResult();
        } catch (Exception e) {
            return  null;
        }
        return resultado;
    }
    
    public List<Preferencia> buscaPreferencia(List<Preferencia> preferencias){
        List<Preferencia> lista = new LinkedList<>();
        
        for (Preferencia preferencia : preferencias) {
            Preferencia p = this.findPreferencia(preferencia.getPreferencia());
            if (p == null){
                em.persist(preferencia);
                lista.add(preferencia);
            }else{
                lista.add(p);
            }
        }
        return lista;
    }
}

