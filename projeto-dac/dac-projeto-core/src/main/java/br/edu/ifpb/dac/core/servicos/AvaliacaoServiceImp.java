/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.servicos;


import br.rdu.ifpb.dac.shared.AvaliacaoSercice;
import br.edu.ifpb.dac.core.repositorio.AvalicaoPersiste;
import br.edu.ifpb.dac.core.repositorio.GenericPersiste;
import br.edu.ifpb.dac.core.uteis.Email;
import br.edu.ifpb.dac.core.uteis.ProdutorQueue;
import br.edu.ifpb.dac.shared.entity.Avaliacao;
import br.edu.ifpb.dac.shared.entity.Funcionario;
import br.edu.ifpb.dac.shared.entity.Inscricao;
import br.edu.ifpb.dac.shared.entity.Vaga;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author laerton
 */
@Stateless
@Remote(AvaliacaoSercice.class)
public class AvaliacaoServiceImp implements AvaliacaoSercice 
{
    //@Inject
    @EJB
    private GenericPersiste<Avaliacao> gpAvaliacao;
    //@Inject 
    @EJB
    private AvalicaoPersiste avaliacaop;
    //@Inject
    @EJB
    private ProdutorQueue produto;
    /***
     * Método registra os dados de uma avaliação no banco de dados, enviando um e-mail para o candidato inscrito na avaliação
     * @param avalicao - Avaliação que será gravada no banco de dados
     * @return Avaliação após persistencia.
     */
    @Override
    public Avaliacao agendaAvaliacao(Avaliacao avalicao){
        avalicao = gpAvaliacao.create(avalicao);
        enviaEmail(avalicao);
        return avalicao;
    }
    /***
     * Método edita dados de avaliação de um candidato e encaminha um e-mail para o candidato.
     * @param avaliacao - Avaliação usada como filtro
     */
    @Override
    public void edita(Avaliacao avaliacao){
        gpAvaliacao.edit(avaliacao);
        enviaEmailNotifica(avaliacao);
    }
    
    /***
     * Método envia um e-mail para o candidato da avaliação
     * @param avalicao - Avaliação que terá o candidato cujo email será enviado
     */
    private void enviaEmail(Avaliacao avalicao) {
        Email email = new Email("hrecruta.dac@gmail.com", avalicao.getInscricao().getInscrito().getEmail(), "Agendamento de avaliação" ,
            String.format("Sua avaliação foi agendada para o dia s% de s% de s%, as s%hs%, favor verifique em seu calendario se há choque de horários."
            , avalicao.getHoraio().getDay(), avalicao.getHoraio().getMonth(), avalicao.getHoraio().getYear(), 
            avalicao.getHoraio().getHours(), avalicao.getHoraio().getMinutes()));
    }
    
    /***
     * Busca por uma avaliação baseada em uma inscrição
     * @param inscricao - Inscrição usada como filtro
     * @return Avaliação localizada
     */
    @Override
    public Avaliacao findAvaliacaoByInscricao (Inscricao inscricao){
        return avaliacaop.findAvaliacaoByInscricao(inscricao);
    }
    
    /***
     * Método buscas por todas as avaliações vinculadas a uma vaga.
     * @param vaga - Vaga usada como filtro
     * @return Lista de avaliações.
     */
    @Override
    public List<Avaliacao> findAvaliacaoByVaga(Vaga vaga){
        return avaliacaop.findAllAvaliacaoByVaga(vaga);
    }

    /***
     * Método envia um e-mail de notificação.
     * @param avaliacao - Avaliação com os dados para notificação.
     */
    private void enviaEmailNotifica(Avaliacao avaliacao) {
        Email email = new Email("hrecruta.dac@gmail.com", avaliacao.getInscricao().getInscrito().getEmail(), "Modificações em sua avaliação" ,
            String.format("Existem alterações na sua avaliação da vaga s%.", avaliacao.getInscricao().getVaga().getDescricao()));
    }
    /***
     * Método retorna uma lista de avaliações vinculadas a uma avaliador
     * @param avaliador - Avaliador usado como filtro
     * @return - Lista de avaliações
     */
    @Override
    public List<Avaliacao> findByAvaliacaoByAvaliador(Funcionario avaliador){
        return avaliacaop.findAllAvaliacaoByAvaliador(avaliador);
    }
    
    
    
}
