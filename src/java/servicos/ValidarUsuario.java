package servicos;

import controle.BO.UsuarioBo;
import controle.DAO.DAOItem;
import controle.VO.Item;
import controle.VO.Usuario;
import controle.integracao.ItemDAOJSON;
import controle.integracao.UsuarioDAOJSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = new Usuario();
        usuario.setLogin(request.getParameter("login"));
        usuario.setSenha(request.getParameter("senha"));

        UsuarioBo usuarioBo = new UsuarioBo();
        usuario = usuarioBo.validarUsuario(usuario);
        String usuarioJSON = null;
        
        if (usuario != null) {
            UsuarioDAOJSON usuarioDAOJSON = new UsuarioDAOJSON();
            usuarioJSON = usuarioDAOJSON.serializaParaJSON(usuario);
            
            PrintWriter out = response.getWriter();            
            out.print(usuarioJSON);
     
            System.out.println("O item JSON é: " + usuarioJSON);
        } else {
            System.out.println("A pesquisa do item retornou vazio. Sem item!");
        }

    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        RepositorioAlunoList rep = new RepositorioAlunoList();
//        List<Aluno> lista = rep.getLista();
//
//        String nome = request.getParameter("nome");
//        String matricula = request.getParameter("matricula");
//        String email = request.getParameter("email");
//
//        Aluno a = new Aluno();
//        a.setNome(nome);
//        a.setMatricula(matricula);
//        a.setEmail(email);
//
//        lista.add(a);
//        DAOAluno daoAluno;
//        String responseFormat = request.getHeader("accept");
//        if (responseFormat != null && responseFormat.equals("JSON")) {
//            response.setContentType("application/json;charset=UTF-8");
//            daoAluno = new DAOAlunoJSON();
//        } else {
//            response.setContentType("text/xml;charset=UTF-8");
//            daoAluno = new DAOAlunoXML();
//        }
//        response.setStatus(200);
//        PrintWriter out = response.getWriter();
//        out.print(daoAluno.serializa(rep));
//    }
//
//    @Override
//    protected void doPut(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//    }
}
