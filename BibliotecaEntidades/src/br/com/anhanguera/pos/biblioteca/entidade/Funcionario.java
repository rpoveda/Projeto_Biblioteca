package br.com.anhanguera.pos.biblioteca.entidade;

/**
 *
 * @author rafaelpoveda
 */
public class Funcionario {
 
    private int numeroMatriculaFuncionario = 0;
    private String nomeCompletoFuncionario = "";
    private Departamento departamentoFuncionario; 
    
    //gets and sets
    public int getNumeroMatricula(){
        return this.numeroMatriculaFuncionario;
    }
    public void setNumeroMatricula(int numeroMatricula){
        this.numeroMatriculaFuncionario = numeroMatricula;
    }
    
    public String getNomeCompleto(){
        return this.nomeCompletoFuncionario;
    }
    public void setNomeComplet(String nomeCompleto){
        this.nomeCompletoFuncionario = nomeCompleto;
    }
    
    public Departamento getDepartamento(){
        return this.departamentoFuncionario;
    }
    public void setDepartamento(Departamento departamento){
        this.departamentoFuncionario = departamento;
    }
    
}
