/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleywson.controle;

import br.gleywson.modelo.Pedido;
import br.gleywson.modelo.dao.PedidoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author gleywson
 */
@ManagedBean
@RequestScoped
public class PedidoController {

   private PedidoDao dao = new PedidoDao();
   
   private List<Pedido> pedidosMedicina;
   private List<Pedido> pedidoSepse;
   private List<Pedido> pedidosUrgentes;

    public PedidoController() {
        pedidosMedicina = dao.getPedidosMedicina();
        pedidoSepse = dao.getPedidosSepse();
        pedidosUrgentes = dao.getPedidosUrgentes();
    }

    public List<Pedido> getPedidosMedicina() {
        return pedidosMedicina;
    }

    public List<Pedido> getPedidoSepse() {
        return pedidoSepse;
    }

    public List<Pedido> getPedidosUrgentes() {
        return pedidosUrgentes;
    }
    
    
}
