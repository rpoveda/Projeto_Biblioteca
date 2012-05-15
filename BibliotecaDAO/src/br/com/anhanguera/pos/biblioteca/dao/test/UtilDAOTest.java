/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.dao.test;

import br.com.anhanguera.pos.biblioteca.dao.DepartamentoDAO;
import br.com.anhanguera.pos.biblioteca.dao.EditoraDAO;
import br.com.anhanguera.pos.biblioteca.dao.FuncionarioDAO;
import br.com.anhanguera.pos.biblioteca.dao.UtilDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Departamento;
import br.com.anhanguera.pos.biblioteca.entidade.Editora;
import br.com.anhanguera.pos.biblioteca.entidade.Funcionario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class UtilDAOTest {
    
    public static void main(String[] args) throws SQLException{
        Editora e = new Editora();
        e.setCodigoEditora(1);
        Departamento d = new Departamento();
        Funcionario f = new Funcionario();
        List<Funcionario> lst = new FuncionarioDAO().select(f);
    }
    
}
