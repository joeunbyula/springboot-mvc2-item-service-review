package hello.itemservice.domain.formItem;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FormItemRepository {

    private static final Map<Long, FormItem> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public FormItem save(FormItem item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public FormItem findById(Long id) {
        return store.get(id);
    }

    public List<FormItem> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, FormItem updateParam) {
        FormItem findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
        findItem.setOpen(updateParam.getOpen());
        findItem.setDeliveryCode(updateParam.getDeliveryCode());
        findItem.setRegions(updateParam.getRegions());
    }

    public void clearStore() {
        store.clear();
    }

}
