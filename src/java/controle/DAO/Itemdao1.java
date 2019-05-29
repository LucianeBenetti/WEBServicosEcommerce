/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.DAO;

import controle.VO.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author luciane
 */
public class Itemdao1 {
   public ArrayList<Item> pesquisarItem(String descProduto) {
    

    String query = "SELECT *from item " + " where descricao like ? ";
        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        Item item = null;
        ArrayList<Item> itens = new ArrayList<Item>();
        try {
            prepStmt.setString(1, '%' + descProduto + '%');
            ResultSet result = prepStmt.executeQuery();
            while (result.next()) {
                item = new Item();
                item.setCodigoItem(result.getInt(1));
                item.setDescricao(result.getString(2));
                item.setDetalhes(result.getString(3));
                item.setNome(result.getString(4));
                item.setValor(Double.parseDouble(result.getString(5)));
                itens.add(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return itens; 
 
    }
}
    
    
    
    
    
    
