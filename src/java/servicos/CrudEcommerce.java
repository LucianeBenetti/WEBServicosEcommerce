package servicos;

import controle.BO.UsuarioBo;
import controle.VO.Item;
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
        String descricao = request.getParameter("descricao");
        
        ArrayList<String> variavel = new ArrayList<String>();
        variavel.add(var1);
        variavel.add(var2);
        System.out.println("O array é: " + variavel);

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

//                            request.setAttribute("codigousario", novoId);
//                            request.setAttribute("codigoseguranca", );
//                            request.setAttribute("datavalidade", );
//                            request.setAttribute("login", );
//                            request.setAttribute("numerocartao", );
//                            request.setAttribute("senha", );
                            request.getRequestDispatcher("Login.jsp").forward(request, response);
                            System.out.println("O novo Id é: " + novoId);

                        } else {
                            System.out.println("Já existe um usuário com o mesmo nome e/ou senha. Tente outro nome!");

                        }
                        break;

                    case "validar":

                        usuario = new Usuario();
                        usuario.setLogin(request.getParameter("login"));
                        usuario.setSenha(request.getParameter("senha"));
                        usuarioBo = new UsuarioBo();
                        Usuario usuarioValidado = usuarioBo.validarUsuario(usuario);                        
                        
                        if (usuarioValidado != null) {
                            
                            System.out.println("O usuário é: " + usuarioValidado);
                            
                            HttpSession session = request.getSession();
                            
                            request.setAttribute("login", usuario.getLogin());
                            request.setAttribute("senha", usuario.getSenha());
                            session.setAttribute("usuarioautenticado", usuario.getLogin());
                            //request.setAttribute("usuarioautenticado", usuario.getLogin());
                            
                            request.getRequestDispatcher("WEB-INF/EcommerceValidado.jsp").forward(request, response);

                        } else {

                            request.getRequestDispatcher("Login.jsp").forward(request, response);

                        }

                        break;

                    case "pesquisar":
                        item = new Item();

                        usuarioBo = new UsuarioBo();
                        item = usuarioBo.pesquisarItem(descricao);

                        if (item != null) {
                       //     System.out.println(item);

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
