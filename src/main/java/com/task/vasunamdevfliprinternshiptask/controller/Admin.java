package com.task.vasunamdevfliprinternshiptask.controller;

import com.task.vasunamdevfliprinternshiptask.dao.CustomerRepo;
import com.task.vasunamdevfliprinternshiptask.dao.OrderRepo;
import com.task.vasunamdevfliprinternshiptask.dao.ShipmentRepo;
import com.task.vasunamdevfliprinternshiptask.entities.Customer;
import com.task.vasunamdevfliprinternshiptask.entities.PurchasedOrder;
import com.task.vasunamdevfliprinternshiptask.entities.Shipment;
import com.task.vasunamdevfliprinternshiptask.entities.ShipmentId;
import com.task.vasunamdevfliprinternshiptask.helper.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class Admin {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private OrderRepo purchasedOrderRepo;
    @Autowired
    private ShipmentRepo shipmentRepo;
    @RequestMapping("/control-panel")
    public String controlPanel(Model model){
        model.addAttribute("title", "Control Panel - Vasu Namdev Flipr Internship Task");
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        PurchasedOrder purchasedOrder = new PurchasedOrder();
        model.addAttribute("purchasedOrder", purchasedOrder);
        Shipment shipment = new Shipment();
        model.addAttribute("shipment", shipment);
        return "admin/control-panel";
    }
    @PostMapping("/add-customer")
    public String addCustomer(@ModelAttribute("customer") Customer customer,Model model){
        try{
            System.out.println(customer);
            this.customerRepo.save(customer);
            Message message = new Message("Customer added successfully", "success");
            model.addAttribute("message", message);
        } catch (Exception e) {
            e.printStackTrace();
            Message message = new Message("Failed to add customer", "danger");
            model.addAttribute("message", message);
        }
        return "admin/control-panel";
    }
    @PostMapping("/add-purchased-order")
    public String addPurchasedOrder(@ModelAttribute("purchasedOrder") PurchasedOrder purchasedOrder,@RequestParam("customerId")int cId, Model model){
        try{
            System.out.println(purchasedOrder);
            Customer customer = this.customerRepo.findById(cId).get();
            purchasedOrder.setCustomer(customer);
            customer.getPurchasedOrders().add(purchasedOrder);
            this.purchasedOrderRepo.save(purchasedOrder);
            this.customerRepo.save(customer);
            Message message = new Message("Purchased Order added successfully", "success");
            model.addAttribute("message", message);
        } catch (Exception e) {
            e.printStackTrace();
            Message message = new Message("Failed to add purchased order", "danger");
            model.addAttribute("message", message);
        }
        return "admin/control-panel";
    }
    @PostMapping("/add-shipment")
    public String addShipment(@ModelAttribute("shipment") Shipment shipment,@RequestParam("orderId")int oId,@RequestParam("customerId")int cId, Model model){
        try{
            System.out.println(shipment);
            ShipmentId shipmentId = new ShipmentId(oId, cId);
            shipment.setId(shipmentId);
            this.shipmentRepo.save(shipment);
            Message message = new Message("Shipment added successfully", "success");
            model.addAttribute("message", message);
        } catch (Exception e) {
            e.printStackTrace();
            Message message = new Message("Failed to add shipment", "danger");
            model.addAttribute("message", message);
        }
        return "admin/control-panel";
    }
    @RequestMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("title", "Dashboard - Vasu Namdev Flipr Internship Task");
        List<Customer> customers = customerRepo.findAll();
        model.addAttribute("customers", customers);
        List<PurchasedOrder> orders = purchasedOrderRepo.findAll();
        model.addAttribute("orders", orders);
        List<Shipment> shipments = shipmentRepo.findAll();
        model.addAttribute("shipments", shipments);
        return "admin/dashboard";
    }
    @RequestMapping("/city-order")
    public String cityOrder(Model model){
        model.addAttribute("title", "City Order - Vasu Namdev Flipr Internship Task");
        return "admin/city-order";
    }
    @PostMapping("/searchCity")
    public String searchCity(@RequestParam("city") String city, Model model){
        List<Customer> customers = customerRepo.findByCustomerCity(city);
       List<PurchasedOrder> orders = new ArrayList<PurchasedOrder>();
        for (Customer customer : customers) {
            if(customer.getPurchasedOrders().size() > 0){
                orders.addAll(customer.getPurchasedOrders());
            }
        }
        model.addAttribute("orders",orders);
        return "admin/city-order";
    }
    @PostMapping("/searchCustomer")
    public String searchCustomer(@RequestParam("city") String city, Model model){
        List<Customer> customers = customerRepo.findByCustomerCity(city);
       List<PurchasedOrder> orders = new ArrayList<PurchasedOrder>();
        for (Customer customer : customers) {
            if(customer.getPurchasedOrders().size() > 0){
                orders.addAll(customer.getPurchasedOrders());
            }
        }
        model.addAttribute("orders",orders);
        return "admin/customer-order";
    }
    @RequestMapping("/customer-order")
    public String customerOrder(Model model){
        model.addAttribute("title", "Customer Order - Vasu Namdev Flipr Internship Task");
        List<PurchasedOrder> orders = purchasedOrderRepo.findAll();
        model.addAttribute("orders", orders);
        return "admin/customer-order";
    }
}
