/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.repositorio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author laerton
 */
@Stateless
public class FuncionarioAvaliadorPersiste {
    @PersistenceContext(unitName =  "DAC_PU")
    protected EntityManager em;
    
    

}
