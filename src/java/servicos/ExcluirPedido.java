package servicos;

import controle.BO.ItemPedidoBo;
import controle.BO.PedidoCompraBo;
import controle.VO.PedidoCompra;
import controle.integracao.PedidoCompraDAOJSON;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirPedido extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codigoPedido = new Integer(request.getParameter("codigopedido"));
        System.out.println("O código do pedido no servidor é: " + codigoPedido);

        ItemPedidoBo itemPedidoBo = new ItemPedidoBo();
        PedidoCompraBo pedidoCompraBo = new PedidoCompraBo();

        if (itemPedidoBo.cancelarCodigoDoPedidoCompra(codigoPedido)) {

            boolean pedidoDeCompraCancelado = pedidoCompraBo.excluirPedidoDoUsuario(codigoPedido);
            String pedidoCompraJSON = null;
            PedidoCompra pedidoCompra = new PedidoCompra();         
                 
            if (pedidoDeCompraCancelado) {
                pedidoCompra.setCodigoPedido(codigoPedido);
          
                PedidoCompraDAOJSON pedidoCompraDAOJSON = new PedidoCompraDAOJSON();
                pedidoCompraJSON = pedidoCompraDAOJSON.serializaExcluir(pedidoCompra);

                PrintWriter out = response.getWriter();
                out.print(pedidoCompraJSON);
            } else {
                System.out.println("A pesquisa do item retornou vazio. Sem item!");
            }

        }

    }
}

