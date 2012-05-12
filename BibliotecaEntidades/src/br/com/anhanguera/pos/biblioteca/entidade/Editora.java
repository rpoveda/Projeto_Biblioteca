package br.com.anhanguera.pos.biblioteca.entidade;

/**
 *
 * @author rafaelpoveda
 */
public class Editora {

    private int codigoEditora;
    private String nomeEditora;
    private String cidadeEditora;
    
    ///gets and sets codigo
    public int getCodigoEditora(){
        return this.codigoEditora;
    }
    public void setCodigoEditora(int codigoEditora){
        this.codigoEditora = codigoEditora;
    }
    
    ///gets and sets nome
    public String getNomeEditora(){
        return this.nomeEditora;
    }
    public void setNomeEditora(String nomeEditora){
        this.nomeEditora = nomeEditora;
    }
    
    
    ///gets and sets cidade
    public String getCidadeEditora(){
        return this.cidadeEditora;
    }
    public void setCidadeEditora(String cidadeEditora){
        this.cidadeEditora = cidadeEditora; 
    }
}
