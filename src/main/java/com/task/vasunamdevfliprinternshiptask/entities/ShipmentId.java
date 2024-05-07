package com.task.vasunamdevfliprinternshiptask.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShipmentId implements Serializable {
    private int orderId;
    private int customerId;

}

