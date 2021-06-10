package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data   //get setter 쓸수있지만 위험함
//@Getter @Setter
public class Item {


    private Long id;
    private String titleName;
    private String text;

    public Item() {
    }

    public Item(String titleName, String text) {
        this.titleName = titleName;
        this.text = text;

    }
}
