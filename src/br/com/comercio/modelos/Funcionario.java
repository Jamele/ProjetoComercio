/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercio.modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author tulio
 */

@Entity
public class Funcionario extends Usuario implements Serializable {
    
    @Id
    @GeneratedValue
    private String nome;
    
    private double salario;

    @Override
    public String toString() {
        return "Funcionario{" + "nome= " + nome + ", salario= " + salario
                + ", login = " + getLogin() + ", senha = " +getSenha() + '}';
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
     
    public void receberComissao(double valor) {
        this.salario += valor;
    }
}