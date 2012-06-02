/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.entidade;

/**
 *
 * @author rafaelpoveda
 */
public class Assunto {
    
    private int codigoAssunto = 0;
    private String descricaoAssunto = "";

    public int getCodigoAssunto() {
        return codigoAssunto;
    }

    public void setCodigoAssunto(int codigoAssunto) {
        this.codigoAssunto = codigoAssunto;
    }

    public String getDescricaoAssunto() {
        return descricaoAssunto;
    }

    public void setDescricaoAssunto(String descricaoAssunto) {
        this.descricaoAssunto = descricaoAssunto;
    }

}
