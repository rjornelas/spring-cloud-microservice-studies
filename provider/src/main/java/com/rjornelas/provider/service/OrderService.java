package com.rjornelas.provider.service;

import com.rjornelas.provider.dto.OrderItemDTO;
import com.rjornelas.provider.model.Order;
import com.rjornelas.provider.model.OrderItem;
import com.rjornelas.provider.model.Product;
import com.rjornelas.provider.repository.OrderRepository;
import com.rjornelas.provider.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order placeOrder(List<OrderItemDTO> itens) {

        if(itens == null) {
            return null;
        }

        List<OrderItem> orderItens = toOrderItem(itens);
        Order order = new Order(orderItens);
        order.setPreparationTime(itens.size());
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return this.orderRepository.findById(id).orElse(new Order());
    }

    private List<OrderItem> toOrderItem(List<OrderItemDTO> itens) {

        List<Long> productsId = itens
                .stream()
                .map(OrderItemDTO::getId)
                .collect(Collectors.toList());

        List<Product> orderProducts = productRepository.findByIdIn(productsId);

        List<OrderItem> orderItems = itens
                .stream()
                .map(item -> {
                    Product product = orderProducts
                            .stream()
                            .filter(p -> p.getId() == item.getId())
                            .findFirst().get();

                    OrderItem orderItem = new OrderItem();
                    orderItem.setProduct(product);
                    orderItem.setAmount(item.getAmount());
                    return orderItem;
                })
                .collect(Collectors.toList());
        return orderItems;
    }
}
