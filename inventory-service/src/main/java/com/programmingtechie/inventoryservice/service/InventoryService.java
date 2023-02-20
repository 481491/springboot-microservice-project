package com.programmingtechie.inventoryservice.service;

import com.programmingtechie.inventoryservice.dto.InventoryResponse;
import com.programmingtechie.inventoryservice.model.Inventory;
import com.programmingtechie.inventoryservice.repository.InventoryRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class InventoryService {
    @Autowired
    public InventoryRepository inventoryRepository;

   @SneakyThrows
   @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
       log.info("wait started....");
       Thread.sleep(10000);
       log.info("wait started....");
       return inventoryRepository.findBySkuCodeIn(skuCode)
               .stream()
               .map(inventory -> InventoryResponse.builder()
                           .skuCode(inventory.getSkuCode())
                           .isStock(inventory.getQuantity()> 0)
                           .build()
               ).collect(Collectors.toList());

    }

}
