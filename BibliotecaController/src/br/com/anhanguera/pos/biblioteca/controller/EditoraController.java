package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.EditoraDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Editora;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class EditoraController {
    
    private Editora editora;
    public static String msgErro = "";
    
    public EditoraController(Editora editora){
        this.editora = editora;
    }
    
    public EditoraController(){}
    
    public boolean insert(){
        try{
            if(this.editora.getNomeEditora().equals(null))
                return false;
            else if(this.editora.getCidadeEditora().equals(null))
                return false;
            else
                return new EditoraDAO().insert(this.editora);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean alter(){
        try{
            if(!new EditoraDAO().exist(this.editora.getCodigoEditora()))
                return false;
            
            if(this.editora.getCodigoEditora() == 0)
                return false;
            else if (this.editora.getNomeEditora().equals(null))
                return false;
            else if (this.editora.getCidadeEditora().equals(null))
                return false;
            else
                return new EditoraDAO().alter(this.editora);
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
    
    public List<Editora> select(){
        try{
            return new EditoraDAO().select(this.editora);
        }catch(Exception e){
            return null;
        }
    }
    
    public void TruncaTable()
    {
        new EditoraDAO().TruncaTable();
    }
}
