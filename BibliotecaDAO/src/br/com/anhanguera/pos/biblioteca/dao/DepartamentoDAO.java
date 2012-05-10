package br.com.anhanguera.pos.biblioteca.dao;

import br.com.anhanguera.pos.biblioteca.entidade.Departamento;
import br.com.anhanguera.pos.biblioteca.entidade.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.management.RuntimeErrorException;
import javax.sql.rowset.RowSetWarning;

/**
 *
 * @author rafaelpoveda
 */
public class DepartamentoDAO {
    
    private Connection conn;
    private PreparedStatement stmt = null;
    
    public DepartamentoDAO(){
        conn = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(Departamento departamento) throws SQLException{
        try{
            String sql = "insert into departamento (nomedepartamento, codigochefedepartamento) values (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, departamento.getNomeDepartamento());
            stmt.setInt(2, departamento.getChefeDepartamento().getNumeroMatricula());
            stmt.execute();
            return true;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        finally{
            conn.close();
            stmt.close();
        }
    }
    
    public boolean alter(Departamento departamento) throws SQLException{
        try{
            String sql = "update departamento set nomedepartamento = ?, codigochefedepartamento =? where "+
                    "codigodepartamento=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, departamento.getNomeDepartamento());
            stmt.setInt(2, departamento.getChefeDepartamento().getNumeroMatricula());
            stmt.setInt(3, departamento.getCodigoDepartamento());
            stmt.execute();
            return true;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        finally{
            conn.close();
            stmt.close();
        }
        
    }
    
    public boolean delete(int codigodepartamento) throws SQLException{
        try{
            String sql = "delete from departamento where codigodepartamento =?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigodepartamento);
            stmt.execute();
            return true;
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            conn.close();
            stmt.close();
        }
    }
    
    public List<Departamento> selectAll() throws SQLException{
        try{
            String sql = " select d.*, f.* from departamento d " +
                    "join funcionario f on f.numeromatricula = d.codigochefedepartamento";
            
            List<Departamento> _lstDepartamento = new ArrayList<Departamento>();
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Departamento d = new Departamento();
                Funcionario f = new Funcionario();
                
                d.setCodigoDepartamento(rs.getInt("codigodepartamento"));
                d.setNomeDepartamento(rs.getString("nomedepartamento"));
                f.setNomeComplet(rs.getString("nomecompleto"));
                f.setNumeroMatricula(rs.getInt("numeromatricula"));
                d.setChefeDepartamento(f);
                _lstDepartamento.add(d);
            }
            
            return _lstDepartamento;
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            conn.close();
            stmt.close();
        }
    }
    
    public List<Departamento> select(Departamento departamento) throws SQLException{
        try{
            String sql = "select d.*, f.* from departamento d " +
                    "join funcionario f on f.numeromatricula = d.codigochefedepartamento "+
                    "where d.nomedepartamento like ? and codigodepartamento like ?";
            List<Departamento> _lstDepartamento = new ArrayList<Departamento>();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + departamento.getNomeDepartamento() + "%");
            stmt.setString(2, "%" + departamento.getCodigoDepartamento() + "%");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Departamento d = new Departamento();
                Funcionario f = new Funcionario();
                
                d.setCodigoDepartamento(rs.getInt("codigodepartamento"));
                d.setNomeDepartamento(rs.getString("nomedepartamento"));
                f.setNomeComplet(rs.getString("nomecompleto"));
                f.setNumeroMatricula(rs.getInt("numeromatricula"));
                d.setChefeDepartamento(f);
                _lstDepartamento.add(d);
            }
            
            return _lstDepartamento;
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            conn.close();
            stmt.close();
        }
    }
}
