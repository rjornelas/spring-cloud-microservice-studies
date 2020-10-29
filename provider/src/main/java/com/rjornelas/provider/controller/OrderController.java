package com.rjornelas.provider.controller;

import com.rjornelas.provider.dto.OrderItemDTO;
import com.rjornelas.provider.model.Order;
import com.rjornelas.provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public Order placeOrder(@RequestBody List<OrderItemDTO> products) {
        return orderService.placeOrder(products);
    }

    @RequestMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
