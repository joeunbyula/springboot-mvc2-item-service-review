package hello.itemservice.domain.formItem;

import lombok.Data;

import java.util.List;

@Data
public class FormItem {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    private Boolean open; //판매여부
    private List<String> regions; //등록 지역
    private ItemType itemType; //상품종류
    private String deliveryCode; //배송방

    public FormItem() {
    }

    public FormItem(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
