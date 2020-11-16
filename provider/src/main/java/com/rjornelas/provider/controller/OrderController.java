package com.rjornelas.provider.controller;

import com.rjornelas.provider.dto.OrderItemDTO;
import com.rjornelas.provider.model.Order;
import com.rjornelas.provider.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public Order placeOrder(@RequestBody List<OrderItemDTO> products) {
        LOGGER.info("PEDIDO RECEBIDO");
        return orderService.placeOrder(products);
    }

    @RequestMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
