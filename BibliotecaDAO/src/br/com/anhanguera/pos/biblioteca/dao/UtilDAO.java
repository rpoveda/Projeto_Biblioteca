package br.com.anhanguera.pos.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author rafaelpoveda
 */
public class UtilDAO {
    
    private Connection conn;
    private PreparedStatement stmt = null;
    
    public UtilDAO(){
        conn = new ConnectionFactory().getConnection();
    }
    
    public int nextId(String table, String field){
        try
        {
            String sql = "select (COALESCE(max("+field+"), 0) + 1) as 'codigo' from " + table;
            int iret = 0;
            stmt = conn.prepareStatement(sql);
            //stmt.setString(1, field);
            //stmt.setString(2, table);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                iret = rs.getInt("codigo");
            }
            
            return iret;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
}
