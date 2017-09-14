/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rdu.ifpb.rhecruta.web.controle;



import br.edu.ifpb.dac.shared.entity.Candidato;
import br.edu.ifpb.dac.shared.entity.Usuario;
import br.rdu.ifpb.dac.shared.UsuarioService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import util.Mensagem;



/**
 *
 * @author jose2
 */
@Named
@SessionScoped
public class ControleTest implements Serializable{
    @Inject
    private UsuarioService usuarioService;
    @Inject
    private Mensagem mensagem;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String add(){
       
        try {
            Usuario user = new Candidato(0, nome, "curriculo", "jose@gmail.com", nome);
            
       usuarioService.gravar(user);
            
       mensagem.addMessage(null, "certo");
        } catch (Exception e) {
            mensagem.addMessage(null, "erro"+e.getMessage());
        }
       
       return null;
    
    
}
}
