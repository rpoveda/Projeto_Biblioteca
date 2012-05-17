package br.com.anhanguera.pos.biblioteca.entidade;

import java.util.Date;

/**
 *
 * @author rafaelpoveda
 */
public class Exemplar {

    private int codigoExemplar = 0;
    private Obra obra;
    private Date dataAquisicaoExemplar;
    private String situacaoExemplar = "";

    public int getCodigoExemplar() {
        return codigoExemplar;
    }

    public void setCodigoExemplar(int codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
    }

    public Date getDataAquisicaoExemplar() {
        return dataAquisicaoExemplar;
    }

    public void setDataAquisicaoExemplar(Date dataAquisicaoExemplar) {
        this.dataAquisicaoExemplar = dataAquisicaoExemplar;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public String getSituacaoExemplar() {
        return situacaoExemplar;
    }

    public void setSituacaoExemplar(String situacaoExemplar) {
        this.situacaoExemplar = situacaoExemplar;
    }
    
    
    
}
