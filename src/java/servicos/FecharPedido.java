package servicos;

import controle.BO.UsuarioBo;
import controle.VO.Item;
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
        Object usuarioAutenticado = request.getSession().getAttribute("usuarioautenticado");

        Usuario dadosDoUsuario = (Usuario) usuarioAutenticado;
      
        ArrayList<String> variavel = new ArrayList<String>();
        variavel.add(var1);
        variavel.add(var2);
     
        Usuario usuario = null;
        Item item = null;
        UsuarioBo usuarioBo = null;

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
                     
//                            request.setAttribute("codigoseguranca", );
//                            request.setAttribute("datavalidade", );
//                            request.setAttribute("login", );
//                            request.setAttribute("numerocartao", );
//                            request.setAttribute("senha", );
                            request.getRequestDispatcher("WEB-INF/PedidoFechado.jsp").forward(request, response);
                            System.out.println("O novo numero do cartao é: " + cartaoAtualizado);

                        } else {
                           // System.out.println("Já existe um usuário com o mesmo nome e/ou senha. Tente outro nome!");

                        }
                        break;

                    case "fecharpedido":

                        usuario = new Usuario();
                        usuario.setLogin(request.getParameter("login"));
                        usuario.setSenha(request.getParameter("senha"));

                        usuarioBo = new UsuarioBo();
                        usuario = usuarioBo.validarUsuario(usuario);

                        if (usuario != null) {

                            request.setAttribute("datavalidade", usuario.getDataValidade());
                            request.setAttribute("numerocartao", usuario.getNumeroCartao());
                            request.setAttribute("codigoseguranca", usuario.getCodigoSeguranca());
                            request.setAttribute("login", usuario.getLogin());
                            request.setAttribute("senha", usuario.getSenha());
                            HttpSession session = request.getSession();

                            session.setAttribute("usuarioautenticado", usuario);
                            //System.out.println("usuario autenticado dentro do if )" + usuario);
                            //request.setAttribute("usuarioautenticado", usuario.getLogin());
                            request.getRequestDispatcher("WEB-INF/EcommerceValidado.jsp").forward(request, response);

                        } else {

                            request.getRequestDispatcher("Login.jsp").forward(request, response);

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
