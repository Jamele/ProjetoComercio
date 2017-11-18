/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercio.controlador;

import br.com.comercio.dao.UsuarioDAO;
import br.com.comercio.modelos.Caixa;
import br.com.comercio.modelos.Funcionario;
import br.com.comercio.modelos.Gerente;
import br.com.comercio.modelos.Usuario;
import br.com.comercio.modelos.Vendedor;
import javax.swing.JTextField;

/**
 *
 * @author tulio
 */
public class AlterarControlador {
    
    private Caixa caixa = new Caixa();
    private Gerente gerente = new Gerente();
    private Vendedor vendedor = new Vendedor();
    private Funcionario funcionario = new Funcionario();

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    // private Usuario usuario = new Usuario();
    
    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public boolean verificar(){
        if ((funcionario != null)){
            if(funcionario.getNome() != null 
                    && funcionario.getLogin() != null
                    && funcionario.getLogin() != null
                    && funcionario.getSenha() != null){
                if(funcionario.getNome().length() > 3 
                        && funcionario.getSalario() > 0 
                        && (funcionario.getLogin().length() > 4 
                        && funcionario.getLogin().length() < 16)
                        && (funcionario.getSenha().length() > 4
                        && funcionario.getSenha().length() < 16)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void definirComissao(Funcionario funcionario) {
        double salarioExtraido = getFuncionario().getSalario();
        
        if (funcionario instanceof Caixa){
            caixa.receberComissao(salarioExtraido);
            System.out.println("Caixa: "+caixa.toString());
        }
        else if(funcionario instanceof Vendedor){
            vendedor.receberComissao(salarioExtraido);
            System.out.println("Vendedor: "+vendedor.toString());
        }
        else if(funcionario instanceof Gerente){
            gerente.receberComissao(salarioExtraido);
            System.out.println("Gerente: "+gerente.toString());
        }
    }

    public void limpar(JTextField[] campos){
        for(JTextField cp : campos){
            cp.setText("");
        }
    }
    
    public void alterar (Usuario usuario){
        UsuarioDAO udao = new UsuarioDAO();
        udao.editar(usuario);
    }
}
