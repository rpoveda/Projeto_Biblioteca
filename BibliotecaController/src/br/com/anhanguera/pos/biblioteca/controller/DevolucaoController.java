package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.DevolucaoDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Devolucao;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class DevolucaoController {
    
    public static String msg = "O campo {CAMPO} é obrigatório.";
    
    public static boolean isValid(Devolucao devolucao, boolean bValidaCodigo){
        
        if(bValidaCodigo && devolucao.getCodigoDevolucao() == 0)
        { msg = msg.replace("{CAMPO}", "Código devolução");   return false; }
        else if(devolucao.getExemplar().getCodigoExemplar() == 0)
        { msg = msg.replace("{CAMPO}", "Código exemplar");   return false; }
        else if(devolucao.getUsuarioDevoluca().getCodigoUsuario() == 0)
        { msg = msg.replace("{CAMPO}", "Código usuário");   return false; }
        else
            return true;
    }
    
    public static boolean insert(Devolucao devolucao){
        try{
            
            if(!isValid(devolucao, false))
                return false;
            else
                return new DevolucaoDAO().insert(devolucao);
            
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean update(Devolucao devolucao){
        try{
            
            if(!isValid(devolucao, true))
                return false;
            else
                return new DevolucaoDAO().update(devolucao);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean delete(int pintCodigoDevolucao){
        try{
            return new DevolucaoDAO().delete(pintCodigoDevolucao);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<Devolucao> selectAll(){
        try{
            return new DevolucaoDAO().selectAll();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static List<Devolucao> select(Devolucao devolucao){
        try{
            return new DevolucaoDAO().select(devolucao);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
