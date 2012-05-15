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
    
    public EditoraController(Editora editora){
        this.editora = editora;
    }
    
    public EditoraController(){}
    
    public boolean insert(){
        try{
            return new EditoraDAO().insert(this.editora);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean alter(){
        try{
            return new EditoraDAO().alter(this.editora);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(int codigoEditora){
        try{
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
}
