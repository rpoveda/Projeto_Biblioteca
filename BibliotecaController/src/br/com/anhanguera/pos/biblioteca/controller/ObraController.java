package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.ObraDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Obra;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class ObraController {
    
    public static String msg = "O campo {CAMPO} é obrigatório.";
    
    private static boolean isValid(Obra obra, boolean bValidaCodigo){
        if(bValidaCodigo && obra.getCodigoObra() == 0)
        { msg.replace("{CAMPO}", "Código");   return false; }
        else if(obra.getTituloObra().equals(null))
        { msg.replace("{CAMPO}", "Titulo");   return false; }
        else if(obra.getAutorPrincipal().getCodigoAutor() == 0)
        { msg.replace("{CAMPO}", "Autor");   return false; }
        else if(obra.getSituacaoObra().equals(null))
        { msg.replace("{CAMPO}", "Situação");   return false; }
        else if(obra.getEditoraObra().getCodigoEditora() == 0)
        { msg.replace("{CAMPO}", "Editora");   return false; }
        else
            return true;
    }
    
    public ObraController(){ }
    
    public boolean insert(Obra obra){
        try{
            
            if(!isValid(obra,false))
                return false;
            
            return new ObraDAO().insert(obra);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean alter(Obra obra){
        try{
            
            if(!isValid(obra, true))
                return false;
            
            return new ObraDAO().alter(obra);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(int pintCodigoObra){
        try{
            
            if(pintCodigoObra == 0)
                return false;
            
            return new ObraDAO().delete(pintCodigoObra);
        }catch(Exception e){
            return false;
        }
    }
    
    public List<Obra> selectAll(){
        try
        {
            return new ObraDAO().selectAll();
        }catch(Exception e){
            return null;
        }
    }
    
    public List<Obra> select(Obra obra){
        try{
            return new ObraDAO().select(obra);
        }catch(Exception e){
            return null;
        }
    }
    
    public int ultimoRegistro(){
        try{
            return new ObraDAO().ultimoRegistro();
        }catch(Exception e){
            return 0;
        }
    }
    
}
