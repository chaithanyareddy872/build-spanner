package com.anbuzhobbiez.spannerdemo.model;

import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "orders")
@Data
@AllArgsConstructor
public class Orders {
    @PrimaryKey
    private String order_id;
    private String order_item;

}
