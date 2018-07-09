package service;

import dao.ItemDao;
import entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemDao idao;

    @Autowired
    public ItemService(ItemDao idao) {
        this.idao = idao;
    }

    public List<Item> get() {
        return idao.get();
    }
}