package br.com.anhanguera.pos.biblioteca.dao;

import br.com.anhanguera.pos.biblioteca.entidade.Assunto;
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
public class AssuntoDAO {
    
    private Connection conn;
    private PreparedStatement stmt;
    
    public AssuntoDAO(){
        conn = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(Assunto assunto) throws SQLException{
        try{
            String sql = "insert into assunto (descricaoassunto) values (?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, assunto.getDescricaoAssunto());
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
    
    public boolean update(Assunto assunto) throws SQLException{
        try{
            String sql = "update assunto set descricaoassunto=? where codigoassunto=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, assunto.getDescricaoAssunto());
            stmt.setInt(2, assunto.getCodigoAssunto());
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
    
    public boolean delete(int pintCodigoAssunto) throws SQLException{
        try{
            String sql = "delete from assunto where codigoassunto=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pintCodigoAssunto);
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
    
    public List<Assunto> selectAll() throws SQLException{
        try{
            List<Assunto> lstAssunto = new ArrayList<Assunto>();
            String sql = "select * from assunto";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Assunto assunto = new Assunto();
                
                assunto.setCodigoAssunto(rs.getInt("codigoassunto"));
                assunto.setDescricaoAssunto(rs.getString("descricaoassunto"));
                
                lstAssunto.add(assunto);
            }
            
            return lstAssunto;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public List<Assunto> select(Assunto passunto) throws SQLException{
        try{
            List<Assunto> lstAssunto = new ArrayList<Assunto>();
            String sql = " select * from assunto"
                    + " where cosigoassunto like ?"
                    + " and descricaoassunto like ? ";
            String strCodigoAssunto = passunto.getCodigoAssunto() == 0 ? "" : Integer.toString(passunto.getCodigoAssunto());
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, strCodigoAssunto);
            stmt.setString(2, passunto.getDescricaoAssunto());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Assunto assunto = new Assunto();
                
                assunto.setCodigoAssunto(rs.getInt("codigoassunto"));
                assunto.setDescricaoAssunto(rs.getString("descricaoassuto"));
                
                lstAssunto.add(assunto);
            }
            
            return lstAssunto;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
}
