package servicos;

import controle.VO.Item;
import controle.VO.ItemPedido;
import controle.VO.PedidoCompra;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Pedido extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pedido = request.getParameter("pedido");
        Double valorTotal = 0.0;
        Double valorPedido = 0.0;
        if (pedido != null) {
            ArrayList<PedidoCompra> pedidoUsuario = new ArrayList<PedidoCompra>();
            DecimalFormat df = new DecimalFormat("0.00");

            for (int i = 0; i < pedidoUsuario.size(); i++) {

                int codigoPedido = pedidoUsuario.get(i).getCodigoPedido();
                int codigoDoItem = pedidoUsuario.get(i).getItensDePedido().getItem().getCodigoItem();
                int codigoItemPedido = pedidoUsuario.get(i).getItensDePedido().getCodigoItemPedido();
                String nomeDoItem = pedidoUsuario.get(i).getItensDePedido().getItem().getNome();
                Double valorDoItem = pedidoUsuario.get(i).getItensDePedido().getItem().getValor();
                String detalheDoItem = pedidoUsuario.get(i).getItensDePedido().getItem().getDetalhes();
                String descricaoDoItem = pedidoUsuario.get(i).getItensDePedido().getItem().getDescricao();
                String quantidade = request.getParameter("quantidade_" + i);
                int qtidade = Integer.valueOf(quantidade);
                Date dataPedido = null;

                Item item = new Item(codigoDoItem, descricaoDoItem, detalheDoItem, nomeDoItem, valorDoItem);
                ItemPedido itemPedido = new ItemPedido(codigoItemPedido, qtidade, item);
                PedidoCompra pedidoCompra = new PedidoCompra(codigoPedido, itemPedido, dataPedido);
                pedidoUsuario.add(pedidoCompra);

                valorPedido = valorDoItem * qtidade;
                valorTotal += valorPedido;
            }
            HttpSession session = request.getSession();
            session.setAttribute("pedidoUsuario", pedidoUsuario);
            request.setAttribute("valortotal", df.format(valorTotal));
            request.setAttribute("valorpedido", df.format(valorPedido));
            request.setAttribute("pedidoUsuario", pedidoUsuario);
        }
        request.getRequestDispatcher("WEB-INF/MostrarPedido.jsp").forward(request, response);

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
