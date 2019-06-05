package controle.DAO;

import controle.VO.Item;
import controle.VO.ItemPedido;
import controle.VO.PedidoCompra;
import controle.VO.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ItemPedidoDAO {

    Usuario usuario = new Usuario();
    Item item = new Item();
    PedidoCompra pedidoCompra = new PedidoCompra();
    ItemPedido itemPedido = new ItemPedido();

    public int cadastrarPedidoCompra(int codigoUsuario) {
        int novoId = 0;
        String sql = "INSERT INTO pedidoCompra (codigoUsuario)"
                + " VALUES (?)";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);
        try {
            
//            Calendar c = Calendar.getInstance();
//            c.setTime(pedidoCompra.getDataPedido().get);
//            //java.sql.Date			
//            Date dataSQL = new Date(c.getTimeInMillis());
            prepStmt.setInt(1, codigoUsuario);
  //          prepStmt.setDate(2, pedidoCompra.getDataPedido(new Date()));
            prepStmt.executeUpdate();
            ResultSet generatedKeys = prepStmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                novoId = generatedKeys.getInt(1);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar o Cadastro do Consulta! Causa: \n: " + e.getMessage());

        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return novoId;

    }

    public int cadastrarPedido(int codigoItem, int novoIdPedidoCompra, int qtdade) {

        int novoId = 0;
        String sql = "INSERT INTO itemPedido (codigoPedido, codigoItem, quantidadeItem)"
                + " VALUES (?,?,?)";
        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);
        try {
            prepStmt.setInt(1, novoIdPedidoCompra);
            prepStmt.setInt(2, codigoItem);
            prepStmt.setInt(3, qtdade);

            prepStmt.executeUpdate();
            ResultSet generatedKeys = prepStmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                novoId = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar o Cadastro do Consulta! Causa: \n: " + e.getMessage());

        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return novoId;

    }

}
