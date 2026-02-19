package edu.icet.service;

import edu.icet.model.Item;
import java.util.List;

public interface ItemService {
    boolean addItem(Item item);
    boolean updateItem(Item item);
    boolean deleteItem(String code);
    Item getItemByCode(String code);
    List<Item> getAllItems();
}
