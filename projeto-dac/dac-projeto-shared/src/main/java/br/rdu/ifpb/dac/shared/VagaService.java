/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rdu.ifpb.dac.shared;

import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Preferencia;
import br.edu.ifpb.dac.shared.entity.Vaga;
import java.util.List;

/**
 *
 * @author laerton
 */
public interface VagaService {

    Vaga criaVaga(Vaga vaga);

    List<Vaga> listAllVagas();

    List<Candidato> listCandidatosByVaga(Vaga vaga);

    List<Vaga> listVagasByPreferencia(Preferencia preferencia);

    List<Vaga> listVagasByPreferencias(List<Preferencia> prferencias);
    
    void editVaga(Vaga vaga);
}
