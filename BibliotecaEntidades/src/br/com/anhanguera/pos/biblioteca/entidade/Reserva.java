/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.entidade;

import java.util.Date;

/**
 *
 * @author Fabio
 */
public class Reserva {

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoObra() {
        return codigoObra;
    }

    public void setCodigoObra(int codigoObra) {
        this.codigoObra = codigoObra;
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(int codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }
    private int codigoReserva;
    private int codigoObra;
    private int codigoCliente;
    private Date dataReserva;
    private Date dataRetirada;
    private int codigoUsuario;
    
}
