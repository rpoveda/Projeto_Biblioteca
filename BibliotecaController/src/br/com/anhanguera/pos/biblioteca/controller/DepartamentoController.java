package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.DepartamentoDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Departamento;
import br.com.anhanguera.pos.biblioteca.entidade.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class DepartamentoController {

    public DepartamentoController(){

    }
    
    public boolean insert(Departamento d){
        try{
            return new DepartamentoDAO().insert(d);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<Departamento> selectAll(){
        try{
            return new DepartamentoDAO().selectAll();
        }catch(Exception e){
            return null;
        }
    }
}
