package br.com.anhanguera.pos.biblioteca.controller;

import br.com.anhanguera.pos.biblioteca.dao.EnderecoDAO;
import br.com.anhanguera.pos.biblioteca.dao.ReservaDAO;
import br.com.anhanguera.pos.biblioteca.dao.UsuarioDAO;
import br.com.anhanguera.pos.biblioteca.entidade.Reserva;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class ReservaController {
    
    public static String msg = "O campo {CAMPO} é obrigatório.";
    
    private static boolean valid(Reserva reserva){
        if(reserva.getCodigoCliente() == 0){
            msg.replace("{CAMPO}", "Cliente");
            return false; 
        }else if(reserva.getCodigoObra() == 0){
            msg.replace("{CAMPO}", "Obra");
            return false; 
        }else if(reserva.getDataReserva() == null){
            msg.replace("{CAMPO}", "DataReserva");
            return false; 
        }else if(reserva.getDataRetirada() == null){
            msg.replace("{CAMPO}", "DataRetirada");
            return false; 
        }else{
            return true;
        }
    }
    
    public static boolean insert(Reserva  reserva){
        try{
            if(!valid(reserva)){
                return false;
            }
            
            new ReservaDAO().insert(reserva);
            
            return true;
        }catch(Exception e){            
            return false;
        }
    }
    
    
}
