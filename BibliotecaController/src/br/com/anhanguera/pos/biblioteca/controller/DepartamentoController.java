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

    
    public static String msg = "O campo {CAMPO} é obrigatório.";
    
    public DepartamentoController(){

    }
    
    public static boolean isValid(Departamento d, boolean bValidaCodigo){
        if(bValidaCodigo && d.getCodigoDepartamento() == 0)
        { msg.replace("{CAMPO}", "Código");   return false; }
        else if (d.getNomeDepartamento().equals(""))
        { msg.replace("{CAMPO}", "Nome do departamento");   return false; }
        else if (d.getChefeDepartamento().getNumeroMatricula() == 0)
        { msg.replace("{CAMPO}", "Chefe departamento");   return false; }
        else
            return true;
    }
    
    public boolean insert(Departamento d){
        try{
            
            if(!isValid(d, false))
                return false;
            
            return new DepartamentoDAO().insert(d);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean alter(Departamento d){
        try{
            if(!isValid(d, true))
                return false;
            
            return new DepartamentoDAO().alter(d);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean delete(int pintCodigoDepartamento){
        try{
            if(pintCodigoDepartamento == 0){
                msg.replace("{CAMPO}", "Código departamento");
                return false;
            }
            
            return new DepartamentoDAO().delete(pintCodigoDepartamento);
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
    
    public List<Departamento> select(Departamento d){
        try{
            return new DepartamentoDAO().select(d);
        }catch(Exception e){
            return null;
        }
    }
}
