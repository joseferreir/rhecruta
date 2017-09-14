/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rdu.ifpb.dac.shared;

import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Funcionario;
import br.edu.ifpb.dac.shared.entity.Usuario;



/**
 *
 * @author laerton
 */

public interface UsuarioService {

    
    /***
     * Método grava os dados de um usuário e encaminha e-mail para todos os gerentes aguardando a confirmação da lieração.
     * @param user - Usuário do tipo candidato.
     */
    void gravar (Usuario user);
    
    
}
