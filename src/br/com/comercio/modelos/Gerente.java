/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercio.modelos;

import javax.persistence.Entity;

/**
 *
 * @author tulio
 *
 * extends -> Refere-se a herança da classe Gerente recebida de Usuario
 */

@Entity
public class Gerente extends Funcionario {

    /**
     * Estamos utilizando o conceito de sobrescrita ( Polimorfismo ), dai o
     *
     * @Override Isto é, estamos alterando a forma como é feita a comissão dos
     * funcionários
     *
     * @param valor
     */
    @Override
    public void receberComissao(double valor) {
        // Informamos que um Caixa recebe o valor
        // mais(+) 20% -> (valor * 0.20)
        // setSalario é a definição do salário +20%
        setSalario(getSalario() + (valor * 0.20));
    }
}
