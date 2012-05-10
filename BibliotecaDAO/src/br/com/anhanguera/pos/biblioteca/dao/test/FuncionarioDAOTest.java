package br.com.anhanguera.pos.biblioteca.dao.test;

import br.com.anhanguera.pos.biblioteca.dao.FuncionarioDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Departamento;
import br.com.anhanguera.pos.biblioteca.entidade.Funcionario;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class FuncionarioDAOTest {
    
    public static void main(String[] args){
        /*Funcionario f = new Funcionario();
        Departamento d = new Departamento();
        d.setCodigoDepartamento(1);
        f.setNumeroMatricula(123);
        f.setNomeComplet("Rafael Poveda");
        f.setDepartamento(d);*/
        FuncionarioDAO dao = new FuncionarioDAO();
        try{
            //boolean b = dao.incluir(f);
            //boolean b = dao.alterar(f);
            //boolean b = dao.excluir(234);
            
            //System.out.print(b);
            
            List<Funcionario> lst = dao.selectAll();

            for(Funcionario func : lst){
                System.out.println("Nome: " + func.getNomeCompleto());
                System.out.println("Departamento: " + func.getDepartamento().getNomeDepartamento());
                System.out.println("Chefe: " + func.getDepartamento().getChefeDepartamento().getNomeCompleto());
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
