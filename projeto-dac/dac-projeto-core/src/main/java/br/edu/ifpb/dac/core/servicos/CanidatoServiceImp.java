/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.servicos;

import br.edu.ifpb.dac.core.repositorio.AvalicaoPersiste;
import br.edu.ifpb.dac.core.repositorio.CandidatoPersiste;
import br.rdu.ifpb.dac.shared.CandidatoService;
import br.edu.ifpb.dac.core.repositorio.GenericPersiste;
import br.edu.ifpb.dac.core.repositorio.PersistePreferencia;
import br.edu.ifpb.dac.core.repositorio.VagaPersiste;
import br.edu.ifpb.dac.shared.entity.Avaliacao;
import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Inscricao;
import br.edu.ifpb.dac.shared.entity.Preferencia;
import br.edu.ifpb.dac.shared.entity.Vaga;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;


/**
 * Classe de serviço de um candidato 
 * @author laerton
 */
@Stateless
@Remote(CandidatoService.class)
public class CanidatoServiceImp implements CandidatoService{
    //@Inject
    @EJB
    private GenericPersiste<Candidato> gpCandidato;
    @EJB//@Inject
    private GenericPersiste<Inscricao> gpInscricao;
    @EJB//@Inject
    private VagaPersiste vagap;
    @EJB//@Inject
    private CandidatoPersiste candidatop;
    @EJB//@Inject
    private AvalicaoPersiste avaliacaop;
    private Candidato candidato;
    @EJB 
    private PersistePreferencia pp; 

    @Override
    public Candidato getCandidato() {
        return candidato;
    }

    @Override
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    /***
     * Método edita dados de um candiato
     * @param candidato 
     */
    @Override
    public void edit(){
        candidato.setPreferencias(pp.buscaPreferencia(candidato.getPreferencias()));
        gpCandidato.edit(candidato);
    }
    /***
     * Metodo remove um candidato da base de dados.
     * 
     */
    
    @Override
    public void destroy (){
        gpCandidato.destroy(Candidato.class, candidato.getId());
    }
    
    /***
     * Método inscre um candidato a uma vaga
     * @param vaga - Vaga que o candidato pretende concorrer
     * 
     */
    @Override
    public void inscreverVaga(Vaga vaga){
        Inscricao inscricao = new Inscricao(vaga, Timestamp.valueOf(LocalDateTime.now()));
        inscricao.setInscrito(candidato);
        gpInscricao.create(inscricao);
    }
    /***
     * Método buscas todas as vagas disponíveia a partir de uma preferencia.
     * @param preferencia - Preferencia a ser usada como busca,
     * @return  - Lista de vagas
     */
    @Override
    public List<Vaga> findByVagaForPreferencia(Preferencia preferencia){
        return vagap.findByPreferencia(preferencia);
    }
    
    /***
     * Método lista todas as vagas a partir de uma lista de preferências repassadas como argumento de entrada.
     * @param preferencias - Lista de preferências.
     * @return - Lista de vagas disponíveis.
     */
    @Override
    public List<Vaga> findByVagasForPreferencias(List<Preferencia> preferencias){
        return vagap.findByPreferencias(preferencias);
    }
    
    /***
     * Método buscas por candidatos que atenda em seu perfil a preferencia repassada no argumento de entrada.
     * @param preferencia - preferência a ser pesquisada.
     * @return Lista de candidatos
     */
    @Override
    public List<Candidato> findByCandidatosByPreferencia(Preferencia preferencia){
        return candidatop.findCandidatoByPreferencia(preferencia);
    }
    
    /***
     * Método busca por candidatos que atenda em seu perfil a pelo menosuma preferência repassada na lista de preferências.
     * @param preferencias - Lista de preferências repassadas 
     * @return Lista de candidatos
     */
    @Override
    public List<Candidato> findByCandidatosByPreferencias(List<Preferencia> preferencias){
        return candidatop.findCandidatosByPreferencias(preferencias);
    }
    
    /***
     * Método busca por todas as avaliações agendadas para um candidato
     * @param candidato - Candidato usado como filtro
     * @return - Lista de avaliações.
     */
    @Override
    public List<Avaliacao> findByAvaliacaoByCandidato(Candidato candidato){
        return avaliacaop.findAllAvaliacaoByCandidato(candidato);
    }
    
   
    
}
