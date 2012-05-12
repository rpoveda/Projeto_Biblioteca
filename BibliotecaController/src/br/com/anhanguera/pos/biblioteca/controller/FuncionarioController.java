/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.FuncionarioDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Departamento;
import br.com.anhanguera.pos.biblioteca.entidade.Funcionario;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class FuncionarioController {
    
    public FuncionarioController(){

    }
    
    public boolean insert(Funcionario f){
        try
        {
            return new FuncionarioDAO().insert(f);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<Funcionario> selectAll(){
        try{
            return new FuncionarioDAO().selectAll();
        }catch(Exception e){
            return null;
        }
    }
    
    public List<Funcionario> select(Funcionario f){
        try{
            return new FuncionarioDAO().select(f);
        }catch(Exception e){
            return null;
        }
    }
    
}
