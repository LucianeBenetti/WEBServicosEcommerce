package controle.integracao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controle.VO.Item;
import controle.VO.Usuario;
import java.util.ArrayList;

public class UsuarioDAOJSON {

    public String serializaParaJSON(Usuario usuario) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(usuario);
  
        return json;
    }

    public ArrayList<Usuario> desserializa(String jsonString) {

        Gson gson = new GsonBuilder().create();
        ArrayList<Usuario> usuariosFromJSON = (ArrayList<Usuario>) gson.fromJson(jsonString, new TypeToken<ArrayList<Usuario>>() {
        }.getType());

        return usuariosFromJSON;
    }
}
