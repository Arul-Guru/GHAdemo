package com.userproject.crud.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "price")
    private float price;

    @Column(name="orderDescription")
    private String orderDescription;
    @Column(name="quantity")
    private int quantity;

//    @ManyToOne
//    @JoinColumn(name = "user")
    @Column(name="user")
    private int user;

}
