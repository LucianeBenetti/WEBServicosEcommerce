package servicos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controle.BO.ItemPedidoBo;
import controle.BO.UsuarioBo;
import controle.VO.Item;
import controle.VO.ItemPedido;
import controle.VO.PedidoCompra;
import controle.VO.Usuario;
import controle.integracao.ItemDAOJSON;
import controle.integracao.ItemPedidoDAOJSON;
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
        
        Gson gsonItem = new GsonBuilder().create();
        ArrayList<Item> itemFromJSON = (ArrayList<Item>) gsonItem.fromJson(itensDoPedido,
                new TypeToken<ArrayList<Item>>() {
                }.getType());
        
        Gson gsonQtdade = new GsonBuilder().create();
        ArrayList<Integer> quantidadadesFromJSON = (ArrayList<Integer>) gsonQtdade.fromJson(quantidadeItens,
                new TypeToken<ArrayList<Integer>>() {
                }.getType());
        
        Usuario usuarioParaListarPedidos = new Usuario();
        usuarioParaListarPedidos.setCodigoUsuario(usuarioFromJSON.getCodigoUsuario());
        
        int codigoUsuarioAutenticado = usuarioParaListarPedidos.getCodigoUsuario();
        
        Usuario dadosUsuario = (Usuario) usuarioFromJSON;
        ArrayList<Item> pedidoFechado = (ArrayList<Item>) itemFromJSON;
        ArrayList<Integer> qtidades = (ArrayList<Integer>) quantidadadesFromJSON;
        
        Double valorTotal = new Double(total);
        System.out.println("valorTotal " + valorTotal);
        Item itemPedido = new Item();
        
        Usuario usuario = null;
        UsuarioBo usuarioBo = null;
        ItemPedidoBo itemPedidoBo = null;
        
        itemPedidoBo = new ItemPedidoBo();
        int novoCodigoPedidoCompra = itemPedidoBo.cadastrarPedidoCompra(dadosUsuario.getCodigoUsuario(), valorTotal);
        int qtdade = 0;
        double totalDoPedido = 0.0;
        if (novoCodigoPedidoCompra > 0) {
            for (int j = 0; j < pedidoFechado.size(); j++) {
                if (qtidades.get(j) > 0) {
                    itemPedido.setCodigoItem(pedidoFechado.get(j).getCodigoItem());
                    qtdade = qtidades.get(j);
                    itemPedidoBo = new ItemPedidoBo();
                    int novoCodigoItemPedido = itemPedidoBo.CadastrarPedido(itemPedido.getCodigoItem(), novoCodigoPedidoCompra, qtdade);
                    if (novoCodigoItemPedido > 0) {
                     String itemPedidoJSON = null;   
                        ItemPedido itemPedidoFechado = new ItemPedido();
                        itemPedidoFechado.getCodigoItemPedido();
                        itemPedidoFechado.getItem();
                        itemPedidoFechado.getPedidoCompra();
                        itemPedidoFechado.getQuantidade();
                        
                        ItemPedidoDAOJSON itemPedidoDAOJSON = new ItemPedidoDAOJSON();
                       itemPedidoJSON = itemPedidoDAOJSON.serializaParaJSON(itemPedidoFechado);
                        
                       // System.out.print("itempedidoserializado" + itemPedidoDAOJSON);
                        PrintWriter out = response.getWriter();
                        out.print(itemPedidoJSON);
                        
                    } else {
                        System.out.println("A pesquisa do item retornou vazio. Sem item!");
                    }
                }
            }
        }
    }
    
}
