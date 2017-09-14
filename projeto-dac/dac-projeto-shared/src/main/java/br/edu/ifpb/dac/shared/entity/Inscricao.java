/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.shared.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author laerton
 */
@Entity
public class Inscricao implements Serializable{
    
    @ManyToOne()
    @JoinColumn(name = "candidato_id")
    private Candidato inscrito;
    @ManyToOne(targetEntity = Vaga.class)
    private Vaga vaga;
    
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   
    private Timestamp data;

    public Inscricao( Vaga vaga, Timestamp data) {
        //this.inscrito = candidato;
        this.vaga = vaga;
        this.data = data;
    }

    
    public Inscricao() {
    }

    
    public Candidato getInscrito() {
        return inscrito;
    }

    public void setInscrito(Candidato inscrito) {
        this.inscrito = inscrito;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscricao other = (Inscricao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
    
}
