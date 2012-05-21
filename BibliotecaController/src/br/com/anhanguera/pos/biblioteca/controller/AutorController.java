/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.AutorDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Autor;
import java.util.List;

/**
 *
 * @author Valmir
 */
public class AutorController {
    private Autor autor = null;
       
    public AutorController(Autor autor){
        setAutor(autor);
    }
    
    public AutorController(){
        this(new Autor());
    }
    
    public void setAutor(Autor autor){
        this.autor = null;
        this.autor = autor;
    }
    
    public boolean insert(){
        try {
            return new AutorDAO().insert(this.autor);
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean alter(){
        try{
            return new AutorDAO().alter(this.autor);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(int codigoAutor){
        try{
            Autor _autor = new Autor();
            _autor.setCodigoAutor(codigoAutor);
            
            return new AutorDAO().delete(_autor);
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean delete(){
        try {
            return new AutorDAO().delete(autor);
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Autor> selectAll(){
        try {
            return new AutorDAO().selectAll();
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Autor> select(){
        try {
            return new AutorDAO().select(this.autor);
        } catch (Exception e) {
            return null;
        }
    }
}
