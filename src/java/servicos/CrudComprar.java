package servicos;

import controle.DAO.UsuarioDao;
import controle.VO.Usuario;
import controle.integracao.UsuarioDAOJSON;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrudComprar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UsuarioDao usuarioDao = new UsuarioDao();

        Usuario usuario = new Usuario();
        //   usuario = usuarioDao.listarTodosOsUsuarios();
        if (usuario != null) {
            response.setStatus(500);

        } else {
            response.setStatus(200);
            UsuarioDAOJSON usuarioDAOJSON;
            String responseFormat = request.getHeader("accept");

            if (responseFormat != null && responseFormat.equals("JSON")) {
                response.setContentType("application/json;charset=UTF-8");
                usuarioDAOJSON = new UsuarioDAOJSON();
                usuarioDAOJSON.serializaParaJSON(usuario);

            } else {

            }

        }

    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        RepositorioAlunoList rep= new RepositorioAlunoList();
//        List<Aluno> lista=rep.getLista();
//        
//        String nome=request.getParameter("nome");
//        String matricula=request.getParameter("matricula");
//        String email=request.getParameter("email");
//        
//        Aluno a = new Aluno();
//        a.setNome(nome);
//        a.setMatricula(matricula);
//        a.setEmail(email);
//        
//        lista.add(a);
//        DAOAluno daoAluno;
//        String responseFormat=request.getHeader("accept");
//        if(responseFormat !=null && responseFormat.equals("JSON")){
//            response.setContentType("application/json;charset=UTF-8");
//            daoAluno= new DAOAlunoJSON();
//        }else{
//            response.setContentType("text/xml;charset=UTF-8");
//            daoAluno= new DAOAlunoXML();
//        }
//           response.setStatus(200);  
//           PrintWriter out = response.getWriter();
//           out.print(daoAluno.serializa(rep));
    }

    @Override

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
