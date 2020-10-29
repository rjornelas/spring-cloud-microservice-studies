package com.rjornelas.provider.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orderTable")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer preparationTime;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private List<OrderItem> orderItens;

    public Order(List<OrderItem> orderItens) {
        this.orderItens = orderItens;
        this.status = OrderStatus.RECEIVED;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItens() {
        return orderItens;
    }

    public void setOrderItens(List<OrderItem> orderItens) {
        this.orderItens = orderItens;
    }
}
