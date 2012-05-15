package br.com.anhanguera.pos.biblioteca.dao;

import br.com.anhanguera.pos.biblioteca.entidade.Editora;
import com.mysql.jdbc.CallableStatement;
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
public class EditoraDAO {

    private Connection conn;
    private PreparedStatement stmt = null;

    public EditoraDAO(){
        conn = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(Editora editora)throws SQLException{
        try
        {
            String sql = "insert into editora (nomeeditora, cidadeeditora) values (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, editora.getNomeEditora());
            stmt.setString(2, editora.getCidadeEditora());
            stmt.execute();
            editora = null;
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public boolean alter(Editora editora) throws SQLException{
        try{
            String sql = "uptade editora set nomeeditora=? , cidadeeditora=? where codigoeditora=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, editora.getNomeEditora());
            stmt.setString(2, editora.getCidadeEditora());
            stmt.setInt(3, editora.getCodigoEditora());
            stmt.execute();
            editora = null;
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public boolean delete(int codigoEditora) throws SQLException{
        try{
            String sql = "delete from editora where codigoeditora=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigoEditora);
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
    
    public List<Editora> selectAll() throws SQLException{
        try{
            List<Editora> _lstEditora = new ArrayList<Editora>();
            stmt = conn.prepareStatement("select * from editora");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Editora editora = new Editora();
                editora.setCodigoEditora(rs.getInt("codigoeditora"));
                editora.setNomeEditora(rs.getString("nomeeditora"));
                editora.setCidadeEditora(rs.getString("cidadeeditora"));
                _lstEditora.add(editora);
                editora = null;
            }
            
            return _lstEditora;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public List<Editora> select(Editora editora) throws SQLException{
        try{
            String sql = "select * from editora where "+
                    "codigoeditora like ? and nomeeditora like ? and cidadeeditora like ? ";
            String codigo = (editora.getCodigoEditora() == 0) ? "" : Integer.toString(editora.getCodigoEditora());
            List<Editora> _lstEditora = new ArrayList<Editora>();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + codigo + "%");
            stmt.setString(2, "%" + editora.getNomeEditora() + "%");
            stmt.setString(3, "%" + editora.getCidadeEditora() + "%");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Editora e = new Editora();
                e.setCodigoEditora(rs.getInt("codigoeditora"));
                e.setNomeEditora(rs.getString("nomeeditora"));
                e.setCidadeEditora(rs.getString("cidadeeditora"));
                _lstEditora.add(e);
                e = null;
            }
            editora = null;
            return _lstEditora;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
}
