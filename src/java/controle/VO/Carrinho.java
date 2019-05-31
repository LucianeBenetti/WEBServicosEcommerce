
package controle.VO;

import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;

@Component
@SessionScoped
public class Carrinho {
    
    ArrayList<ItemPedido> itensSelecionados = new ArrayList<ItemPedido>();

    public ArrayList<ItemPedido> getItensSelecionados() {
        return itensSelecionados;
    }

    public void setItensSelecionados(ArrayList<ItemPedido> itensSelecionados) {
        this.itensSelecionados = itensSelecionados;
    }
    
}
