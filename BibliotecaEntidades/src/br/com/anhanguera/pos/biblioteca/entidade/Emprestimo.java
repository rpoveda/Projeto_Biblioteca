/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.anhanguera.pos.biblioteca.entidade;

import java.util.Date;

/**
 *
 * @author William
 */
public class Emprestimo {

    private int codigoEmprestimo;
    private String nomeObra = "";
    private String numeroMatricula = "";
    private Date dataCriacao;
    private Date dataDevolucao;
    private String codigoFuncionario;

    public int getCodigoEmprestimo() {
        return codigoEmprestimo;
    }

    public void setCodigoEmprestimo(int codigoEmprestimo) {
        this.codigoEmprestimo = codigoEmprestimo;
    }
    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getNomeObra() {
        return nomeObra;
    }

    public void setNomeObra(String nomeObra) {
        this.nomeObra = nomeObra;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
   
}
