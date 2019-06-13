package servicos;

import controle.BO.ItemPedidoBo;
import controle.VO.ItemPedido;
import controle.integracao.ItemDAOJSON;
import controle.integracao.ItemPedidoDAOJSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaisVendidos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String itemPedidoJson = null;
        ItemPedidoBo itemPedidoBO = new ItemPedidoBo();
        ArrayList<ItemPedido> itensMaisVendidos = new ArrayList<ItemPedido>();
        itensMaisVendidos = itemPedidoBO.buscarItensMaisVendidos();

        if (itensMaisVendidos != null) {

            ItemPedidoDAOJSON itemPedidoDAOJSON = new ItemPedidoDAOJSON();
            itemPedidoJson = itemPedidoDAOJSON.serializa(itensMaisVendidos);

            PrintWriter out = response.getWriter();
            out.print(itemPedidoJson);

            //System.out.println("O item JSON é: " + itemJson);
        } else {
            System.out.println("A pesquisa do item retornou vazio. Sem item!");
        }

    }
}
