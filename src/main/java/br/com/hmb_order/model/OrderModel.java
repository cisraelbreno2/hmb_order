package br.com.hmb_order.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer orderNumber;

    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private RouteModel route;

    @Column(name = "user_id" , nullable = false)
    private Long userId;

    @Column(name = "client_id" , nullable = false)
    private Long clientId;

    private Double total;

    @Column(columnDefinition = "boolean default false")
    private Boolean remove;
}
