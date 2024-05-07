package com.task.vasunamdevfliprinternshiptask.entities;
import com.task.vasunamdevfliprinternshiptask.entities.Customer;
import com.task.vasunamdevfliprinternshiptask.entities.PurchasedOrder;
import com.task.vasunamdevfliprinternshiptask.entities.ShipmentId;
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
public class Shipment {

    @EmbeddedId
    private ShipmentId id;
    private String shipmentAddress;
    private String shipmentCity;
    private String shipmentPincode;

    // Constructors, getters, and setters
}
