/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercio.dao;

import br.com.comercio.modelos.Funcionario;
import br.com.comercio.modelos.Usuario;
import br.com.comercio.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jamele
 */
public class UsuarioDAO {
    private Session sessao;
    private Transaction transacao;
    
    public UsuarioDAO(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
    }
    
    public void cadastrar(Usuario usuario){
        sessao.save(usuario);
        transacao.commit();
    }
    
    public void editar(Usuario usuario){
        sessao.update(usuario);
        transacao.commit();
    }
    
    public void excluir(Usuario usuario){
        sessao.delete(usuario);
        transacao.commit();
    }
    
    public List<Funcionario> pesquisar(Funcionario funcionario){
        return sessao.createCriteria(Usuario.class).add(Restrictions.ilike("nome",funcionario.getNome()+"%")).list();
        
    }
}
