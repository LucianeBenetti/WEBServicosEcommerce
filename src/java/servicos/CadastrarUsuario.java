package servicos;

import controle.BO.UsuarioBo;
import controle.VO.Usuario;
import controle.integracao.UsuarioDAOJSON;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = new Usuario();
        usuario.setLogin(request.getParameter("login"));
        usuario.setSenha(request.getParameter("senha"));
              
        UsuarioBo usuarioBo = new UsuarioBo();
        String usuarioJSON = null;
        int novoId = 0;
        novoId = usuarioBo.cadastrarUsuario(usuario);
        
        if (novoId > 0) {

            UsuarioDAOJSON usuarioDAOJSON = new UsuarioDAOJSON();
            usuarioJSON = usuarioDAOJSON.serializaParaJSON(usuario);

            PrintWriter out = response.getWriter();
            out.print(usuarioJSON);

        } else {
            System.out.println("Já existe um usuário com o mesmo nome e/ou senha. Tente outro nome!");

        }
    }
}
