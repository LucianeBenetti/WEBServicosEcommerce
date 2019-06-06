package servicos;

import controle.BO.ItemPedidoBo;
import controle.VO.ItemPedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaisVendidos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ItemPedido itemPedido = new ItemPedido();
        ItemPedidoBo itemPedidoBO = new ItemPedidoBo();
        ArrayList<ItemPedido> itensMaisPedidos = new ArrayList<ItemPedido>();
        itensMaisPedidos = itemPedidoBO.buscarItensMaisVendidos();

        if (itensMaisPedidos != null) {
            for (int i = 0; i < itensMaisPedidos.size(); i++) {
                request.setAttribute("nomeitem", itensMaisPedidos.get(i).getItem().getNome());
                request.setAttribute("valoritem", itensMaisPedidos.get(i).getItem().getValor());
                request.setAttribute("quantidadevendida", itensMaisPedidos.get(i).getQuantidade());

            }
        }
         request.getRequestDispatcher("MaisVendidos.jsp").forward(request, response);

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
