package com.mrcl.order;

import com.mrcl.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "order", url = "http://localhost:8081")
public interface OrderApi {
    @GetMapping("/order/twoParam")
    List<Order> findOrderByPrice(@RequestParam("minWeight") Double minWeight,
                                 @RequestParam("maxWeight") Double maxWeight);
}
