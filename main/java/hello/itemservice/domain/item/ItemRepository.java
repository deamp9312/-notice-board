package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();//실제로는 hashmap 쓰면안됨
    //동시에 여러 쓰레드가 접근하면 ConcurrentHashMap<>()
    private static long sequence = 0L;  //static

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());

    }

    public void update(Long itemId,Item updateParam){
        Item findItem = findById(itemId);
        findItem.setTitleName(updateParam.getTitleName());
        findItem.setText(updateParam.getText());

    }

    public void clearStore(){
        store.clear();
    }
}
