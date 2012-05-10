/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.dao.test;

import br.com.anhanguera.pos.biblioteca.dao.DepartamentoDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Departamento;
import br.com.anhanguera.pos.biblioteca.entidade.Funcionario;
import java.sql.Date;

/**
 *
 * @author rafaelpoveda
 */
public class DepartamentoDAOTest {
    
    public static void main(String[] args){
        Departamento d = new Departamento();
        Funcionario f = new Funcionario();
        d.setNomeDepartamento("Departamento legal pra chuchu");
        f.setNumeroMatricula(123456);
        d.setChefeDepartamento(f);
        
        
        try{
            boolean b = new DepartamentoDAO().insert(d);
            System.out.println(b);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    
}
