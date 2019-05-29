/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.integracao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controle.VO.Item;
import controle.VO.RepositorioItemList;
import java.util.ArrayList;

/**
 *
 * @author 80119050
 */
public class ItemDAOJSON {
    
    
    public ArrayList<Item> desserializa(String s) {
        System.out.println(s);
        Gson gson = new GsonBuilder().create();
        
        ArrayList<Item> listaDeItensFromJSON = (ArrayList<Item>) gson.fromJson(s,
                        new TypeToken<ArrayList<Item>>() {
                        }.getType());
        return listaDeItensFromJSON;
    }

    public String serializa(ArrayList<Item> listaDeItens) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(listaDeItens);
        return json;
    }
}
