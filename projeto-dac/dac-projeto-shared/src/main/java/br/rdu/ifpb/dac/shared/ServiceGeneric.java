/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rdu.ifpb.dac.shared;

import br.edu.ifpb.dac.shared.exceptions.NonexistentEntityException;
import java.util.List;
import javax.ejb.Remote;
import static org.eclipse.persistence.sessions.SessionProfiler.Remote;

/**
 *
 * @author jose2
 */
//@Remote(ServiceGeneric.class)
public interface ServiceGeneric<E> {

    E create(E obj);

    void destroy(Class<E> classe, Long id);

    void edit(E obj);

    E findEntity( Class<E> classe, Long id) throws NonexistentEntityException;

    List<E> findEntities  (Class<E> classe);

    List<E> findEntities(Class<E> classe, int maxResults, int firstResult);

    int getEntityCount(Class<E> classe);
}
