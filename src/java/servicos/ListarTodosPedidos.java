package servicos;

import controle.BO.ItemPedidoBo;
import controle.VO.ItemPedido;
import controle.VO.PedidoCompra;
import controle.VO.Usuario;
import controle.integracao.PedidoCompraDAOJSON;
import controle.integracao.UsuarioDAOJSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarTodosPedidos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object usuario = request.getSession().getAttribute("usuarioautenticado");

        Usuario dadosDoUsuario = (Usuario) usuario;
        int usuarioAutenticado = dadosDoUsuario.getCodigoUsuario();

        ArrayList<PedidoCompra> pedidosCompra = new ArrayList<PedidoCompra>();

        ItemPedidoBo itemPedidoBo = new ItemPedidoBo();
        pedidosCompra = itemPedidoBo.BuscarTodosOsPedidos(usuarioAutenticado);
        String pedidoCompraJSON = null;

        if (pedidosCompra != null) {

            PedidoCompraDAOJSON pedidoCompraDAOJSON = new PedidoCompraDAOJSON();
            pedidoCompraJSON = pedidoCompraDAOJSON.serializa(pedidosCompra);

            PrintWriter out = response.getWriter();
            out.print(pedidoCompraJSON);

            System.out.println("O item JSON é: " + pedidoCompraJSON);
        } else {
            System.out.println("A pesquisa do item retornou vazio. Sem item!");
        }

    }
}
