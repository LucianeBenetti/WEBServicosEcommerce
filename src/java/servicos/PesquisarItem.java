package servicos;

import controle.DAO.DAOItem;
import controle.VO.Item;
import controle.integracao.ItemDAOJSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PesquisarItem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String descricaoProduto = request.getParameter("descricaoproduto");
        Item item = null;
        DAOItem itemDAO = new DAOItem();
        ArrayList<Item> itensEncontrados = new ArrayList<Item>();
        itensEncontrados = itemDAO.pesquisarItem(descricaoProduto);
        String itemJSON = null;

        if (itensEncontrados != null) {
            ItemDAOJSON itemDAOJSON = new ItemDAOJSON();
            itemJSON = itemDAOJSON.serializa(itensEncontrados);

         //  System.out.println("O item JSON é: " + itemJSON);
        } else {
            System.out.println("A pesquisa do item retornou vazio. Sem item!");
        }

        if (itemJSON != null) {

            ItemDAOJSON itemDAOJSON = new ItemDAOJSON();
            itensEncontrados = itemDAOJSON.desserializa(itemJSON);

       //   System.out.println("Os itens encontrados são: " + itensEncontrados);
            request.setAttribute("itensencontrados", itensEncontrados);
            String page = (String) request.getSession().getAttribute("usuarioautenticado") == null ? "ResultadoDaPesquisa.jsp" : "WEB-INF/ResultadoDaPesquisaAutenticado.jsp";
            request.getRequestDispatcher(page).forward(request, response);
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
    //     RepositorioItemList rep = new RepositorioItemList();
//        List<Item> lista = rep.getLista();
//        if (listaDeItens.size() == 0) {
//            response.setStatus(500);
//        } else {
//            response.setStatus(200);
//            ItemDAOJSON itemDAOJSON;      
//            
//            String responseFormat = request.getHeader("accept");
//
//            if (responseFormat != null && responseFormat.equals("JSON")) {
//                response.setContentType("application/json;charset=UTF-8");
//                itemDAOJSON = new ItemDAOJSON();
//                itemDAOJSON.serializa(listaDeItens);
//                PrintWriter out = response.getWriter();
//                out.print(itemDAOJSON.serializa(listaDeItens));
//                System.out.println(listaDeItens);
//
//            } else {
//                response.setContentType("text/xml;charset=UTF-8");
//                ItemDAOXML itemDAOXML = new ItemDAOXML();
//                itemDAOXML.serializa(listaDeItens);
//                PrintWriter out = response.getWriter();
//                out.print(itemDAOXML.serializa(listaDeItens));
//                System.out.println(listaDeItens);
//            }
//
//        }
}
