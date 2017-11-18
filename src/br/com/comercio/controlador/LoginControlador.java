/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercio.controlador;

import br.com.comercio.interfaces.Inicial;
import br.com.comercio.modelos.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author tulio
 */
public class LoginControlador {
    
    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Este método é referente a verificação
     * dos dados inseridos em Login e Senha
     * 
     * @see Login
     * @return Um valor booleano se verdadeiro ou falso 
     */
    public boolean autenticar() {
        if (getUsuario().getLogin().equals("admin")
                && getUsuario().getSenha().equals("admin")) {
            return true;
        } else { // Se o usuário ou senha forem incorretos
            return false;
        }
    }
    
}
