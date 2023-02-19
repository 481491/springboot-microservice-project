package com.programmingtechie.inventoryservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "skuCode")
    private String skuCode;
    private Integer quantity;
}
