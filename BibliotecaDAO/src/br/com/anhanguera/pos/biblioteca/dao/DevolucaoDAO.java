package br.com.anhanguera.pos.biblioteca.dao;

import br.com.anhanguera.pos.biblioteca.entidade.Devolucao;
import br.com.anhanguera.pos.biblioteca.entidade.Exemplar;
import br.com.anhanguera.pos.biblioteca.entidade.Obra;
import br.com.anhanguera.pos.biblioteca.entidade.Usuario;
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
public class DevolucaoDAO {
    
    private Connection conn;
    private PreparedStatement stmt;
    
    public DevolucaoDAO(){
        this.conn = new ConnectionFactory().getConnection();
        stmt = null;
    }
    
    public boolean insert(Devolucao devolucao) throws SQLException{
        try{
            String sql = "insert into devolucao (codigoexemplar, "
                    + "datadevolucao, codigousuario) values (?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, devolucao.getExemplar().getCodigoExemplar());
            stmt.setDate(2,UtilDAO.convertDataForDateSql(devolucao.getDataDevolucao()));
            stmt.setInt(3, devolucao.getUsuarioDevoluca().getCodigoUsuario());
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
    
    public boolean update(Devolucao devolucao) throws SQLException{
        try{
            String sql = "update devolucao set codigoexemplar=?, datadevolucao=?"
                    + " ,codigofuncionario=? where codigodevolicao=? ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, devolucao.getExemplar().getCodigoExemplar());
            stmt.setDate(2, UtilDAO.convertDataForDateSql(devolucao.getDataDevolucao()));
            stmt.setInt(3, devolucao.getUsuarioDevoluca().getCodigoUsuario());
            stmt.setInt(4, devolucao.getCodigoDevolucao());
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
    
    public boolean delete(int pintCodigoDevolucao) throws SQLException{
        try{
            String sql = "delte from devolucao where codigodevolucao=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pintCodigoDevolucao);
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
    
    public List<Devolucao> selectAll() throws SQLException{
        try{
            
            List<Devolucao> _lstDevolucao = new ArrayList<Devolucao>();
            String sql = " select d.codigodevolucao,d.datadevolucao, e.codigoexemplar, "
                    + " o.codigoobra, o.tituloobra,u.codigousuario, u.nomeusuario "
                    + " from devolucao d "
                    + " join exemplar e on e.codigoexemplar = d.codigoexemplar "
                    + " join obra o on o.codigoobra = e.codigoobra "
                    + " join usuario u on u.codigousuario = d.codigousuario ";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Devolucao devolucao = new Devolucao();
                Exemplar exemplar = new Exemplar();
                Usuario usuario = new Usuario();
                Obra obra = new Obra();
                
                //campos de exemplar
                exemplar.setCodigoExemplar(rs.getInt("codigoexemplar"));
                //campos de obra
                obra.setCodigoObra(rs.getInt("codigoobra"));
                obra.setTituloObra(rs.getString("tituloobra"));
                //campos de usuario
                usuario.setCodigoUsuario(rs.getInt("codigousuario"));
                usuario.setNomeUsuario(rs.getString("nomeusuario"));
                //campos devolucao
                devolucao.setCodigoDevolucao(rs.getInt("codigodevolucao"));
                devolucao.setDataDevolucao(rs.getDate("datadevolucao"));
                
                //seta objetos
                exemplar.setObra(obra);
                devolucao.setExemplar(exemplar);
                devolucao.setUsuarioDevoluca(usuario);
                
                _lstDevolucao.add(devolucao);
            }
            
            return _lstDevolucao;
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public List<Devolucao> select(Devolucao pobjdevolucao) throws SQLException{
        try{
            List<Devolucao> _lstDevolucao = new ArrayList<Devolucao>();
            String sql = " select d.codigodevolucao,d.datadevolucao, e.codigoexemplar, "
                    + " o.codigoobra, o.tituloobra,u.codigousuario, u.nomeusuario "
                    + " from devolucao d "
                    + " join exemplar e on e.codigoexemplar = d.codigoexemplar "
                    + " join obra o on o.codigoobra = e.codigoobra "
                    + " join usuario u on u.codigousuario = d.codigousuario "
                    + " where d.codigodevolucao like '%%' and d.datadevolucao like '%%' "
                    + " and e.codigoobra like '%%' and o.tituloobra like '%%' and"
                    + " u.nomeusuario like '%%' ";
            String strCodigoDevolucao = (pobjdevolucao.getCodigoDevolucao() == 0) ? "" : Integer.toString(pobjdevolucao.getCodigoDevolucao());
            String strCodigoObra = (pobjdevolucao.getExemplar().getObra().getCodigoObra() == 0) ? "" : Integer.toString(pobjdevolucao.getExemplar().getObra().getCodigoObra());
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + strCodigoDevolucao + "%");
            stmt.setString(2, "%" + pobjdevolucao.getDataDevolucao().toString() + "%");
            stmt.setString(3, strCodigoObra);
            stmt.setString(4, pobjdevolucao.getExemplar().getObra().getTituloObra());
            stmt.setString(5, pobjdevolucao.getUsuarioDevoluca().getNomeUsuario());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Devolucao devolucao = new Devolucao();
                Exemplar exemplar = new Exemplar();
                Usuario usuario = new Usuario();
                Obra obra = new Obra();
                
                //campos de exemplar
                exemplar.setCodigoExemplar(rs.getInt("codigoexemplar"));
                //campos de obra
                obra.setCodigoObra(rs.getInt("codigoobra"));
                obra.setTituloObra(rs.getString("tituloobra"));
                //campos de usuario
                usuario.setCodigoUsuario(rs.getInt("codigousuario"));
                usuario.setNomeUsuario(rs.getString("nomeusuario"));
                //campos devolucao
                devolucao.setCodigoDevolucao(rs.getInt("codigodevolucao"));
                devolucao.setDataDevolucao(rs.getDate("datadevolucao"));
                
                //seta objetos
                exemplar.setObra(obra);
                devolucao.setExemplar(exemplar);
                devolucao.setUsuarioDevoluca(usuario);
                
                _lstDevolucao.add(devolucao); 
            }
            
            return _lstDevolucao;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public boolean exist(int pintCodigoDevolucao)throws SQLException{
        try{
            boolean bRet = false;
            String sql = "select datadevolucao from devolucao where codigodevolucao=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pintCodigoDevolucao);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
                bRet = true;
            
            return bRet;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }
}
