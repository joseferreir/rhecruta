package br.edu.ifpb.dac.shared.entity;

import br.edu.ifpb.dac.shared.entity.Funcionario;
import br.edu.ifpb.dac.shared.entity.Inscricao;
import br.edu.ifpb.dac.shared.entity.StatusAvaliacao;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-14T10:01:14")
@StaticMetamodel(Avaliacao.class)
public class Avaliacao_ { 

    public static volatile SingularAttribute<Avaliacao, Inscricao> inscricao;
    public static volatile SingularAttribute<Avaliacao, Timestamp> horaio;
    public static volatile SingularAttribute<Avaliacao, Funcionario> avaliador;
    public static volatile SingularAttribute<Avaliacao, Integer> id;
    public static volatile SingularAttribute<Avaliacao, Double> nota;
    public static volatile SingularAttribute<Avaliacao, StatusAvaliacao> status;

}