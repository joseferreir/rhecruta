package br.edu.ifpb.dac.shared.entity;

import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Vaga;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-14T12:46:24")
@StaticMetamodel(Inscricao.class)
public class Inscricao_ { 

    public static volatile SingularAttribute<Inscricao, Vaga> vaga;
    public static volatile SingularAttribute<Inscricao, Timestamp> data;
    public static volatile SingularAttribute<Inscricao, Candidato> inscrito;
    public static volatile SingularAttribute<Inscricao, Integer> id;

}