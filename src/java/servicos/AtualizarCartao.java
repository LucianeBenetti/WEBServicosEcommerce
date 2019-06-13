package servicos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controle.BO.ItemPedidoBo;
import controle.BO.UsuarioBo;
import controle.VO.Item;
import controle.VO.Usuario;
import controle.integracao.UsuarioDAOJSON;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizarCartao extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");

        Gson gson = new GsonBuilder().create();
        Usuario usuarioFromJSON = (Usuario) gson.fromJson(usuario, Usuario.class);
        System.out.println("Servlet.AtualizarCartao.servidor()" + usuarioFromJSON);

        Usuario usuarioParaAtualizarCartao = new Usuario();
        usuarioParaAtualizarCartao.setCodigoUsuario(usuarioFromJSON.getCodigoUsuario());
        usuarioParaAtualizarCartao.setCodigoSeguranca(usuarioFromJSON.getCodigoSeguranca());
        usuarioParaAtualizarCartao.setLogin(usuarioFromJSON.getLogin());
        usuarioParaAtualizarCartao.setSenha(usuarioFromJSON.getSenha());
        usuarioParaAtualizarCartao.setDataValidade(usuarioFromJSON.getDataValidade());
        usuarioParaAtualizarCartao.setNumeroCartao(usuarioFromJSON.getNumeroCartao());

        UsuarioBo usuarioBo = new UsuarioBo();
        boolean cartaoAtualizado = usuarioBo.atualizarCartaoDoUsuario(usuarioParaAtualizarCartao);

        String usuarioJSON = null;
        if (cartaoAtualizado) {

            UsuarioDAOJSON usuarioDAOJSON = new UsuarioDAOJSON();
            usuarioJSON = usuarioDAOJSON.serializaParaJSON(usuarioParaAtualizarCartao);

            PrintWriter out = response.getWriter();
            out.print(usuarioJSON);

            System.out.println("O item JSON é: " + usuarioJSON);
        } else {
            System.out.println("A pesquisa do item retornou vazio. Sem item!");
        }

    }

}
