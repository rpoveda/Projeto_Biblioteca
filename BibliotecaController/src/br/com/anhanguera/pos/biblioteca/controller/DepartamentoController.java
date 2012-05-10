package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.DepartamentoDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Departamento;
import br.com.anhanguera.pos.biblioteca.entidade.Funcionario;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class DepartamentoController {

    private Departamento departamento;
    private Funcionario funcionario;
    
    public DepartamentoController(){
        this.departamento = new Departamento();
        this.funcionario = new Funcionario();
    }
    
    public boolean insert(Departamento d){
        try{
            return new DepartamentoDAO().insert(d);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
}
