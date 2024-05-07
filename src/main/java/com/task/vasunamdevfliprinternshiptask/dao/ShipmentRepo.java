package com.task.vasunamdevfliprinternshiptask.dao;

import com.task.vasunamdevfliprinternshiptask.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepo extends JpaRepository<Shipment, Integer> {
}
