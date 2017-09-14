/**
 * This file was generated by the JPA Modeler
 */ 

package br.edu.ifpb.dac.shared.entity;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * @author Laerton_note
 * Classe de entidade de uma avaliação
 */

@Entity

public class Avaliacao implements Serializable { 
    
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Timestamp horaio;
    
    @OneToOne
    private Inscricao inscricao;
    
    private double nota;
    
    @Enumerated(EnumType.ORDINAL)
    @Embedded
    private StatusAvaliacao status = StatusAvaliacao.AREALIZAR;

    @ManyToOne(targetEntity = Funcionario.class)
    @NotNull(message="É obrigatório informar o funcionário avaliador.")
    private Funcionario avaliador;

    
    
    /***
     * Cria uma abalição vazia.
     */
    public Avaliacao() 
    {
        
    }

    public Avaliacao(Timestamp horaio, Inscricao inscricao, Funcionario avaliador) {
        this.horaio = horaio;
        this.inscricao = inscricao;
        this.avaliador = avaliador;
    }
    
    
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public StatusAvaliacao getStatus() {
        return status;
    }

    public void setStatus(StatusAvaliacao status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }


    
    public Timestamp getHoraio() {
        return this.horaio;
    }

    public void setHoraio(Timestamp horaio) {
        this.horaio = horaio;
    }


    public Funcionario getAvaliador() {
        return this.avaliador;
    }

    public void setAvaliador(Funcionario avaliador) {
        this.avaliador = avaliador;
    }

    


}
