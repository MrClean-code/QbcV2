package com.mrcl.order;

import com.mrcl.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "ORDER-SERVICE")
public interface OrderApi {

//    @GetMapping(value = "/api/departments/{id}")
//    Order getDepartmentById(@PathVariable("id") Long departmentId);

    @GetMapping("/order/twoParam")
    List<Order> findOrderByPrice(@RequestParam Double minWeight,
                                 @RequestParam Double maxWeight);
}
