/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rdu.ifpb.dac.shared;

import br.edu.ifpb.dac.shared.entity.Avaliacao;
import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Funcionario;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author laerton
 */
public interface GerenteService {

    /***
     * Método encarrega de autorizar todos os funcionários com status de pendente e em seguida encaminhar e-mail para todos
     */
    void autorizaAllFuncionarios();

    /***
     * Método encarregado de autorizar todos os candidatos com status de pendente e em seguida encaminhar e-mail para todos
     */
    void autorizaAllcandidatos();

    /***
     * Autoriza um candidato com status de pendente e encaminha e-mail para o mesmo.
     * @param candidato - Candidato a ser autorizado
     */
    void autorizaCandidato(Candidato candidato);

    /***
     * Autoriza um funcionario com status de pendente e encaminha e-mail para o memso
     * @param funcionario - Funcionário que será autorizado.
     */
    void autorizaFuncionario(Funcionario funcionario);

    /***
     * Método edita os dados de um gerente no banco de dados
     */
    void edita();

    /***
     * Retorna todos os candidatos que está com status de pendente de autorização
     * @return Lista de candidatos pendentes
     */
    List<Candidato> getCandidatosPendentes();

    /***
     * Retorna a lista de todos os funcionário com status de pendente de autorização
     * @return Lista de candidatos\
     */
    List<Funcionario> getFuncionariosPendentes();

    Funcionario getGerente();

    /***
     * Grava os dados de um gerente na base de dados.
     * @return Gerente cujo dados foram gravados
     */
    Funcionario grava();

    void setGerente(Funcionario gerente);

    /***
     * Transforma um funcionário em Avaliador
     * @param funcionario - Funcionário que será avaliador
     * @return Funcionário já com status de avaliador
     * @throws java.lang.Exception - Gerente não pode trocar seu prórpio cargo.
     */
    Funcionario transformaAvaliador(Funcionario funcionario) throws Exception;

    /***
     * Transforma um funcionário em um gerente
     * @param funcioario - Funcionário que tera a função modificada
     * @return Funcionário com status de gerente
     */
    Funcionario transformaGerente(Funcionario funcioario);
    /***
     * Método define um funcionário como avaliador de uma avalaiação
     * @param avaliacao - Avaliação a ser definida o avaliador
     * @param avaliador - Funcioário que será avaliador 
     */
    void definirAvaliadorAvaliacao(Avaliacao avaliacao, Funcionario avaliador) throws Exception;
}
