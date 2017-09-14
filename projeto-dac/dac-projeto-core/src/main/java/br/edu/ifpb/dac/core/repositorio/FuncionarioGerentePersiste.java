/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.repositorio;

import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Funcionario;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Classe encarregado de processo de acesso a dados específicos de um Gerente
 * @author laerton
 */
@Stateless
public class FuncionarioGerentePersiste {
    
    @PersistenceContext(unitName =  "DAC_PU")
    protected EntityManager em;
    
    
    /***
     * Busca por dados de Candidatos com autorização pendente
     * @return Lista de candidatos pendentes
     */
    public List<Candidato> finbyCandidatosPendentes() {
        Query resposta = em.createQuery("Select e from Candidato as e WHERE e.autorizado = FALSE",Candidato.class);
        return resposta.getResultList();
    }
    
    /***
     * Busca por uma lista de Funcionários com autorização pendente.
     * @return Lista de funcionários
     */
    public List<Funcionario> finbyFuncionarioPendentes(){
        Query q = em.createQuery("Select f from Funcionario as f where f.autorizado = FALSE", Funcionario.class);
        return  q.getResultList();
    }
    
    
    
    
}
