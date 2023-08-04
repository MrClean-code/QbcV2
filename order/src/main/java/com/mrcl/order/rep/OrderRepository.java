package com.mrcl.order.rep;

import com.mrcl.order.collection.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<Order, UUID> {
    @Query(value = "{ 'price' : ?0}")
    List<Order> findByPrice(Double price);

    @Query(value = " { 'weight' : { $gt: ?0, $lt: ?1}}")
    List<Order> findByWeightBetween(Double min, Double max);
}
