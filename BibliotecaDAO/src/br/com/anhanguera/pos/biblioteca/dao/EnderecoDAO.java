package br.com.anhanguera.pos.biblioteca.dao;

import br.com.anhanguera.pos.biblioteca.entidade.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rafaelpoveda
 */
public class EnderecoDAO {
    private Connection conn;
    private PreparedStatement stmt;
    
    public EnderecoDAO(){
        conn = new ConnectionFactory().getConnection();
        stmt = null;
    }
    
    public int insert(Endereco endereco) throws SQLException{
        try{
            int iRet = 0;
            String sql = "insert into endereco (ruaendereco, numendereco, bairroendereco, "+
                    " cidadeendereco, estadoendereco, complementoendereco, cependereco) values ( " +
                    "?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1,endereco.getRua());
            stmt.setInt(2, endereco.getNumEndereco());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.setString(6, endereco.getComplemento());
            stmt.setString(7, endereco.getCepEndereco());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if(rs.next())
                iRet = rs.getInt(1);
            
            return iRet;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public boolean update(Endereco endereco) throws SQLException{
        try{
            String sql = "update endereco set ruaendereco=?, numendereco=? "
                    + "bairroendereco=?, cidadeendereco=?, estadoendereco=? "
                    + "complementoendereco=? where codigoendereco=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, endereco.getRua());
            stmt.setInt(2, endereco.getNumEndereco());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.setString(6, endereco.getComplemento());
            stmt.setInt(7, endereco.getCodigoEndereco());
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
    
    public boolean delete(int pintCodigoEndereco) throws SQLException{
        try{
            String sql = "delete from endereco where codigoendereco=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pintCodigoEndereco);
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
    
    public boolean exist(int pintCodigoEndereco) throws SQLException{
        try{
            boolean bRet = false;
            String sql = "select ruaendereco from endereco where codigoendreco=?";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                bRet = true;
            }
            
            return bRet;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }
}
