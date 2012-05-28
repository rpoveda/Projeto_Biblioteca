package br.com.anhanguera.pos.biblioteca.entidade;

import java.util.Date;

/**
 *
 * @author rafaelpoveda
 */
public class Devolucao {
    
    private int codigoDevolucao = 0;
    private Exemplar exemplar;
    private Date dataDevolucao;
    private Usuario usuarioDevoluca;

    public int getCodigoDevolucao() {
        return codigoDevolucao;
    }

    public void setCodigoDevolucao(int codigoDevolucao) {
        this.codigoDevolucao = codigoDevolucao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Usuario getUsuarioDevoluca() {
        return usuarioDevoluca;
    }

    public void setUsuarioDevoluca(Usuario usuarioDevoluca) {
        this.usuarioDevoluca = usuarioDevoluca;
    }
    
    
    
    
}
