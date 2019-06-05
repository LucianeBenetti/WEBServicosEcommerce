package servicos;

import controle.BO.ItemPedidoBo;
import controle.BO.UsuarioBo;
import controle.VO.Item;
import controle.VO.ItemPedido;
import controle.VO.PedidoCompra;
import controle.VO.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FecharPedido extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String var1 = request.getParameter("atualizarcartao");
        String var2 = request.getParameter("fecharpedido");
        String var3 = request.getParameter("sairdosistema");

        Object usuarioAutenticado = request.getSession().getAttribute("usuarioautenticado");
        Object fecharPedido = request.getSession().getAttribute("pedidocompra");

        Usuario dadosDoUsuario = (Usuario) usuarioAutenticado;
        ArrayList<ItemPedido> pedidoFechado = (ArrayList<ItemPedido>) fecharPedido;

        ArrayList<String> variavel = new ArrayList<String>();
        variavel.add(var1);
        variavel.add(var2);
        variavel.add(var3);

        Usuario usuario = null;
        ItemPedido itemPedido = null;
        UsuarioBo usuarioBo = null;
        ItemPedidoBo itemPedidoBo = null;

        for (int i = 0; i < variavel.size(); i++) {
            String var = variavel.get(i);

            if (var != null) {
                switch (var) {
                    case "atualizarcartao":

                        usuario = new Usuario();
                        usuario.setCodigoUsuario(dadosDoUsuario.getCodigoUsuario());
                        usuario.setCodigoSeguranca(dadosDoUsuario.getCodigoSeguranca());
                        usuario.setLogin(dadosDoUsuario.getLogin());
                        usuario.setSenha(dadosDoUsuario.getSenha());
                        usuario.setDataValidade(dadosDoUsuario.getDataValidade());
                        int numeroCartao = new Integer(request.getParameter("numerocartao"));
                        usuario.setNumeroCartao(numeroCartao);
                        System.out.println("A variável é : " + var);
                        usuarioBo = new UsuarioBo();
                        boolean cartaoAtualizado = usuarioBo.atualizarCartaoDoUsuario(usuario);

                        if (cartaoAtualizado) {

                            request.getSession().getAttribute("pedidocompra");
                            request.getRequestDispatcher("WEB-INF/MostrarPedido.jsp").forward(request, response);

                        }
                        break;

                    case "fecharpedido":
                        Item item = new Item();
                        itemPedidoBo = new ItemPedidoBo();
                        int novoIdPedidoCompra = itemPedidoBo.cadastrarPedidoCompra(dadosDoUsuario.getCodigoUsuario());
                        int codigoItem = 0;
                        int qtdade = 0;
                        if (novoIdPedidoCompra > 0) {
                            for (int j = 0; j < pedidoFechado.size(); j++) {
                                item.setCodigoItem(pedidoFechado.get(i).getItem().getCodigoItem());
                                itemPedido.setItem(item);
                                qtdade = pedidoFechado.get(i).getQuantidade();
                            }

//                            itemPedidoBo = new ItemPedidoBo();
//                            int novoCodigoItemPedido = itemPedidoBo.CadastrarPedido(codigoItem, novoIdPedidoCompra, qtdade);
//                            if (novoCodigoItemPedido > 0) {
//                                System.out.println("item pedido cadastrado");
//                            }
                        }
//
//                            request.getRequestDispatcher("Login.jsp").forward(request, response);
//
//                        }
                        break;

                    case "sairdosistema":

                        request.getSession().invalidate();
                        request.getRequestDispatcher("LuMarEcommerce.jsp").forward(request, response);
                        break;

                    default:

                        request.getRequestDispatcher("Login.jsp").forward(request, response);

                        break;
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
