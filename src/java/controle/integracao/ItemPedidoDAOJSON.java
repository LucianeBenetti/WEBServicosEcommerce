package controle.integracao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controle.VO.ItemPedido;
import controle.VO.Usuario;
import java.util.ArrayList;

public class ItemPedidoDAOJSON {
    
    public String serializa(ArrayList<ItemPedido> itensEncontrados) {
        Gson gson = new GsonBuilder().create();
        String itemJson = gson.toJson(itensEncontrados);
        return itemJson;
    }    
    
    public ArrayList<ItemPedido> desserializa(String s) {
        
        Gson gson = new GsonBuilder().create();
        
        ArrayList<ItemPedido> listaDeItensFromJSON = (ArrayList<ItemPedido>) gson.fromJson(s,
                        new TypeToken<ArrayList<ItemPedido>>() {
                        }.getType());
        return listaDeItensFromJSON;
    }
    
    public String serializaParaJSON(ItemPedido itemPedido) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(itemPedido);
  
        return json;
    }
    
}
