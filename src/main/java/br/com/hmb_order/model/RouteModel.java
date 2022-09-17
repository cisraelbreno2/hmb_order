package br.com.hmb_order.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "route")
public class RouteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String description;
}
