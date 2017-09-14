/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rdu.ifpb.dac.shared;

import br.edu.ifpb.dac.shared.entity.Preferencia;
import java.util.List;

/**
 *
 * @author laerton
 */
public interface PreferenciaService {

    /***
     * Lista todas as preferências já cadastradas no banco
     * @return Lista de preferenicas cadastradas.
     */
    List<Preferencia> listAll();
    
}
