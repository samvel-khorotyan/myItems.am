package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    private int id;
    private String title;
    private double price;
    private int categoryId;
    private String picUrl;
    private int userId;

}
