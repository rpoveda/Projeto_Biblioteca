package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.EditoraDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Editora;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class EditoraController {
    
    public static String msg = "O campo {CAMPO} é obrigatório.";
    
    private static boolean isValid(Editora e, boolean bValidaCodigo){
        
        if(bValidaCodigo && e.getCodigoEditora() == 0)
        { msg.replace("{CAMPO}", "Código"); return false; }
        else if (e.getNomeEditora().equals(null))
        { msg.replace("{CAMPO}", "Nome"); return false; }
        else if (e.getCidadeEditora().equals(null))
        { msg.replace("{CAMPO}", "Cidade"); return false; }
        else
            return true;
    }
    
    
    public EditoraController(){}
    
    public boolean insert(Editora editora){
        try{
            
            if(!isValid(editora, false))
                return false;
            
            return new EditoraDAO().insert(editora);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean alter(Editora editora){
        try{
            
            if(!isValid(editora, true))
                return false;
            
            if(!new EditoraDAO().exist(editora.getCodigoEditora()))
                return false;
            else
                return new EditoraDAO().alter(editora);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(int codigoEditora){
        try{
            
            if(!new EditoraDAO().exist(codigoEditora))
                return false;
            
            if(codigoEditora == 0)
                return false;
            else
                return new EditoraDAO().delete(codigoEditora);
        }catch(Exception e){
            return false;
        }
    }
    
    public List<Editora> selectAll(){
        try{
            return new EditoraDAO().selectAll();
        }catch(Exception e){
            return null;
        }
    }
    
    public List<Editora> select(Editora editora){
        try{
            return new EditoraDAO().select(editora);
        }catch(Exception e){
            return null;
        }
    }
    
    public void TruncaTable()
    {
        new EditoraDAO().TruncaTable();
    }
}
