/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.modelo.dao;

import br.gleywson.factory.ConnectionFactory;
import br.gleywson.modelo.Pedido;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gleywson
 */
public class PedidoDao implements Serializable {

    public List<Pedido> getPedidosMedicina() {
        Connection connection = null;
        List<Pedido> lista = new ArrayList<Pedido>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.createConnectionToOracle();
            statement = connection.prepareStatement("SELECT * FROM LAB_MEDICINA");
            rs = statement.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();

                pedido.setCodigo(rs.getInt("pedido"));
                pedido.setSetor(rs.getString("setor"));
                pedido.setDataPedido(rs.getTimestamp("dh_pedido"));

                lista.add(pedido);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {

                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
    
    public List<Pedido> getPedidosSepse() {
        Connection connection = null;
        List<Pedido> lista = new ArrayList<Pedido>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.createConnectionToOracle();
            statement = connection.prepareStatement("SELECT * FROM LAB_SEPSE");
            rs = statement.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();

                pedido.setCodigo(rs.getInt("pedido"));
                pedido.setSetor(rs.getString("setor"));
                pedido.setDataPedido(rs.getTimestamp("dh_pedido"));

                lista.add(pedido);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) {

                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}
