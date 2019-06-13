package servicos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

       String usuario = request.getParameter("usuarioJSON");

        Gson gson = new GsonBuilder().create();
        Usuario usuarioFromJSON = (Usuario) gson.fromJson(usuario, Usuario.class);
        System.out.println("Servlet.AtualizarCartao.servidor()" + usuarioFromJSON);

        Usuario usuarioParaListarPedidos = new Usuario();
        usuarioParaListarPedidos.setCodigoUsuario(usuarioFromJSON.getCodigoUsuario());


        int codigoUsuarioAutenticado = usuarioParaListarPedidos.getCodigoUsuario();

        ArrayList<PedidoCompra> pedidosCompra = new ArrayList<PedidoCompra>();

        ItemPedidoBo itemPedidoBo = new ItemPedidoBo();
        pedidosCompra = itemPedidoBo.BuscarTodosOsPedidos(codigoUsuarioAutenticado);
        
        System.out.println("servicos.ListarTodosPedidos.doGet()" + pedidosCompra);
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
