/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.shared.entity;

/**
 *
 * @author laerton
 */
public enum FuncionarioType {
    GERENTE(0), AVALIADOR(1);
    private int valor;

    private FuncionarioType(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
    
}
