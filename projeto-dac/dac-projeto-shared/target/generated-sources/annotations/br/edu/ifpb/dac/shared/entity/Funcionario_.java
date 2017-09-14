package br.edu.ifpb.dac.shared.entity;

import br.edu.ifpb.dac.shared.entity.Avaliacao;
import br.edu.ifpb.dac.shared.entity.FuncionarioType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-14T12:46:24")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ extends Usuario_ {

    public static volatile ListAttribute<Funcionario, Avaliacao> avaliacoes;
    public static volatile SingularAttribute<Funcionario, FuncionarioType> cargo;

}