/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.anhanguera.pos.biblioteca.dao;

import br.com.anhanguera.pos.biblioteca.entidade.Emprestimo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William
 */
public class EmprestimoDAO {
   private Connection conn;
    private PreparedStatement stmt = null;

    public EmprestimoDAO(){
        conn = new ConnectionFactory().getConnection();
    }

    public boolean insert(Emprestimo emprestimo)throws SQLException{
        try
        {
            String sql = "insert into emprestimo (nomeobra, numeromatricula, datacriacao, datadevolucao, codigofuncionario) values (?, ?, ?, ? ,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, emprestimo.getNomeObra());
            stmt.setString(2, emprestimo.getNumeroMatricula());
            stmt.setDate(3, UtilDAO.convertDataForDateSql(emprestimo.getDataCriacao()));
            stmt.setDate(4, UtilDAO.convertDataForDateSql(emprestimo.getDataDevolucao()));
            stmt.setString(5, emprestimo.getCodigoFuncionario());
            stmt.execute();
            emprestimo = null;
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }

    public boolean alter(Emprestimo emprestimo) throws SQLException{
        //ResultSet rs;
        try{

            String sql = "update emprestimo set nomeobra=? , numeromatricula=?, datacriacao=?, datadevolucao=?, codigofuncionario=? where codigoemprestimo=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, emprestimo.getNomeObra());
            stmt.setString(2, emprestimo.getNumeroMatricula());
            stmt.setDate(3, UtilDAO.convertDataForDateSql(emprestimo.getDataCriacao()));
            stmt.setDate(4, UtilDAO.convertDataForDateSql(emprestimo.getDataCriacao()));
            stmt.setString(5, emprestimo.getCodigoFuncionario());
            stmt.execute();
            emprestimo = null;
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }

    public boolean delete(int CodigoEmprestimo) throws SQLException{
        try{
            String sql = "delete from emprestimo where codigoemprestimo=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, CodigoEmprestimo);
            stmt.execute();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }

    public List<Emprestimo> selectAll() throws SQLException{
        try{
            List<Emprestimo> _lstEmprestimo = new ArrayList<Emprestimo>();
            stmt = conn.prepareStatement("select * from emprestimo");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setCodigoEmprestimo(rs.getInt("codigoemprestimo"));
                emprestimo.setNomeObra(rs.getString("nomeobra"));
                emprestimo.setNumeroMatricula(rs.getString("numeromatricula"));
                emprestimo.setDataCriacao(rs.getDate("datacriacao"));
                emprestimo.setDataDevolucao(rs.getDate("datadevolucao"));
                emprestimo.setCodigFuncionario(rs.getString("codigofuncionario"));

                _lstEmprestimo.add(emprestimo);
                emprestimo = null;
            }

            return _lstEmprestimo;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
  
}
