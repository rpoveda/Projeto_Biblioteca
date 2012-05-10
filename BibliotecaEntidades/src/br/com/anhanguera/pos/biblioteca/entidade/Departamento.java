package br.com.anhanguera.pos.biblioteca.entidade;

/**
 *
 * @author rafaelpoveda
 */
public class Departamento {
    
    private int codigoDepartamento;
    private String nomeDepartamento;
    private Funcionario chefeDepartamento;
    
    //gets and sets
    public int getCodigoDepartamento(){
        return this.codigoDepartamento;
    }
    public void setCodigoDepartamento(int codigoDepartamento){
        this.codigoDepartamento = codigoDepartamento;
    }
    
    public String getNomeDepartamento(){
        return this.nomeDepartamento;
    }
    public void setNomeDepartamento(String nomeDepartamento){
        this.nomeDepartamento = nomeDepartamento;
    }
    
    public Funcionario getChefeDepartamento(){
        return this.chefeDepartamento;
    }
    public void setChefeDepartamento(Funcionario chefeDepartamento){
        this.chefeDepartamento = chefeDepartamento;
    }
}
