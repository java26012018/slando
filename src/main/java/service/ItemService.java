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

    public Item getById(String id) {
        return idao.getById(id);
    }

    public void add(Item i) {
        idao.add(i);
    }

    public void delete(Item i) {
        idao.delete(i);
    }

    public List<Item> getByOwner(String owner) {
        return idao.getByOwner(owner);
    }

    public List<Item> getBySearchRequest(String search) {
        return idao.getBySearchRequest(search);
    }

    public List<Item> getByCat(String cat) {
        return idao.getByCat(cat);
    }

    public List<Item> getList(String search, String cat) {
        List<Item> getList;
        if (search != null && search != "") {
            getList = getBySearchRequest(search);
        } else if (cat != null) {
            getList = getByCat(cat);
        } else getList = get();
        return getList;
    }
}
