package br.edu.ifpb.dac.shared.entity;

import br.edu.ifpb.dac.shared.entity.Inscricao;
import br.edu.ifpb.dac.shared.entity.Preferencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-14T12:46:24")
@StaticMetamodel(Candidato.class)
public class Candidato_ extends Usuario_ {

    public static volatile ListAttribute<Candidato, Preferencia> preferencias;
    public static volatile ListAttribute<Candidato, Inscricao> inscricoes;
    public static volatile SingularAttribute<Candidato, String> curriculo;
    public static volatile SingularAttribute<Candidato, Double> nota;

}