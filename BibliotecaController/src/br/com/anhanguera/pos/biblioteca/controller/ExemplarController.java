package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.ExemplarDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Exemplar;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class ExemplarController {

    private Exemplar exemplar;
    
    public ExemplarController(Exemplar exemplar){
        this.exemplar = exemplar;
    }
    
    public ExemplarController(){ }
    
    public boolean insert(){
        try{
            return new ExemplarDAO().insert(exemplar);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean alter(){
        try{
            return new ExemplarDAO().alter(exemplar);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(int intCodigoExemplar, int intCodigoObra){
        try{
            return new ExemplarDAO().delete(intCodigoExemplar, intCodigoObra);
        }catch(Exception e){
            return false;
        }
    }
    
    public int nextCodigoExemplar(int intCodigoObra){
        try{
            return new ExemplarDAO().nextCodigoExemplar(intCodigoObra);
        }catch(Exception e){
            return 0;
        }
    }
    
    public List<Exemplar> selectAll(){
        try{
            return new ExemplarDAO().selectAll();
        }catch(Exception e ){
            return null;
        }
    }
    
    public List<Exemplar> select(){
        try{
            return new ExemplarDAO().select(exemplar);
        }catch(Exception e){
            return null;
        }
    }
}
