/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.servicos;


import br.edu.ifpb.dac.core.repositorio.AvalicaoPersiste;
import br.edu.ifpb.dac.core.uteis.ProdutorQueue;
import br.edu.ifpb.dac.core.uteis.Email;
import br.rdu.ifpb.dac.shared.GerenteService;
import br.edu.ifpb.dac.core.repositorio.FuncionarioGerentePersiste;
import br.edu.ifpb.dac.core.repositorio.GenericPersiste;
import br.edu.ifpb.dac.shared.entity.Avaliacao;
import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Funcionario;
import br.edu.ifpb.dac.shared.entity.FuncionarioType;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;
import java.util.SimpleTimeZone;
import javafx.scene.input.DataFormat;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;


/**
 * Classe de serviços de um funcionário do tipo gerente
 * @author laerton
 */
@Stateless
@Remote(GerenteService.class)
public class GerenteServiceImp implements GerenteService  {
    
    @EJB//@Inject 
    private FuncionarioGerentePersiste fgp;
    @EJB//@Inject
    private GenericPersiste<Funcionario> gpFuncionario;
    @EJB//@Inject
    private GenericPersiste<Candidato> gpCandidato;
    @EJB
    private GenericPersiste<Avaliacao> gpAvaliacao;
    @EJB
    private AvalicaoPersiste avaliacaop;
    @EJB//@Inject
    private ProdutorQueue prouto;
    private final String email =   "hrecruta.dac@gmail.com";
    private Funcionario gerente;

    
    
    @Override
    public Funcionario getGerente() {
        return gerente;
    }

    
    @Override
    public void setGerente(Funcionario gerente) {
        this.gerente = gerente;
    }
    
    /***
     * Grava os dados de um gerente na base de dados.
     * @return Gerente cujo dados foram gravados
     */
    
    @Override
    public Funcionario grava (){
        return gpFuncionario.create(gerente);
    }
    
    /***
     * Transforma um funcionário em um gerente
     * @param funcioario - Funcionário que tera a função modificada
     * @return Funcionário com status de gerente
     */
    
    @Override
    public Funcionario transformaGerente(Funcionario funcioario){
        funcioario.setCargo(FuncionarioType.GERENTE);
        gpFuncionario.edit(funcioario);
        return funcioario;
    }
    /***
     * Transforma um funcionário em Avaliador
     * @param funcionario - Funcionário que será avaliador
     * @return Funcionário já com status de avaliador
     * @throws java.lang.Exception - Gerente não pode trocar seu próprio cargo
     */
    
    @Override
    public Funcionario transformaAvaliador(Funcionario funcionario) throws Exception{
        if(this.gerente.equals(funcionario))throw  new Exception("O gerente não pode mudar seu próprio cargo.");
        funcionario.setCargo(FuncionarioType.AVALIADOR);
        gpFuncionario.edit(funcionario);
        return funcionario;
    }
    /***
     * Método edita os dados de um gerente no banco de dados
     */
    
    @Override
    public void edita(){
        gpFuncionario.edit(gerente);
    }
    
    /***
     * Retorna todos os candidatos que está com status de pendente de autorização
     * @return Lista de candidatos pendentes
     */
    
    @Override
    public List<Candidato> getCandidatosPendentes(){
        return   fgp.finbyCandidatosPendentes();
    }
    
    /***
     * Retorna a lista de todos os funcionário com status de pendente de autorização
     * @return Lista de candidatos\
     */
    
    @Override
    public List<Funcionario> getFuncionariosPendentes(){
        return  fgp.finbyFuncionarioPendentes();
    }
    /***
     * Método encarrega de autorizar todos os funcionários com status de pendente e em seguida encaminhar e-mail para todos
     */
    
    @Override
    public void autorizaAllFuncionarios(){
        List<Funcionario> lista = getFuncionariosPendentes();
        for (Funcionario funcionario : lista) {
            autorizaFuncionario(funcionario);
        }
    }
    /***
     * Método encarregado de autorizar todos os candidatos com status de pendente e em seguida encaminhar e-mail para todos 
     */
    
    @Override
    public void autorizaAllcandidatos(){
        List<Candidato> lista = getCandidatosPendentes();
        for (Candidato candidato : lista) {
            autorizaCandidato(candidato);
        }
    }
    
    /***
     * Autoriza um candidato com status de pendente e encaminha e-mail para o mesmo.
     * @param candidato - Candidato a ser autorizado
     */
    
    @Override
    public void autorizaCandidato(Candidato candidato){
            
            candidato.setAutorizado(true);
            gpCandidato.edit(candidato);
            Email email = new Email(this.email, candidato.getEmail(), "Confirmação de autorização.", "Seu cadastro foi autorizado.");
            prouto.enviar(email);
    }
    
    /***
     * Autoriza um funcionario com status de pendente e encaminha e-mail para o memso
     * @param funcionario - Funcionário que será autorizado.
     */
    
    @Override
    public void autorizaFuncionario(Funcionario funcionario){
            funcionario.setAutorizado(true);
            gpFuncionario.edit(funcionario);
            Email email = new Email(this.email, funcionario.getEmail(), "Confirmação de autorização.", "Seu cadastro foi autorizado.");
            prouto.enviar(email);
    }
    /***
     * Método define um funcionário como avaliador de uma avalaiação
     * @param avaliacao - Avaliação a ser definida o avaliador
     * @param avaliador - Funcioário que será avaliador 
     * @throws java.lang.Exception - Gerente atual não poder ser avaliador, e não pode conter outra avaliação na mesma data e horário da nova avaliação.
     */
    @Override
    public void definirAvaliadorAvaliacao(Avaliacao avaliacao, Funcionario avaliador) throws Exception{
        if (this.gerente.equals(avaliador))throw  new Exception("Gerente atual não pode ser avaliador");
        if (!validaDataAvalicaoAvaliador(avaliador, avaliacao))throw  new Exception("Avaliador tem choque de horáio com outra avaliação.");
        if(avaliador.getCargo()== FuncionarioType.GERENTE){
            this.transformaAvaliador(avaliador);
        }
        avaliacao.setAvaliador(avaliador);
        gpAvaliacao.edit(avaliacao);
    }
    
    /***
     * Verifica se existe se a data da avaliação já esta agendada para esse avaliador por outra avaliação
     * @param avaliador - Avaliador a ser pesquisado
     * @param avaliacao - Nova Avaliação
     * @return True para data livre e False para data e horario ocupado.
     */
    private boolean validaDataAvalicaoAvaliador(Funcionario avaliador, Avaliacao avaliacao){
        List<Avaliacao> avaliacoes = avaliacaop.findAllAvaliacaoByAvaliador(avaliador);
        //LocalDate data = LocalDate.of(avaliacao.getHoraio().getYear(), avaliacao.getHoraio().getMonth(), avaliacao.getHoraio().getDay());
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy HH:mm");
        String dataHora = format.format(avaliacao.getHoraio().getTime());
        
        for (Avaliacao item : avaliacoes) {
            String dataItem = format.format(item.getHoraio().getTime());
            if (dataItem.equals(dataHora)) return false;
        }
        return true;
    }
    
    
}
