package servicos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controle.BO.ItemPedidoBo;
import controle.BO.UsuarioBo;
import controle.VO.Item;
import controle.VO.PedidoCompra;
import controle.VO.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GravarPedidoNoBanco extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuarioAutenticado = request.getParameter("usuarioJSON");
        String itensDoPedido = request.getParameter("itemJson");
        String quantidadeItens = request.getParameter("qtdJson");
        String total = request.getParameter("totalDoPedido");

        Gson gsonUsuario = new GsonBuilder().create();
        Usuario usuarioFromJSON = (Usuario) gsonUsuario.fromJson(usuarioAutenticado, Usuario.class);
        System.out.println("usuraio servidor()" + usuarioFromJSON);

        Gson gsonItem = new GsonBuilder().create();
        ArrayList<Item> itemFromJSON = (ArrayList<Item>) gsonItem.fromJson(itensDoPedido,
                new TypeToken<ArrayList<Item>>() {
                }.getType());
        System.out.println("itens servidor()" + itemFromJSON);

        Gson gsonQtdade = new GsonBuilder().create();
        ArrayList<Integer> qunatidadadesFromJSON = (ArrayList<Integer>) gsonQtdade.fromJson(quantidadeItens,
                new TypeToken<ArrayList<Integer>>() {
                }.getType());
        System.out.println("qunatidades servidor()" + qunatidadadesFromJSON);

        Usuario usuarioParaListarPedidos = new Usuario();
        usuarioParaListarPedidos.setCodigoUsuario(usuarioFromJSON.getCodigoUsuario());

        int codigoUsuarioAutenticado = usuarioParaListarPedidos.getCodigoUsuario();

//        Usuario dadosDoUsuario = (Usuario) usuarioAutenticado;
//        ArrayList<Item> pedidoFechado = (ArrayList<Item>) fecharPedido;
//        ArrayList<Integer> qtidades = (ArrayList<Integer>) quantidadeItem;
//
//        double valorTotal = new Double((double) total);
//        System.out.println("valorTotal " + valorTotal);
//        Item itemPedido = new Item();
//
//        Usuario usuario = null;
//        UsuarioBo usuarioBo = null;
//        ItemPedidoBo itemPedidoBo = null;
//
//        itemPedidoBo = new ItemPedidoBo();
//        int novoCodigoPedidoCompra = itemPedidoBo.cadastrarPedidoCompra(dadosDoUsuario.getCodigoUsuario(), valorTotal);
//        int qtdade = 0;
//        double totalDoPedido = 0.0;
//        if (novoCodigoPedidoCompra > 0) {
//            for (int j = 0; j < pedidoFechado.size(); j++) {
//                if (qtidades.get(j) > 0) {
//                    itemPedido.setCodigoItem(pedidoFechado.get(j).getCodigoItem());
//                    qtdade = qtidades.get(j);
//                    itemPedidoBo = new ItemPedidoBo();
//                    int novoCodigoItemPedido = itemPedidoBo.CadastrarPedido(itemPedido.getCodigoItem(), novoCodigoPedidoCompra, qtdade);
//                    if (novoCodigoItemPedido > 0) {
//                                     System.out.println("novoCodigoItemPedido_" + j + ": " + novoCodigoItemPedido);
//                        request.setAttribute("nomedousuario", dadosDoUsuario.getLogin());
//                        request.setAttribute("codigoseguranca", dadosDoUsuario.getCodigoSeguranca());
//                        request.getRequestDispatcher("WEB-INF/PedidoFechado.jsp").forward(request, response);
//                    }
    }
}
//  }
//
//                  request.getRequestDispatcher("Login.jsp").forward(request, response);
//
//       }

//  }

  //          }
