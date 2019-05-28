
package controle.VO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RepositorioItem {
    
    Item[] listaDeItens;

    public Item[] getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(Item[] listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    @Override
    public String toString() {
        return "RepositorioItem{" + "listaDeItens=" + listaDeItens + '}';
    }
    
    
}
