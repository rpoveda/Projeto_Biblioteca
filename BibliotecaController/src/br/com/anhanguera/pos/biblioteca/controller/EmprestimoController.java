/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.EmprestimoDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Emprestimo;
import java.util.List;

/**
 *
 * @author William
 */
public class EmprestimoController {

    private Emprestimo emprestimo;

    public EmprestimoController(Emprestimo emprestimo){
        this.emprestimo = emprestimo;
    }

    public EmprestimoController(){ }

    public boolean insert(){
        try{
            return new EmprestimoDAO().insert(emprestimo);
        }catch(Exception e){
            return false;
        }
    }

    public boolean alter(){
        try{
            return new EmprestimoDAO().alter(emprestimo);
        }catch(Exception e){
            return false;
        }
    }

    public boolean delete(int CodigoEmprestimo){
        try{
            return new EmprestimoDAO().delete(CodigoEmprestimo);
        }catch(Exception e){
            return false;
        }
    }

    public List<Emprestimo> selectAll(){
        try
        {
            return new EmprestimoDAO().selectAll();
        }catch(Exception e){
            return null;
        }
    }
    
}

