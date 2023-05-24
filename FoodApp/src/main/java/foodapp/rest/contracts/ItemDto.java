package foodapp.rest.contracts;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDto {

    private String name;

    private Integer quantity;
}
