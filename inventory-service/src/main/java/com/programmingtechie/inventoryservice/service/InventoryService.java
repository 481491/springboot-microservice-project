package com.programmingtechie.inventoryservice.service;

import com.programmingtechie.inventoryservice.dto.InventoryResponse;
import com.programmingtechie.inventoryservice.model.Inventory;
import com.programmingtechie.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class InventoryService {
    @Autowired
    public InventoryRepository inventoryRepository;

   @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
       return inventoryRepository.findBySkuCodeIn(skuCode)
               .stream()
               .map(inventory -> InventoryResponse.builder()
                           .skuCode(inventory.getSkuCode())
                           .isStock(inventory.getQuantity()> 0)
                           .build()
               ).collect(Collectors.toList());

    }
}
