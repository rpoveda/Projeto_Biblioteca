package br.com.anhanguera.pos.biblioteca.dao;

import br.com.anhanguera.pos.biblioteca.entidade.Endereco;
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
public class UsuarioDAO {

    private Connection conn;
    private PreparedStatement stmt = null;
    
    public UsuarioDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(Usuario usuario) throws SQLException{
        try{
            String sql = "insert into usuario (nomeusuario, codigoendereco, telefoneusuario, cpfusuario) "
                    + "values (?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setInt(2, usuario.getEndereco().getCodigoEndereco());
            stmt.setString(3, usuario.getTelefoneUsuario());
            stmt.setInt(4, usuario.getCpfUsuario());
            stmt.execute();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            conn.close();
            stmt.close();
        }
    }
    
    public boolean update(Usuario usuario) throws SQLException{
        try{
            String sql = "update usuario set nomeusuario=?, codigoendereco=?, telefoneusuario=?, cpfusuario=?"
                    + " where codigousuario=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setInt(2, usuario.getEndereco().getCodigoEndereco());
            stmt.setString(3, usuario.getTelefoneUsuario());
            stmt.setInt(4, usuario.getCpfUsuario());
            stmt.setInt(5, usuario.getCodigoUsuario());
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
    
    public boolean delete(int pintCodigoUsuario) throws SQLException{
        try{
            String sql = "delete from usuario where codigousuario=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pintCodigoUsuario);
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
    
    public List<Usuario> selectAll() throws SQLException{
        try{
            List<Usuario> _lstUsuario = new ArrayList<Usuario>();
            String sql = "select * from usuario";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                //Endereco endereco = new Endereco();
                usuario.setCodigoUsuario(rs.getInt("codigousuario"));
                usuario.setNomeUsuario(rs.getString("nomeusuario"));
                usuario.setTelefoneUsuario("telefoneusuario");
                usuario.setCpfUsuario(rs.getInt("cpfusuario"));
                usuario.setEndereco(new EnderecoDAO().select(rs.getInt("codigoendereco")));
                _lstUsuario.add(usuario);
            }
            
            return _lstUsuario;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public Usuario obter(int pintCodigoUsuario) throws SQLException{
        try{
            Usuario usuario = new Usuario();
            String sql = "select * from usuario where codigousuario =?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pintCodigoUsuario);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                usuario.setCodigoUsuario(rs.getInt("codigousuario"));
                usuario.setNomeUsuario(rs.getString("nomeusuario"));
                usuario.setTelefoneUsuario("telefoneusuario");
                usuario.setCpfUsuario(rs.getInt("cpfusuario"));
                usuario.setEndereco(new EnderecoDAO().select(rs.getInt("codigoendereco")));
            }
            
            return usuario;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public List<Usuario> select(Usuario pusuario) throws SQLException{
        try{
            List<Usuario> _lstUsuario = new ArrayList<Usuario>();
            String sql = " select u.*, e.* from usuario u "
                    + " join endereco e on e.codigoendereco = u.codigoendereco "
                    + " where u.codigousuario like ? and u.nomeusuario like ? "
                    + " and u.cpfusuario like ? and e.cidadeendereco like ? "
                    + " and e.estadoendereco like ? and e.cependereco like ? ";
            String strCodigoUsuario = (pusuario.getCodigoUsuario() == 0) ? "" : Integer.toString(pusuario.getCodigoUsuario());
            String strCpfUsuario = (pusuario.getCpfUsuario() == 0) ? "" : Integer.toString(pusuario.getCpfUsuario());
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" +  strCodigoUsuario + "%");
            stmt.setString(2, "%" + pusuario.getNomeUsuario() + "%");
            stmt.setString(3, "%" + strCpfUsuario + "%");
            stmt.setString(4, "%" + pusuario.getEndereco().getCidade() + "%");
            stmt.setString(5, "%" + pusuario.getEndereco().getEstado() + "%");
            stmt.setString(6, "%" + pusuario.getEndereco().getCepEndereco() + "%");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                Endereco endereco = new Endereco();
                usuario.setCodigoUsuario(rs.getInt("codigousuario"));
                usuario.setNomeUsuario(rs.getString("nomeusuario"));
                usuario.setTelefoneUsuario("telefoneusuario");
                usuario.setCpfUsuario(rs.getInt("cpfusuario"));
                /*endereco.setCodigoEndereco(rs.getInt("codigoendereco"));
                endereco.setRua(rs.getString("ruaendereco"));
                endereco.setNumEndereco(rs.getInt("numendereco"));
                endereco.setBairro(rs.getString("bairroendereco"));
                endereco.setCidade(rs.getString("cidadeendereco"));
                endereco.setEstado(rs.getString("estadoendereco"));
                endereco.setComplemento(rs.getString("complementoendereco"));
                endereco.setCepEndereco(rs.getString("cependereco"));*/
                usuario.setEndereco(new EnderecoDAO().select(rs.getInt("codigoendereco")));
                
                _lstUsuario.add(usuario);
            }
            return _lstUsuario;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
    public boolean exist(int pintCodigoUsuario) throws SQLException{
        try{
            boolean bResult = false;
            String sql = "Select nomeusuario from usuario where codigousuario=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pintCodigoUsuario);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
                bResult = true;
            
            return bResult;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            stmt.close();
            conn.close();
        }
    }
    
}
