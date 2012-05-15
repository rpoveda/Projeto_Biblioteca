package br.com.anhanguera.pos.biblioteca.dao;

import br.com.anhanguera.pos.biblioteca.entidade.Departamento;
import br.com.anhanguera.pos.biblioteca.entidade.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class FuncionarioDAO {
    
    private Connection conn;
    private PreparedStatement stmt = null;
    
    public FuncionarioDAO(){
        conn = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(Funcionario funcionario) throws SQLException{
        try{
            String sql = "insert into funcionario (numeromatricula, nomecompleto, codigodepartamento)" +
                    "values (? ,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, funcionario.getNumeroMatricula());
            stmt.setString(2, funcionario.getNomeCompleto());
            stmt.setInt(3, funcionario.getDepartamento().getCodigoDepartamento());
            stmt.execute();
            return true;
        }catch(Exception e)
        {
            throw new RuntimeException(e);
        }
        finally{ 
            conn.close();
            stmt.close();
        }
    }
    
    public boolean alter(Funcionario funcionario) throws SQLException{
        try{
            String sql = "update funcionario set nomecompleto=?, codigodepartamento=? where numeromatricula=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNomeCompleto());
            stmt.setInt(2, funcionario.getDepartamento().getCodigoDepartamento());
            stmt.setInt(3, funcionario.getNumeroMatricula());
            stmt.execute();
            return true;
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            conn.close();
            stmt.close();
        }
    }
    
    public boolean delete(int codigoDepartamento) throws SQLException{
        try{
            String sql = "delete from funcionario where numeromatricula = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigoDepartamento);
            stmt.execute();
            return true;
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            conn.close();
            stmt.close();
        }
    }

    public List<Funcionario> selectAll() throws SQLException{
        try
        {
            String sql = "select f.*, d.*," + 
            "(select f.nomecompleto from funcionario as f join departamento as d on d.codigodepartamento = f.codigodepartamento " + 
            "where d.codigochefedepartamento = f.numeromatricula) 'nome_chefedepartamento' " +
            "from funcionario f "+
            "join departamento d on d.codigodepartamento = f.codigodepartamento";
            
            List<Funcionario> _lstFuncionario = new ArrayList<Funcionario>();
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Funcionario f = new Funcionario();
                Departamento d = new Departamento();
                Funcionario f2 = new Funcionario();
                f.setNomeComplet(rs.getString("nomecompleto"));
                f.setNumeroMatricula(rs.getInt("numeromatricula"));
                d.setCodigoDepartamento(rs.getInt("codigodepartamento"));
                d.setNomeDepartamento(rs.getString("NomeDepartamento"));
                f2.setNomeComplet(rs.getString("nome_chefedepartamento"));
                d.setChefeDepartamento(f2);
                f.setDepartamento(d);
                _lstFuncionario.add(f);
            }
            return _lstFuncionario;
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            conn.close();
            stmt.close();
        }
    }
    
    public List<Funcionario> select(Funcionario funcionario) throws SQLException{
        try{
            List<Funcionario> _lstFuncionario = new ArrayList<Funcionario>();
            String sql = "select f.*, d.*," + 
            "(select f.nomecompleto from funcionario as f join departamento as d on d.codigodepartamento = f.codigodepartamento " + 
            "where d.codigochefedepartamento = f.numeromatricula) 'nome_chefedepartamento' " +
            "from funcionario f "+
            "join departamento d on d.codigodepartamento = f.codigodepartamento " +
            "where f.numeromatricula like ? and f.nomecompleto like ? and f.codigodepartamento like ?";
            
            String numeroMatricula = (funcionario.getNumeroMatricula() == 0) ? "" : Integer.toString(funcionario.getNumeroMatricula());
            String codigoDepartamento = (funcionario.getDepartamento().getCodigoDepartamento() == 0) ? "" : Integer.toString(funcionario.getDepartamento().getCodigoDepartamento());
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,"%" + numeroMatricula + "%");
            stmt.setString(2,"%" +  funcionario.getNomeCompleto()+ "%");
            stmt.setString(3,"%" +  codigoDepartamento + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Funcionario f = new Funcionario();
                Departamento d = new Departamento();
                Funcionario f2 = new Funcionario();
                f.setNomeComplet(rs.getString("nomecompleto"));
                f.setNumeroMatricula(rs.getInt("numeromatricula"));
                d.setCodigoDepartamento(rs.getInt("codigodepartamento"));
                d.setNomeDepartamento(rs.getString("NomeDepartamento"));
                f2.setNomeComplet(rs.getString("nome_chefedepartamento"));
                d.setChefeDepartamento(f2);
                f.setDepartamento(d);
                _lstFuncionario.add(f);
            }
            return _lstFuncionario;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        finally{
            conn.close();
            stmt.close();
        }
    }
}
