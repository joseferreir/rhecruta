package br.edu.ifpb.dac.shared.entity;

import br.edu.ifpb.dac.shared.entity.Inscricao;
import br.edu.ifpb.dac.shared.entity.Preferencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-14T12:46:24")
@StaticMetamodel(Vaga.class)
public class Vaga_ { 

    public static volatile ListAttribute<Vaga, Preferencia> preferencias;
    public static volatile SingularAttribute<Vaga, Long> id;
    public static volatile ListAttribute<Vaga, Inscricao> inscritos;
    public static volatile SingularAttribute<Vaga, String> descricao;

}