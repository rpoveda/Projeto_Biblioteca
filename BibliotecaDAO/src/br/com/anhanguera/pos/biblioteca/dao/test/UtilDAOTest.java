/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.dao.test;

import br.com.anhanguera.pos.biblioteca.dao.*;
import br.com.anhanguera.pos.biblioteca.entidade.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class UtilDAOTest {
    
    public static void main(String[] args) throws SQLException{
//        Editora e = new Editora();
//        e.setCodigoEditora(1);
//        Departamento d = new Departamento();
//        Funcionario f = new Funcionario();
//        List<Funcionario> lst = new FuncionarioDAO().select(f);
        Obra obra = new Obra();
        Editora e = new Editora();
        Autor a = new Autor();
        obra.setEditoraObra(e);
        obra.setAutorPrincipal(a);
        List<Obra> _lstObra = new ObraDAO().select(obra);
        SituacaoObra so = SituacaoObra.Disponivel;
        System.out.println(so);
        System.out.println(so.toString());
        
    }
    
}
