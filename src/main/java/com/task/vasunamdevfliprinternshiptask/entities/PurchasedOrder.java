package com.task.vasunamdevfliprinternshiptask.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PurchasedOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private String productName;
    private int quantity;
    private double price;
    private double MRP;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
}
