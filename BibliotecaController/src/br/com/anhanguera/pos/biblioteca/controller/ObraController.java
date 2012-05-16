package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.ObraDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Obra;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class ObraController {
    
    private Obra obra;
    
    public ObraController(Obra obra){
        this.obra = obra;
    }
    
    public ObraController(){ }
    
    public boolean insert(){
        try{
            return new ObraDAO().insert(obra);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean alter(){
        try{
            return new ObraDAO().alter(obra);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(int codigoObra){
        try{
            return new ObraDAO().delete(codigoObra);
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
    
    public List<Obra> select(){
        try{
            return new ObraDAO().select(obra);
        }catch(Exception e){
            return null;
        }
    }
    
}
