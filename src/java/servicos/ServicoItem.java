package servicos;

import controle.DAO.ItemDAO;
import controle.VO.Item;
import controle.VO.RepositorioItemList;
import controle.integracao.ItemDAOJSON;
import controle.integracao.ItemDAOXML;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServicoItem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String descProduto = request.getParameter("descricaoproduto");
        Item item=null;
        ItemDAO itemDAO = new ItemDAO();
        ArrayList<Item> itensPesquisado = new ArrayList<Item>();
        itensPesquisado = itemDAO.pesquisarItem(descProduto);
        String itemJSON = null;

        if (itensPesquisado != null) {
            ItemDAOJSON itemDAOJSON = new ItemDAOJSON();
            itemJSON = itemDAOJSON.serializa(itensPesquisado);
            //request.setAttribute("itensenccontrados", itensEncontrados);
//            request.getRequestDispatcher("ResultadoDaPesquisa.jsp").forward(request, response);
            PrintWriter out = response.getWriter();
            out.print(itemJSON);
            out.println();
              
             itemDAOJSON = new ItemDAOJSON();
            itensPesquisado = itemDAOJSON.desserializa(itemJSON);
             out = response.getWriter();
            out.print(itensPesquisado);   

        } else {
            System.out.println("A pesquisa do item retornou vazio. Sem item!");
        }

     //   if (itemJSON != null) {
                 

  //      }

//        RepositorioItemList rep = new RepositorioItemList();
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

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
////
////        RepositorioAlunoList rep = new RepositorioAlunoList();
////        List<Aluno> lista = rep.getLista();
////
////        String nome = request.getParameter("nome");
////        String matricula = request.getParameter("matricula");
////        String email = request.getParameter("email");
////
////        Aluno a = new Aluno();
////        a.setNome(nome);
////        a.setMatricula(matricula);
////        a.setEmail(email);
////
////        lista.add(a);
////        DAOAluno daoAluno;
////        String responseFormat = request.getHeader("accept");
////        if (responseFormat != null && responseFormat.equals("JSON")) {
////            response.setContentType("application/json;charset=UTF-8");
////            daoAluno = new DAOAlunoJSON();
////        } else {
////            response.setContentType("text/xml;charset=UTF-8");
////            daoAluno = new DAOAlunoXML();
////        }
////        response.setStatus(200);
////        PrintWriter out = response.getWriter();
////        out.print(daoAluno.serializa(rep));
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
