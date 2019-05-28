
package controle.BO;

import controle.DAO.ItemDao;
import controle.VO.Item;

public class ItemBo {
    
    Item item;
    ItemDao itemDao;
    public Item pesquisarItem(String descricao) {
        
        itemDao = new ItemDao();
        
        if(itemDao.pesquisarItem() == null){
            return null;
        }else {return item;}
        
    }  
    
}
