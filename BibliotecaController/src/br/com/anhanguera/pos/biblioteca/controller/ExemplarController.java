package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.ExemplarDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Exemplar;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class ExemplarController {

    public static String msg = "O campo {CAMPO} é obrigatório.";
    
    private static boolean isValid(Exemplar e, boolean bValidaCodigo){
        if(bValidaCodigo && e.getCodigoExemplar() == 0)
        { msg.replace("{CAMPO}", "Código"); return false; }
        else if (e.getObra().getCodigoObra() == 0)
        { msg.replace("{CAMPO}", "Obra"); return false; }
        else if (e.getSituacaoExemplar().equals(null))
        { msg.replace("{CAMPO}", "Situação"); return false; }
        else
            return false;
    }

    public ExemplarController(){ }
    
    public boolean insert(Exemplar exemplar){
        try{
            
            if(!isValid(exemplar, false))
                return false;
            
            return new ExemplarDAO().insert(exemplar);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean alter(Exemplar exemplar){
        try{
            
            if(!isValid(exemplar, true))
                return false;
            
            return new ExemplarDAO().alter(exemplar);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(int intCodigoExemplar, int intCodigoObra){
        try{
            
            if(intCodigoExemplar == 0 || intCodigoObra == 0)
                return false;
            
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
    
    public List<Exemplar> select(Exemplar exemplar){
        try{
            return new ExemplarDAO().select(exemplar);
        }catch(Exception e){
            return null;
        }
    }
}
