/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rdu.ifpb.dac.shared;

import br.edu.ifpb.dac.shared.entity.Avaliacao;
import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Preferencia;
import br.edu.ifpb.dac.shared.entity.Vaga;
import java.util.List;

/**
 *
 * @author laerton
 */
public interface CandidatoService {

    /***
     * Metodo remove um candidato da base de dados.
     *
     */
    void destroy();

    /***
     * Método edita dados de um candiato
     * @param candidato
     */
    void edit();

    Candidato getCandidato();

    /***
     * Método inscre um candidato a uma vaga
     * @param vaga - Vaga que o candidato pretende concorrer
     *
     */
    void inscreverVaga(Vaga vaga);

    void setCandidato(Candidato candidato);
    List<Vaga> findByVagaForPreferencia(Preferencia preferencia);
    List<Vaga> findByVagasForPreferencias(List<Preferencia> preferencias);
    List<Candidato> findByCandidatosByPreferencia(Preferencia preferencia);
    List<Candidato> findByCandidatosByPreferencias(List<Preferencia> preferencias);
    List<Avaliacao> findByAvaliacaoByCandidato(Candidato candidato);
}
