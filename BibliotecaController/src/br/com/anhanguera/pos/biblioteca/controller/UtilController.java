/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.UtilDAO;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author rafaelpoveda
 */
public class UtilController {
    
    public Object recebeInfo(){
        int oi = 0;
        return oi;
    }
    
    public static int recebeNumerico(JTextField objTextField, String campo){
        int valor = 0;
        boolean b = true;
        do{
            
            try{
                valor = Integer.parseInt(objTextField.getText());
                b = true;
            }catch(Exception e){
                b = false;
                //JOptionPane.showMessageDialog(null, "Digite apenas números no campo: " + campo);
            }
            
        }while(!b);
        
        return valor;
    }
    
    public int nextId(String table, String field){
        return new UtilDAO().nextId(table, field);
    }
    
}
