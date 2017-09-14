/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.servicos;


import br.edu.ifpb.dac.core.uteis.ProdutorQueue;
import br.edu.ifpb.dac.core.uteis.Email;
import br.edu.ifpb.dac.core.repositorio.CandidatoPersiste;
import br.edu.ifpb.dac.core.repositorio.GenericPersiste;
import br.edu.ifpb.dac.core.repositorio.PersistePreferencia;
import br.edu.ifpb.dac.core.repositorio.VagaPersiste;
import br.rdu.ifpb.dac.shared.VagaService;
import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Preferencia;
import br.edu.ifpb.dac.shared.entity.Vaga;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;


/**
 *
 * @author laerton
 */
@Stateless
@Remote(VagaService.class)
public class VagaServiceImp implements VagaService {
    @EJB//@Inject
    private GenericPersiste<Vaga> gpVaga;
    @EJB
    private VagaPersiste vagap;
    @EJB//@Inject
    private ProdutorQueue produto;
    @EJB//@Inject
    private CandidatoPersiste candidatop;
    @EJB 
    private PersistePreferencia pp;
    /***
     * Grava os dados de uma vaga no banco de dados
     * @param vaga - Vaga cujos dados serão persistido
     * @return Vaga com os dados persistidos
     */
    @Override
    public Vaga criaVaga(Vaga vaga){
        vaga.setPreferencias(pp.buscaPreferencia(vaga.getPreferencias()));
        vaga = gpVaga.create(vaga);
        enviaEmail(vaga.getPreferencias(), vaga);
        
        return vaga;
    }
    @Override
    public void editVaga(Vaga vaga){
        vaga.setPreferencias(pp.buscaPreferencia(vaga.getPreferencias()));
        gpVaga.edit(vaga);
    }
    
    /***
     * Método envia emalis para os candidatos cadastrados com alguma preferencia que a vaga tenha.
     * @param preferencias Lista de preferências.
     */
    private void enviaEmail(List<Preferencia> preferencias, Vaga vaga ){
        List<Candidato> candidatos = candidatop.findCandidatosByPreferencias(preferencias);
        for (Candidato candidato : candidatos) {
            Email email = new Email("hrecruta.dac@gmail.com", candidato.getEmail(), "Abertura de nova vaga!", 
                    "Abriu uma nova vaga para " + vaga.getDescricao() +", que atende uma das preferências do seu perfil.");
            produto.enviar(email);
        }
    }
    /***
     * Metódo retorna todas as vagas disponíveis
     * @return - Lista de vagas
     */
    @Override
    public List<Vaga> listAllVagas(){
        return gpVaga.findEntities(Vaga.class);
    }
    /***
     * Método retorna uma lista de candidatos inscritos para a vaga
     * @param vaga - Vaga a ser usada como filtro
     * @return - Lista de candidatos
     */
    @Override
    public List<Candidato> listCandidatosByVaga(Vaga vaga){
        return vagap.findByCandidatosForVaga(vaga);
    }
    /***
     * Método retorna uma lista de vagas filtradas por uma preferência.
     * @param preferencia - preferência usada como filtro
     * @return -Lista de vagas
     */
    @Override
    public List<Vaga> listVagasByPreferencia(Preferencia preferencia){
        return vagap.findByPreferencia(preferencia);
    }
    /***
     * Metodo retorna uma lista de vagas baseada em uma lista de preferências repassadas.
     * @param prferencias - Lista de preferências.
     * @return - Lista de vagas.
     */
    @Override
    public List<Vaga> listVagasByPreferencias(List<Preferencia> prferencias){
        return vagap.findByPreferencias(prferencias);
    }
    
    
    
}
