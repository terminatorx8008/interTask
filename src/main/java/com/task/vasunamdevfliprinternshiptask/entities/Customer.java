package com.task.vasunamdevfliprinternshiptask.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerMobileNumber;
    private String customerCity;
    @OneToMany
    private List<PurchasedOrder> purchasedOrders;
}
