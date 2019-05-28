
package controle.DAO;

import controle.VO.Item;
import controle.VO.RepositorioItemList;
import controle.VO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {

    public ArrayList<Item> pesquisarItem() {
        
        Item item;
        String query = "select * from item";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        ArrayList<Item> itens = new ArrayList<Item>();

        try {
            ResultSet resultado = prepStmt.executeQuery(query);

            while (resultado.next()) {

               item = new Item();
               
               item.setCodigoItem(resultado.getInt(1));
               item.setDescricao(resultado.getString(2));
               item.setDetalhes(resultado.getString(3));
               item.setNome(resultado.getString(4));
               item.setValor(resultado.getDouble(5));   
               
                itens.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itens;
    } 
 
    
}
    
    
    
    
    
    
