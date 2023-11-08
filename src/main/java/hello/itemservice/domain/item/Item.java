package hello.itemservice.domain.item;

import lombok.Data;

@Data
//권장하지않음, 글로벌오류는 자바코드로 작성!
//@ScriptAssert(lang = "javascript"
//        , script = "_this.price * _this.quantity >= 10000"
//        , message = "가격 * 수량의 합은 10,000원 이상이여야 합니다.")

/**
 *  최종 결론은 검증은 groups를 통해 하지않고 save,update 기능별로 form을 만드는게 깔끔하다! validation > form 참고!
 */
public class Item {

 //   @NotNull(groups = UpdateCheck.class) //수정 요구사항 추가(수정 시 사이드이펙트 발생 : 수정 시엔 정상, 저장할 때는 id가 없으므로 오류) -> Groups로 해결
    private Long id;

//    @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
    private String itemName;

//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Range(min = 1000, max = 1000000)
    private Integer price;

//    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
//    @Max(value = 9999, groups = SaveCheck.class) //수정 요구사항 추가 : 수정 시에는 MAX값 체크 안함 - > 수정 시 사이드이펙트 발생 (수정 시엔 정상, 저장할 때는 Max가 적용되어야하는데 안됨) -> Groups로 해결
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
