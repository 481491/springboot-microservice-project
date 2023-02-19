package com.programmingtechie.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderLineItemsRequest {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
