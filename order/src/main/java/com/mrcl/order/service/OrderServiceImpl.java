package com.mrcl.order.service;

import com.mrcl.order.collection.Order;
import com.mrcl.order.rep.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MongoTemplate mongoTemplate;
    private final OrderRepository orderRepository;
    @Override
    public Order save(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public List<Order> getOrderByPrice(Double price) {
        return orderRepository.findByPrice(price);
    }

    @Override
    public List<Order> getOrderByWeight(Double minWeight, Double maxWeight) {
        return orderRepository.findByWeightBetween(minWeight, maxWeight);
    }

    @Override
    public Page<Order> search(Double price, Double minWeight, Double maxWeight, String city, Pageable pageable) {
        Query query = new Query().with(pageable);
        List<Criteria> criteria = new ArrayList<>();


        if (price != null && !price.isNaN()) {
            criteria.add(Criteria.where("price").gte(minWeight).lte(maxWeight));
        }

        if (city != null && !city.isEmpty()) {
            criteria.add(Criteria.where("addressList.city").is(city));
        }

        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria()
                    .andOperator(criteria.toArray(new Criteria[0])));
        }

        Page<Order> order = PageableExecutionUtils.getPage(
                mongoTemplate.find(query, Order.class),
                pageable,
                () -> mongoTemplate.count(query.skip(0).limit(0), Order.class));
        return order;
    }
}
