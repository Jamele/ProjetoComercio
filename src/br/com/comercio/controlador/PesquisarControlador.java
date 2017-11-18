/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercio.controlador;

import br.com.comercio.dao.UsuarioDAO;
import br.com.comercio.modelos.Funcionario;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jamele
 */
public class PesquisarControlador {
    
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> funcionarios;

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public void pesquisar(){
        UsuarioDAO udao = new UsuarioDAO();
        funcionarios = udao.pesquisar(funcionario);
    }
    
    public void atualizarTabela(JTable tabela){
        if(getFuncionario().getNome() == null){
            JOptionPane.showMessageDialog(null, "É necessário informar um nome!");
            return;
        }
        else{
            pesquisar();
            
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setNumRows(0);

            List<Funcionario> funcionariosEncontrados = getFuncionarios();


            for (int i = 0; i < funcionariosEncontrados.size(); i++) {
                model.insertRow(i, new String[]{
                    funcionariosEncontrados.get(i).getNome(),
                    String.valueOf(funcionariosEncontrados.get(i).getSalario())
                });
            }
            tabela.setModel(model);
        }
    }
    
    public void excluir(Funcionario funcionario){
        UsuarioDAO udao = new UsuarioDAO();
        udao.excluir(funcionario);
        
        JOptionPane.showMessageDialog(null, "Funcionário " + funcionario.getNome() +" excluído com sucesso!");
    }
}
