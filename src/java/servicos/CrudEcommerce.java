package servicos;

import controle.BO.UsuarioBo;
import controle.VO.Item;
import controle.VO.PedidoCompra;
import controle.VO.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CrudEcommerce extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String var1 = request.getParameter("cadastrar");
        String var2 = request.getParameter("validar");
        String var3 = request.getParameter("excluirpedido");
        String descricao = request.getParameter("descricao");

        ArrayList<String> variavel = new ArrayList<String>();
        variavel.add(var1);
        variavel.add(var2);
        variavel.add(var3);
        System.out.println("Var 3: " + variavel);

        Usuario usuario = null;
        Item item = null;
        UsuarioBo usuarioBo = null;

        for (int i = 0; i < variavel.size(); i++) {
            String var = variavel.get(i);

            if (var != null) {
                switch (var) {
                    case "cadastrar":

                        usuario = new Usuario();
                        usuario.setLogin(request.getParameter("login"));
                        usuario.setSenha(request.getParameter("senha"));
                        usuarioBo = new UsuarioBo();
                        int novoId = 0;
                        novoId = usuarioBo.cadastrarUsuario(usuario);
                        if (novoId > 0) {

                            request.getRequestDispatcher("Login.jsp").forward(request, response);

                        } else {
                            System.out.println("Já existe um usuário com o mesmo nome e/ou senha. Tente outro nome!");

                        }
                        break;

                    case "validar":

                        usuario = new Usuario();
                        usuario.setLogin(request.getParameter("login"));
                        usuario.setSenha(request.getParameter("senha"));

                        usuarioBo = new UsuarioBo();
                        usuario = usuarioBo.validarUsuario(usuario);
                        if (usuario != null) {

                            HttpSession session = request.getSession();
                            session.setAttribute("usuarioautenticado", usuario);
                            request.setAttribute("datavalidade", usuario.getDataValidade());
                            request.setAttribute("numerocartao", usuario.getNumeroCartao());
                            request.setAttribute("codigoseguranca", usuario.getCodigoSeguranca());
                            request.setAttribute("login", usuario.getLogin());
                            request.setAttribute("senha", usuario.getSenha());

                            request.getRequestDispatcher("WEB-INF/EcommerceValidado.jsp").forward(request, response);

                        } else {
                            Boolean validacao = false;
                            request.getRequestDispatcher("Login.jsp").forward(request, response);
                        }

                        break;

                    case "pesquisar":
                        item = new Item();

                        usuarioBo = new UsuarioBo();
                        item = usuarioBo.pesquisarItem(descricao);

                        if (item != null) {
                        }
                        break;

                    case "excluirpedido":
                       
                        int codigoPedido = new Integer(request.getParameter("codigopedido"));
                        System.out.println("O código do pedido é: " + codigoPedido);
//fazer dao para a tabela itempedido para excluir o codigopedido
                        PedidoCompra pedidoCompra = new PedidoCompra();
                        usuarioBo = new UsuarioBo();

                        if (usuarioBo.excluirPedidoDoUsuario(codigoPedido)) {
                            System.out.println("Pedido do Usuário excluído com sucesso!");
                            //request.getRequestDispatcher("Login.jsp").forward(request, response);

                        } else {
                            System.out.println("Não foi possível excluir Pedido do Usuário!");

                        }
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
     *
     * Handles the HTTP <code>GET</code> method.
     *
     *
     *
     * @param request servlet request
     *
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     *
     * @throws IOException if an I/O error occurs
     *
     */
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    /**
     *
     * Handles the HTTP <code>POST</code> method.
     *
     *
     *
     * @param request servlet request
     *
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     *
     * @throws IOException if an I/O error occurs
     *
     */
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    /**
     *
     * Returns a short description of the servlet.
     *
     *
     *
     * @return a String containing servlet description
     *
     */
    @Override

    public String getServletInfo() {

        return "Short description";

    }// </editor-fold>

}
