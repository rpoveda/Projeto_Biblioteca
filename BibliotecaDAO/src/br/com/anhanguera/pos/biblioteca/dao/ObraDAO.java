package br.com.anhanguera.pos.biblioteca.dao;

import br.com.anhanguera.pos.biblioteca.entidade.Autor;
import br.com.anhanguera.pos.biblioteca.entidade.Editora;
import br.com.anhanguera.pos.biblioteca.entidade.Obra;
import br.com.anhanguera.pos.biblioteca.entidade.SituacaoObra;
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
public class ObraDAO {
    
    private Connection conn;
    private PreparedStatement stmt = null;
    
    public ObraDAO(){
        conn = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(Obra obra) throws SQLException{
        try{
            String sql = "insert into obra (tituloobra, codigoautorprincipal " +
                    " ,anopublicacaoobra, situacaoobra, codigoeditoraobra) values (?,? " +
                    " ,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, obra.getTituloObra());
            stmt.setInt(2, obra.getAutorPrincipal().getCodigoAutor());
            stmt.setInt(3, obra.getAnoPublicacao());
            stmt.setString(4, obra.getSituacaoObra());
            stmt.setInt(5, obra.getEditoraObra().getCodigoEditora());
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
    
    public boolean alter(Obra obra) throws SQLException{
        try{
            String sql = "update obra set tituloora = ?, codigoautorprincipal=?, " +
                    "anopublicacao = ?, situacaoobra = ?, codigoeditoraobra = ? where "+
                    "codigoobra = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, obra.getTituloObra());
            stmt.setInt(2, obra.getAutorPrincipal().getCodigoAutor());
            stmt.setInt(3, obra.getAnoPublicacao());
            stmt.setString(4, obra.getSituacaoObra());
            stmt.setInt(5, obra.getEditoraObra().getCodigoEditora());
            stmt.setInt(6, obra.getCodigoObra());
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
    
    public boolean delete(int codigoObra) throws SQLException{
        try{
            String sql = "delete from obra where codigoobra = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigoObra);
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
    
    public List<Obra> selectAll() throws SQLException{
        try{
            List<Obra> _lstObra = new ArrayList<Obra>();
            String sql = "select o.*, a.*, e.* from obra o " + 
                    "join autor a on a.codigoautor = o.codigoautorprincipal " + 
                    "join editora e on e.codigoeditora = o.codigoeditoraobra " ;
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Obra obra = new Obra();
                Editora editora = new Editora();
                Autor autor = new Autor();
                
                obra.setCodigoObra(rs.getInt("codigoobra"));
                obra.setTituloObra(rs.getString("tituloobra"));
                obra.setAnoPublicacao(rs.getInt("anopublicacaoobra"));
                obra.setSituacaoObra(rs.getString("situacaoobra"));
                
                autor.setCodigoAutor(rs.getInt("codigoautor"));
                autor.setNomeAutor(rs.getString("nomeautor"));
                obra.setAutorPrincipal(autor);
                
                editora.setCodigoEditora(rs.getInt("codigoeditora"));
                editora.setNomeEditora(rs.getString("nomeeditora"));
                obra.setEditoraObra(editora);
                
                _lstObra.add(obra);
                obra = null;
                editora = null;
                autor = null;
            }
            rs.close();
            return _lstObra;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            
            stmt.close();
            conn.close();
        }
    }
    
    public List<Obra> select(Obra pObra) throws SQLException{
        try
        {
            List<Obra> _lstObra = new ArrayList<Obra>();
            String sql = "select o.*, a.*, e.* from obra o " + 
                    "join autor a on a.codigoautor = o.codigoautorprincipal " + 
                    "join editora e on e.codigoeditora = o.codigoeditoraobra "+
                    "where o.codigoobra like ? and o.tituloobra like ? " +
                    "and o.anopublicacaoobra like ? and o.situacaoobra like ? " +
                    "and a.codigoautor like ? and e.codigoeditora like ?  ";
            
            String strCodigoObra = pObra.getCodigoObra() == 0 ? "" : Integer.toString(pObra.getCodigoObra());
            String strAnoPublicacao = pObra.getAnoPublicacao() == 0 ? "" : Integer.toString(pObra.getAnoPublicacao());
            String strCodigoAutor = pObra.getAutorPrincipal().getCodigoAutor() == 0 ? "" :
                    Integer.toString(pObra.getAutorPrincipal().getCodigoAutor());
            String strCodigoEditora = pObra.getEditoraObra().getCodigoEditora() == 0 ? "" :
                    Integer.toString(pObra.getEditoraObra().getCodigoEditora());
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, strCodigoObra);
            stmt.setString(2, pObra.getTituloObra());
            stmt.setString(3, strAnoPublicacao);
            stmt.setString(4, pObra.getSituacaoObra());
            stmt.setString(5, strCodigoAutor);
            stmt.setString(6, strCodigoEditora);
            ResultSet rs = stmt.executeQuery();
            
           while(rs.next()){
                Obra obra = new Obra();
                Editora editora = new Editora();
                Autor autor = new Autor();
                
                obra.setCodigoObra(rs.getInt("codigoobra"));
                obra.setTituloObra(rs.getString("tituloobra"));
                obra.setAnoPublicacao(rs.getInt("anopublicacaoobra"));
                obra.setSituacaoObra(rs.getString("situacaoobra"));
                
                autor.setCodigoAutor(rs.getInt("codigoautor"));
                autor.setNomeAutor(rs.getString("nomeautor"));
                obra.setAutorPrincipal(autor);
                
                editora.setCodigoEditora(rs.getInt("codigoeditora"));
                editora.setNomeEditora(rs.getString("nomeeditora"));
                obra.setEditoraObra(editora);
                
                _lstObra.add(obra);
                obra = null;
                editora = null;
                autor = null;
            }
            
            rs.close();
            return _lstObra;
        }catch(Exception e){
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
}
