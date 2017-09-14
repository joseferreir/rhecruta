/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rdu.ifpb.rhecruta.web.cdi;


import br.rdu.ifpb.dac.shared.UsuarioService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author jose2
 */

@ApplicationScoped
public class UserServiceProducer {
    
    
//    java:global/rhecruta-core/UserServiceImpl!br.edu.ifpb.dac.rhecruta.shared.interfaces.UserService, java:global/rhecruta-core/UserServiceImpl
    private static final String RESOURCE = "java:global/dac-projeto-core/UsuarioServiceImp!br.rdu.ifpb.dac.shared.UsuarioService";
     
    
    @Dependent
    @Produces
    @Default
    private UsuarioService getUserService() {
        return new ServiceLocator().lookup(RESOURCE, UsuarioService.class);
    }
}
