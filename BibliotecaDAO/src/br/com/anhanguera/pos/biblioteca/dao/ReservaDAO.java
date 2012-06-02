/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.biblioteca.dao;

import br.com.anhanguera.pos.biblioteca.entidade.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Fabio
 */
public class ReservaDAO {

    private Connection conn;
    private PreparedStatement stmt = null;

    public ReservaDAO() {
        conn = new ConnectionFactory().getConnection();
    }

    public boolean insert(Reserva reserva) throws SQLException {
        try {
            String sql = "insert into Reserva (codigoobra, codigocliente, datareserva, dataretirada, codigousuario) values (?,?,?,?,?)";
            java.util.Date data = new java.util.Date();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, reserva.getCodigoObra());
            stmt.setInt(2, reserva.getCodigoCliente());
            stmt.setDate(3, new java.sql.Date(reserva.getDataReserva().getTime()));
            stmt.setDate(4, new java.sql.Date(reserva.getDataRetirada().getTime()));
            stmt.setInt(5, reserva.getCodigoUsuario());
            stmt.execute();
            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
            stmt.close();
        }
    }

    public boolean update(Reserva reserva) throws SQLException {
        try {
            String sql = "update Reserva set codigoobra=?, codigocliente=?, datareserva=?, dataretirada=?, codigousuario=? where codigocliente=?";
            java.util.Date data = new java.util.Date();
            java.sql.Date nova_data = new java.sql.Date(data.getTime());
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, reserva.getCodigoObra());
            stmt.setInt(2, reserva.getCodigoCliente());
            stmt.setDate(3, nova_data);
            stmt.setDate(4, nova_data);
            stmt.setInt(5, reserva.getCodigoUsuario());
            stmt.setInt(6, reserva.getCodigoReserva());
            stmt.execute();

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
            stmt.close();
        }
    }

    public boolean delete(Reserva reserva) throws SQLException {
        try {
            String sql = "delete from Reserva where codigoreserva=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, reserva.getCodigoReserva());
            stmt.execute();

            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
            stmt.close();
        }
    }
    
}
