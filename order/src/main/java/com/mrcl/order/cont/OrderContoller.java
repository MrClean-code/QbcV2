package com.mrcl.order.cont;

import com.mrcl.order.collection.Order;
import com.mrcl.order.service.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderContoller {

    private final OrderService orderService;

    @PostMapping("")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.save(order),
                HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> getOrders() {
        return new ResponseEntity<>(orderService.findAll(),
                HttpStatus.OK);
    }


    @GetMapping("/twoParam")
    public ResponseEntity<List<Order>> findOrderByPrice(@RequestParam Double minWeight,
                                                        @RequestParam Double maxWeight) {
        return new ResponseEntity<>(orderService.getOrderByWeight(minWeight, maxWeight),
                HttpStatus.OK);
    }


    @GetMapping("/search")
    public Page<Order> searchOrder(
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) Double minWeight,
            @RequestParam(required = false) Double maxWeight,
            @RequestParam(required = false) String city,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return orderService.search(price, minWeight, maxWeight,
                city, pageable);
    }
}
