/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import br.edu.ifpb.dac.core.repositorio.FuncionarioGerentePersiste;
import br.edu.ifpb.dac.core.repositorio.GenericPersiste;
import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Funcionario;
import br.edu.ifpb.dac.shared.entity.Inscricao;
import br.edu.ifpb.dac.shared.entity.Preferencia;
import br.edu.ifpb.dac.shared.entity.Vaga;
import br.rdu.ifpb.dac.shared.CandidatoService;
import br.rdu.ifpb.dac.shared.GerenteService;
import br.rdu.ifpb.dac.shared.UsuarioService;
import br.rdu.ifpb.dac.shared.VagaService;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;




/**
 *
 * @author jose2
 */
@Named
@SessionScoped
public class ControleTest implements Serializable{
    @EJB
    private UsuarioService usuarioService;
    @EJB
    private GenericPersiste<Funcionario> gPersiste;
    @EJB 
    private GerenteService gerenteS;
    @EJB 
    private FuncionarioGerentePersiste fgp;
    @EJB
    private GenericPersiste<Candidato> gpCandidato;
    @EJB
    private GerenteService gerente;
    @EJB
    private GenericPersiste<Vaga> gpVaga;
    @EJB
    private VagaService vagaS;
    @EJB
    private CandidatoService cs;
    private Candidato c1, c2;
    private Vaga vaga, vaga2;
    //private Service<Funcionario> repositorio;
    public String add(){
      criaCandidato();
      criaVaga();
      c1.addInscricao(new Inscricao(vaga, Timestamp.valueOf(LocalDateTime.now())));
      c2.addInscricao(new Inscricao(vaga, Timestamp.valueOf(LocalDateTime.now())));
      c1.addInscricao(new Inscricao(vaga2, Timestamp.valueOf(LocalDateTime.now())));
      c2.addInscricao(new Inscricao(vaga2, Timestamp.valueOf(LocalDateTime.now())));
      cs.setCandidato(c1);
      cs.edit();
      cs.setCandidato(c2);
      cs.edit();
      return null;
    }
    
    private void criaVaga(){
      
        vaga = new Vaga("Vaga para criacao de site");
        vaga.addPreferencia(new Preferencia("C#"));
        vaga2 = new Vaga("Vaga para criacao de site dinamicos");
        vaga2.addPreferencia(new Preferencia("HTML"));
        vaga2.addPreferencia(new Preferencia("ASP"));
        vaga2.addPreferencia(new Preferencia("JavaScript"));
        vagaS.criaVaga(vaga);
        vagaS.criaVaga(vaga2);
        
        
    }
    
    private void criaCandidato(){
        c1 = new Candidato(0, "ksdhfhsdgh", "laerton281003@hotmail.com", "sdhfkja", "Laerton Marques");
        
        c2 = new Candidato(0, "ksdhfhsdgh", "laerton281003@hotmail.com", "sdhfkja", "Laerton Marques");
        gpCandidato.create(c1);
        gpCandidato.create(c2);
        
        c1.addPreferencia(new Preferencia("ASP"));
        c2.addPreferencia(new Preferencia("C#"));
        
        cs.setCandidato(c1);
        cs.edit();
        
        cs.setCandidato(c2);
        cs.edit();
        
    }
    
}
