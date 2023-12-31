package com.ControleDePedidos.api.entities;
import com.ControleDePedidos.api.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table( name = "tb_order")
public class Order implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant momento;

    private String descricao;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name ="cliente_id")
    private User cliente;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> itens = new HashSet<>();

    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private Payment payment;
    public Order (){};

    public Order(Long id, Instant momento,OrderStatus orderStatus, User cliente,String descricao) {
        this.id = id;
        this.momento = momento;
        setOrderStatus(orderStatus);
        this.cliente = cliente;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public User getCliente() {
        return cliente;
    }

    public void setCliente(User cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public OrderStatus getOrderStatus() throws IllegalAccessException {
        return OrderStatus.valueOf(orderStatus);
    }


    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null){
        this.orderStatus = orderStatus.getCodigo();
        }
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItens(){
        return itens;
    }

    public Double getTotal(){
        double sum = 0.0;
        for (OrderItem o : itens){
          sum += o.getSubToltal();
        }
        return sum;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}

