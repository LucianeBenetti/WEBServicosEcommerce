package servicos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Pedido extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Double valorTotal = 0.0;
        Double valorPedido = 0.0;

        ArrayList<PedidoCompra> pedidoUsuario = new ArrayList<PedidoCompra>();
        DecimalFormat df = new DecimalFormat("0.00");

        for (int i = 0; i < pedidoUsuario.size(); i++) {

            int codigoItem = pedidoUsuario.get(i).get;
            String nome = pedidoUsuario.get(i).getNome();
            Double valor = pedidoUsuario.get(i).getValor();
            String detalhe = pedidoUsuario.get(i).getDetalhes();
            String descricao = pedidoUsuario.get(i).getDescricao();
            String quantidade = request.getParameter("quantidade_" + i);
            int qtidade = Integer.valueOf(quantidade);
            Item item = new Item(codigoItem, descricao, detalhe, nome, valor);
            pedidoUsuario.add(item);

            valorPedido = valor * qtidade;
            valorTotal += valorPedido;
        }
        HttpSession session = request.getSession();
        session.setAttribute("pedidoUsuario", pedidoUsuario);
        request.setAttribute("valortotal", df.format(valorTotal));
        request.setAttribute("valorpedido", df.format(valorPedido));
        request.setAttribute("pedidoUsuario", pedidoUsuario);

        request.getRequestDispatcher("pedidoCliente.jsp").forward(request, response);
        
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
