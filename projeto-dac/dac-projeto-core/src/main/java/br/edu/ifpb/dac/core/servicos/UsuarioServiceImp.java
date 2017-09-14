/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.servicos;

import br.edu.ifpb.dac.core.uteis.ProdutorQueue;
import br.edu.ifpb.dac.core.uteis.Email;
import br.edu.ifpb.dac.core.repositorio.GenericPersiste;
import br.edu.ifpb.dac.core.repositorio.UsuarioPersiste;
import br.edu.ifpb.dac.core.uteis.JavaMailClass;
import br.edu.ifpb.dac.shared.entity.Funcionario;
import br.edu.ifpb.dac.shared.entity.FuncionarioType;
import br.edu.ifpb.dac.shared.entity.Usuario;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import br.rdu.ifpb.dac.shared.UsuarioService;
import javax.ejb.EJB;



/**
 * Classe de serviço encarregada de cuidar dos dados de um novo usuário
 * @author laerton
 */
@Stateless
@Remote(UsuarioService.class)
public class UsuarioServiceImp implements UsuarioService {
    
    //@Inject
    @EJB
    private UsuarioPersiste persiste;
    //@Inject
    @EJB
    private GenericPersiste<Usuario> gPersiste;
    @EJB 
    private JavaMailClass mail;
    //@Inject
    @EJB
    private ProdutorQueue prouto;
    private final String emailRemetente =   "hrecruta.dac@gmail.com";
    //private final String senha = "senha123456";
    
    
    
    /***
     * Método grava os dados de um usuário e encaminha e-mail para todos os gerentes aguardando a confirmação da lieração.
     * @param user - Usuário do tipo candidato.
     */
    @Override
    public void gravar(Usuario user){
        gPersiste.create(user);
        String emailDestino = emailsGerentes();
        //mail.envia(email, senha, emailDestino, "Confirmação de cadastro", "Existem usuários pendente de confirmação de cadastro, favor acessar o link para confirma-los. ");
        Email email = new Email(this.emailRemetente, emailDestino, "Confirmação de cadastro", "Existem usuários pendente de confirmação.");
        prouto.enviar(email);
    }
   
   /***
    * Métodod encarregado de coletar os e-mails de todos os gerentes no banco de dados
    * @return String formada com os e-mails dos gerentes.
    */
    private String emailsGerentes() {
        String emails ="";
        List<Funcionario> lista = persiste.findByCargo(FuncionarioType.GERENTE);
        int i = 1;
        for (Funcionario funcionario : lista) {
            emails += funcionario.getEmail() +((i != lista.size())? ",":"");
            i++;
        }
        return emails;
    }
    
    
    
}
