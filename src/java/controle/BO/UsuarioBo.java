/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.BO;

import controle.DAO.UsuarioDao;
import controle.VO.Item;
import controle.VO.Usuario;
import java.util.ArrayList;

/**
 *
 * @author 80119050
 */
public class UsuarioBo {

    UsuarioDao usuarioDao;
    Item item;

    public int cadastrarUsuario(Usuario usuario) {
        usuarioDao = new UsuarioDao();
        int novoId;
        if (usuarioDao.pesquisarUsuario(usuario) != null) {
            novoId = 0;
        } else {
            novoId = usuarioDao.cadastrarUsuario(usuario);
        }
        return novoId;
    }

    public Usuario validarUsuario(Usuario usuario) {
        usuarioDao = new UsuarioDao();
        usuario = usuarioDao.pesquisarUsuario(usuario);
        if (usuario == null) {
            return null;
        } else {
            return usuario;
        }
    }

    public Item pesquisarItem(String descricao) {
        item = new Item();
        if (usuarioDao.pesquisarItem(descricao) == null) {
            return null;
        } else {
            return item;
        }
    }

    public ArrayList<Usuario> PesquisarTodosUsuarios() {
        return usuarioDao.listarTodosOsUsuarios();
    }

}
