/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rdu.ifpb.dac.shared;

import br.edu.ifpb.dac.shared.entity.Avaliacao;
import br.edu.ifpb.dac.shared.entity.Funcionario;
import br.edu.ifpb.dac.shared.entity.Inscricao;
import br.edu.ifpb.dac.shared.entity.Vaga;
import java.util.List;

/**
 *
 * @author laerton
 */
public interface AvaliacaoSercice {

    /***
     * Método registra os dados de uma avaliação no banco de dados, enviando um e-mail para o candidato inscrito na avaliação
     * @param avalicao - Avaliação que será gravada no banco de dados
     * @return Avaliação após persistencia.
     */
    Avaliacao agendaAvaliacao(Avaliacao avalicao);

    /***
     * Método edita dados de avaliação de um candidato e encaminha um e-mail para o candidato.
     * @param avaliacao - Avaliação usada como filtro
     */
    void edita(Avaliacao avaliacao);

    /***
     * Busca por uma avaliação baseada em uma inscrição
     * @param inscricao - Inscrição usada como filtro
     * @return Avaliação localizada
     */
    Avaliacao findAvaliacaoByInscricao(Inscricao inscricao);

    /***
     * Método buscas por todas as avaliações vinculadas a uma vaga.
     * @param vaga - Vaga usada como filtro
     * @return Lista de avaliações.
     */
    List<Avaliacao> findAvaliacaoByVaga(Vaga vaga);
    
    /***
     * Método retorna uma lista de avaliações vinculadas a uma avaliador
     * @param avaliador - Avaliador usado como filtro
     * @return - Lista de avaliações
     */
    List<Avaliacao> findByAvaliacaoByAvaliador(Funcionario avaliador);
    
}
