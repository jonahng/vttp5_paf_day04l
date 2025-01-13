package com.jonah.vttp5_paf_day04l.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor //this is using the extra dependencies
public class Book {
    private int id;
    private String title;
    private int quantity;
    private Boolean isActive; //the framework automatically makes isActive to is_active in JPA framework and it maps. so in java, use isActive, in database use is_active
    


}
