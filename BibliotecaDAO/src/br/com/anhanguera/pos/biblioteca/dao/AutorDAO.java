/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.dao;

import br.com.anhanguera.pos.biblioteca.entidade.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valmir
 */
public class AutorDAO {
    
    private Connection conn;
    private PreparedStatement stmt = null;
    
    public AutorDAO(){
        conn = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(Autor autor) throws SQLException{
        try{
            String sql = "INSERT INTO autor(NomeAutor) VALUES(?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, autor.getNomeAutor());
            stmt.execute();
            autor = null;
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public boolean alter(Autor autor) throws SQLException{
        try{
            String sql = "UPDATE autor SET NomeAutor=? WHERE CodigoAutor=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, autor.getNomeAutor());
            stmt.setInt(2, autor.getCodigoAutor());
            stmt.execute();
            autor = null;
            
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public boolean delete(Autor autor) throws SQLException{
        try{
            String sql = "DELETE FROM autor WHERE CodigoAutor=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, autor.getCodigoAutor());
            stmt.execute();
            autor = null;
            
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public List<Autor> selectAll() throws SQLException{
        Autor autor = new Autor();
        
        return select(autor);
    }
    
    public List<Autor> select(Autor autor) throws SQLException{
        try{
            boolean filtrarCodigo = autor.getCodigoAutor() != 0;
            String sql = "SELECT * FROM autor WHERE NomeAutor LIKE ?" +
                         (filtrarCodigo ? " AND CodigoAutor = ?" : "");
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + autor.getNomeAutor() + "%");
            if(filtrarCodigo)
                stmt.setInt(2, autor.getCodigoAutor());
            ResultSet rs = stmt.executeQuery();
            List<Autor> _lstAutor = new ArrayList<Autor>();
            
            while(rs.next()){
                Autor e = new Autor();
                e.setCodigoAutor(rs.getInt("CodigoAutor"));
                e.setNomeAutor(rs.getString("NomeAutor"));
                _lstAutor.add(e);
            }           
            autor = null;
         
            return _lstAutor;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
}
