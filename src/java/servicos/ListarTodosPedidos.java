package servicos;

import controle.BO.ItemPedidoBo;
import controle.VO.ItemPedido;
import controle.VO.PedidoCompra;
import controle.VO.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarTodosPedidos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Object usuario = request.getSession().getAttribute("usuarioautenticado");

        Usuario dadosDoUsuario = (Usuario) usuario;
        int usuarioAutenticado = dadosDoUsuario.getCodigoUsuario();

        ArrayList<PedidoCompra> pedidosCompra = new ArrayList<PedidoCompra>();
        ArrayList<PedidoCompra> pedidosDeCompraDoUsuario = new ArrayList<PedidoCompra>();

        ItemPedidoBo itemPedidoBo = new ItemPedidoBo();
        pedidosCompra = itemPedidoBo.BuscarTodosOsPedidos(usuarioAutenticado);
        int codigoDoUsuario = 0;

        if (pedidosCompra != null) {
            for (int i = 0; i < pedidosCompra.size(); i++) {
                codigoDoUsuario = pedidosCompra.get(i).getUsuario().getCodigoUsuario();

                if (usuarioAutenticado == codigoDoUsuario) {

                    int codigoPedidoDoUsuario = pedidosCompra.get(i).getCodigoPedido();
                    Date dataDoPedidoDoUsuario = (Date) pedidosCompra.get(i).getDataPedido();
                    double valorTotalDoPedidoDoUsuario = pedidosCompra.get(i).getValorTotal();
                    String nomeDoUsuario = dadosDoUsuario.getLogin();
                    
                    PedidoCompra pedidosDoUsuario = new PedidoCompra(codigoPedidoDoUsuario, dadosDoUsuario, dataDoPedidoDoUsuario, valorTotalDoPedidoDoUsuario);
                    pedidosDeCompraDoUsuario.add(pedidosDoUsuario);
                    request.setAttribute("dadosdopedidodousuario", pedidosDeCompraDoUsuario);
                }
               }
        }
        request.getRequestDispatcher("WEB-INF/ExibirTodosOsPedidos.jsp").forward(request, response);
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
