/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.repositorio;

import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Funcionario;
import br.edu.ifpb.dac.shared.entity.FuncionarioType;
import br.edu.ifpb.dac.shared.entity.Usuario;
import br.edu.ifpb.dac.shared.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author laerton
 */
@Stateless
public class UsuarioPersiste {
    @PersistenceContext(unitName =  "DAC_PU")
    protected EntityManager em;
    
    
    public Candidato createCandidato(Candidato obj) {
        
         em.persist(obj);
         return obj;
    }
   
    
    public void editCandidato(Candidato obj) {
        em.merge(obj);
    }
    
    public Funcionario createFuncionario(Funcionario obj) {
        
         em.persist(obj);
         return obj;
    }
   
    
    public void editFuncionario(Funcionario obj) {
        em.merge(obj);
    }
    
    /***
     * Pesquisa por usuários do tipo funcionários de acordo com o seu cargo.
     * @param tipo - Tipo de gargo sendo um enum GERENTE ou AVALAIADOR
     * @return  Lista de resultados com todos os funcioários de acordo com o tipo repassado
     */
    public List<Funcionario> findByCargo(FuncionarioType tipo){
        Query q = em.createQuery("Select f from Funcionario as f where f.cargo =:tipo ");
        q.setParameter("tipo", tipo);
        return q.getResultList();
    }
}
