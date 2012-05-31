/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.UtilDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author rafaelpoveda
 */
public class UtilController {
    
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
    
    public static Date convertDate(String pStrDate){
        try{
            DateFormat form = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date(form.parse(pStrDate).getTime());
            return data;
        }catch(Exception e){
            return null;
        }
    }
    
    public static java.sql.Date convertDataForDateSql(java.util.Date data){
        try{
            
            java.sql.Date dataSql = new java.sql.Date(data.getTime());
            return dataSql;
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static String convertDateForString(java.util.Date date){
        try{
            SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
            Date newDate = form.parse(date.toString());
            return (form.format(newDate));
        }catch(Exception e){
            return null;
        }
    }
}
