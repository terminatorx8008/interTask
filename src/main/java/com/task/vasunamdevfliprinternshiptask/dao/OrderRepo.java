package com.task.vasunamdevfliprinternshiptask.dao;

import com.task.vasunamdevfliprinternshiptask.entities.PurchasedOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<PurchasedOrder, Integer>{
}
