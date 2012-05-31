package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.EnderecoDAO;
import br.com.anhanguera.pos.biblioteca.dao.UsuarioDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Usuario;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class UsuarioController {
    
    public static String msg = "O campo {CAMPO} é obrigatório.";
    
    private static boolean isValid(Usuario usuario, boolean bvalidaCodigo){
        if(usuario.getNomeUsuario().equals(""))
        {   msg.replace("{CAMPO}", "Nome");  return false; }
        else if(usuario.getCpfUsuario() == 0)
        {   msg.replace("{CAMPO}", "CPF"); return false; }
        else if(usuario.getTelefoneUsuario().equals(""))
        {   msg.replace("{CAMPO}", "Telefone");  return false; }
        else if(bvalidaCodigo && usuario.getCodigoUsuario() == 0)
        { msg.replace("{CAMPO}", "Código"); return false; }
        else
            return true;
    }
    
    public static boolean insert(Usuario usuario){
        try{
            if(!isValid(usuario, false))
                return false;
            
            int iCodigoEndereco = 0;
            iCodigoEndereco = new EnderecoDAO().insert(usuario.getEndereco());
            if(iCodigoEndereco != 0)
            {
                usuario.getEndereco().setCodigoEndereco(iCodigoEndereco);
                return new UsuarioDAO().insert(usuario);
            }else
                return false;
        }catch(Exception e){
            
            return false;
        }
    }
    
    public static boolean update(Usuario usuario){
        try{
            
            if(!isValid(usuario, true))
                return false;
            
            if(new EnderecoDAO().update(usuario.getEndereco()) && new UsuarioDAO().update(usuario))
            {
                return true;
            }else
            {
                return false;
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean delete(int pintCodigoUsuario, int pintCodigoEndereco){
        try{
            if(new EnderecoDAO().delete(pintCodigoEndereco) && new UsuarioDAO().delete(pintCodigoUsuario))
                return true;
            else
                return false;
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<Usuario> selectAll(){
        try{
            return new UsuarioDAO().selectAll();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static List<Usuario> select(Usuario usuario){
        try{
            return new UsuarioDAO().select(usuario);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static boolean exist(int pintCodigoUsuario){
        try{
            return new UsuarioDAO().exist(pintCodigoUsuario);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
