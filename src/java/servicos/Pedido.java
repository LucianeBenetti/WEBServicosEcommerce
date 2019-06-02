package servicos;

import controle.VO.Item;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pedido extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Object listaDeItens = request.getSession().getAttribute("listadeitens");
        Double valorTotalDoItem = 0.0;
        Double valorTotal = 0.0;        
        
        if (listaDeItens != null) {

            ArrayList<Item> itens = (ArrayList<Item>) listaDeItens;            
            ArrayList<Item> pedidoCompra = new ArrayList<Item>();
            ArrayList <Integer> quantidades = new ArrayList <Integer>();
            DecimalFormat df = new DecimalFormat("0.00");

            for (int i = 0; i < itens.size(); i++) {

                int codigoDoItem = itens.get(i).getCodigoItem();
                
                String descricaoDoItem = itens.get(i).getDescricao();
                String detalheDoItem = itens.get(i).getDetalhes();
                String nomeDoItem = itens.get(i).getNome();
                Double valorDoItem = itens.get(i).getValor();                
                String quantidade = request.getParameter("quantidade_" + i);
                
                int qtidade = Integer.valueOf(quantidade);
                quantidades.add(qtidade);

                Item item = new Item(codigoDoItem, descricaoDoItem, detalheDoItem, nomeDoItem, valorDoItem);
                pedidoCompra.add(item);

                valorTotalDoItem = valorDoItem * qtidade;
                valorTotal += valorTotalDoItem;
               
               request.setAttribute("valortotal", df.format(valorTotal));
               

//                int codigoPedido = pedidoUsuario.get(i).getCodigoPedido();
//                int codigoDoItem = pedidoUsuario.get(i).getItensDePedido().getItem().getCodigoItem();
//                int codigoItemPedido = pedidoUsuario.get(i).getItensDePedido().getCodigoItemPedido();
//                String nomeDoItem = pedidoUsuario.get(i).getItensDePedido().getItem().getNome();
//                Double valorDoItem = pedidoUsuario.get(i).getItensDePedido().getItem().getValor();
//                String detalheDoItem = pedidoUsuario.get(i).getItensDePedido().getItem().getDetalhes();
//                String descricaoDoItem = pedidoUsuario.get(i).getItensDePedido().getItem().getDescricao();
//                String quantidade = request.getParameter("quantidade_" + i);
//                int qtidade = Integer.valueOf(quantidade);
//                Date dataPedido = null;
//
//                Item item = new Item(codigoDoItem, descricaoDoItem, detalheDoItem, nomeDoItem, valorDoItem);
//                ItemPedido itemPedido = new ItemPedido(codigoItemPedido, qtidade, item);
//                PedidoCompra pedidoCompra = new PedidoCompra(codigoPedido, itemPedido, dataPedido);
//                pedidoUsuario.add(pedidoCompra);
//
//                valorPedido = valorDoItem * qtidade;
//                valorTotal += valorPedido;
//            }
                // HttpSession session = request.getSession();
                // session.setAttribute("pedidoUsuario", pedidoUsuario);
                
               }
            request.setAttribute("quantidades", quantidades);
            request.setAttribute("pedidocompra", pedidoCompra);
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
