package controle.VO;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({Item.class})
public class RepositorioItemList {
    List<Item> lista = new ArrayList();

    public List<Item> getLista() {
        return lista;
    }

    public void setLista(List<Item> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "RepositorioItemList{" + "lista=" + lista + '}';
    }
    
}
