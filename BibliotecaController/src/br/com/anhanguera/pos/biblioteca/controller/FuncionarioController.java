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
    
    public static String msg = "O campo {CAMPO} é obrigatório.";
    
    private static boolean isValid(Funcionario f, boolean bValidaCodigo){
        if(bValidaCodigo && f.getNumeroMatricula() == 0)
        { msg.replace("{CAMPO}", "Número matricula"); return false; }
        else if(f.getNomeCompleto().equals(null))
        { msg.replace("{CAMPO}", "Nome"); return false; }
        else if(f.getDepartamento().getCodigoDepartamento() == 0)
        { msg.replace("{CAMPO}", "Departamento"); return false; }
        else
            return true;
    }
    
    public FuncionarioController(){

    }
    
    public boolean insert(Funcionario f){
        try
        {
            
            if(!isValid(f, false))
                return false;
            
            return new FuncionarioDAO().insert(f);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean alter(Funcionario f){
        try{
            if(!isValid(f, true))
                return false;
            
            return new FuncionarioDAO().alter(f);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean delete(int pintNumeroMatricula){
        try{
            
            if(pintNumeroMatricula == 0)
                return false;
            
            return new FuncionarioDAO().delete(pintNumeroMatricula);
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
