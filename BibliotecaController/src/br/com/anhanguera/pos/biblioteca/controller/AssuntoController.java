package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.AssuntoDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Assunto;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class AssuntoController {
    
    public boolean insert(Assunto assunto){
        try{
            return new AssuntoDAO().insert(assunto);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean update(Assunto assunto){
        try{
            return new AssuntoDAO().update(assunto);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(int pintCodigoAssunto){
        try{
            return new AssuntoDAO().delete(pintCodigoAssunto);
        }catch(Exception e){
            return false;
        }
    }
    
    public List<Assunto> selectAll(){
        try{
            return new AssuntoDAO().selectAll();
        }catch(Exception e){
            return null;
        }
        
    }
    
    public List<Assunto> select(Assunto assunto){
        try{
            return new AssuntoDAO().select(assunto);
        }catch(Exception e){
            return null;
        }
    }
    
    public boolean insertAssuntoObra(List<Assunto> plstAssunto, int pintCodigoObra, boolean bRemoveTodos){
        try{
            return new AssuntoDAO().insertAssuntoObra(plstAssunto, pintCodigoObra, bRemoveTodos);
        }catch(Exception e){
            return false;
        }
    }
    
}
