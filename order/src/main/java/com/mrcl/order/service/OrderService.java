package com.mrcl.order.service;

import com.mrcl.order.collection.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    Order save(Order order);

    List<Order> findAll();

    List<Order> getOrderByPrice(Double price);

    List<Order> getOrderByWeight(Double minWeight, Double maxWeight);

    Page<Order> search(Double price, Double minWeight, Double maxWeight, String city, Pageable pageable);
}
