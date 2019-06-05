package controle.BO;

import controle.DAO.ItemPedidoDAO;
import controle.VO.Item;
import controle.VO.ItemPedido;
import controle.VO.PedidoCompra;
import java.util.ArrayList;

public class ItemPedidoBo {

    ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();

    public int cadastrarPedidoCompra(int codigoUsuario) {
        return itemPedidoDAO.cadastrarPedidoCompra(codigoUsuario);
    }

    public int CadastrarPedido(int codigoItem, int novoIdPedidoCompra, int qtdade) {
        return itemPedidoDAO.cadastrarPedido (codigoItem, novoIdPedidoCompra, qtdade);
    }

       

}
