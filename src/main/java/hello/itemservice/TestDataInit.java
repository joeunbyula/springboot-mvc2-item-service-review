package hello.itemservice;

import hello.itemservice.domain.formItem.FormItem;
import hello.itemservice.domain.formItem.FormItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final FormItemRepository itemRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new FormItem("itemA", 10000, 10));
        itemRepository.save(new FormItem("itemB", 20000, 20));
    }

}