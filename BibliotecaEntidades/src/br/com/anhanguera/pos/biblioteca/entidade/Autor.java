package br.com.anhanguera.pos.biblioteca.entidade;

/**
 *
 * @author rafaelpoveda
 */
public class Autor {
 
    private int codigoAutor = 0;
    private String nomeAutor = "";
    
    public int getCodigoAutor(){
        return this.codigoAutor;
    }
    public void setCodigoAutor(int codigoAutor){
        this.codigoAutor = codigoAutor;
    }
    
    public String getNomeAutor(){
        return this.nomeAutor;
    }
    public void setNomeAutor(String nomeAutor){
        this.nomeAutor = nomeAutor;
    }
    
    
}
