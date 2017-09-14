/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.servicos;

import br.rdu.ifpb.dac.shared.PreferenciaService;
import br.edu.ifpb.dac.core.repositorio.GenericPersiste;
import br.edu.ifpb.dac.shared.entity.Preferencia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Classe encarregado das regras de serviço da entidade preferencia.
 * @author laerton
 */
@Stateless
@Remote(PreferenciaService.class)
public class PreferenciaServiceImp implements PreferenciaService {
    @EJB//@Inject
    private GenericPersiste<Preferencia> gpPreferencia;
    
    
    /***
     * Lista todas as preferências já cadastradas no banco
     * @return Lista de preferenicas cadastradas.
     */
    @Override
    public List<Preferencia> listAll (){
        return gpPreferencia.findEntities(Preferencia.class);
    }
    
}
