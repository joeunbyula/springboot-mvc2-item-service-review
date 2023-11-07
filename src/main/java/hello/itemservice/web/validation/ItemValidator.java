package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Item.class.isAssignableFrom(clazz);
        //item == clazz
        //item == subItem
    }

    @Override
    public void validate(Object target, Errors errors) {
        Item item = (Item) target;

        //검증 오류 결과 보관 (errors.properties에 적은 규칙을 자동생성해줌.)
        //{errorCode}.{objectName}.{target} 조합
        if(!StringUtils.hasText(item.getItemName())) {
            //required.item.itemName
            errors.rejectValue("itemName", "required");
        }

        if(item.getPrice() == null || (item.getPrice() < 1000 || item.getPrice() > 1000000)) {
            //range.item.price
            errors.rejectValue("price", "range");
        }

        if(item.getQuantity() == null || item.getQuantity() >= 9999) {
            //max.item.quantity
            errors.rejectValue("quantity", "max");
        }

        //특정 필드가 아닌 복합 룰 검증
        if(item.getPrice() != null && item.getQuantity() != null) {
            int resultPrice = item.getPrice() * item.getQuantity();
            if(resultPrice < 10000) {
                errors.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
            }
        }
    }
}
