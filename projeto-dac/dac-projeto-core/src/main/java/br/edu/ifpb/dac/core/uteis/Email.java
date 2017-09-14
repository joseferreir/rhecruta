/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.uteis;

import java.io.Serializable;

/**
 *
 * @author laerton
 */
public class Email implements Serializable{
    private String remetente, destinatario, titulo, corpo;

    public Email(String remetente, String destinatario, String titulo, String corpo) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.titulo = titulo;
        this.corpo = corpo;
    }
    
    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }
    
}
