package hello.itemservice;

import hello.itemservice.domain.formItem.FormItem;
import hello.itemservice.domain.formItem.FormItemRepository;
import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final FormItemRepository fromItemRepository;
    private final ItemRepository itemRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        fromItemRepository.save(new FormItem("itemA", 10000, 10));
        fromItemRepository.save(new FormItem("itemB", 20000, 20));
        itemRepository.save(new Item("itemA", 20000, 20));
        itemRepository.save(new Item("itemB", 20000, 20));
    }

}