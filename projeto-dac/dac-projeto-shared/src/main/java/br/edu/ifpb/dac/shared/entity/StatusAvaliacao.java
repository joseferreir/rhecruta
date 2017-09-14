/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.shared.entity;

import javax.persistence.Embeddable;


/**
 *
 * @author laerton
 */
@Embeddable
public enum StatusAvaliacao {
   
    AREALIZAR(0), REALIZADA (1),CANCELADA (2), ADIADA (3);
    private final int valor;
    
    StatusAvaliacao(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return this.valor;
    }
    

}
