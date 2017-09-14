/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
;

/**
 *
 * @author jose2
 */
@SessionScoped
public class Mensagem implements Serializable{
      public void addMessage (String id,String massagr) {
        FacesMessage mensagem = new FacesMessage (massagr);
        FacesContext.getCurrentInstance ().addMessage (id, mensagem);
         FacesContext.getCurrentInstance()
                .getExternalContext()
                .getFlash().setKeepMessages(true);
    }
}
