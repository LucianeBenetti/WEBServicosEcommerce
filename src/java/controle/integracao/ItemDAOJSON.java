/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.integracao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controle.VO.Item;
import controle.VO.RepositorioItemList;
import java.util.ArrayList;

/**
 *
 * @author 80119050
 */
public class ItemDAOJSON {

  

    public RepositorioItemList desserializa(String s) {
        Gson gson = new GsonBuilder().create();
        RepositorioItemList rep = (RepositorioItemList) gson.fromJson(s, RepositorioItemList.class);
        return rep;
    }

    public String serializa(ArrayList<Item> listaDeItens) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(listaDeItens);
        return json;
    }
}
