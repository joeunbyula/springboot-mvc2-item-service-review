package hello.itemservice.domain.formItem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemRepositoryTest {

    FormItemRepository itemRepository = new FormItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        FormItem item = new FormItem("itemA", 10000, 10);

        //when
        FormItem savedItem = itemRepository.save(item);

        //then
        FormItem findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        //given
        FormItem item1 = new FormItem("item1", 10000, 10);
        FormItem item2 = new FormItem("item2", 20000, 20);

        itemRepository.save(item1);
        itemRepository.save(item2);

        //when
        List<FormItem> result = itemRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1, item2);
    }

    @Test
    void updateItem() {
        //given
        FormItem item = new FormItem("item1", 10000, 10);

        FormItem savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        //when
        FormItem updateParam = new FormItem("item2", 20000, 30);
        itemRepository.update(itemId, updateParam);

        FormItem findItem = itemRepository.findById(itemId);

        //then
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }
}
