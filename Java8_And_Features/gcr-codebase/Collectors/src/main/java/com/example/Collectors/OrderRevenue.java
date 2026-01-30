package com.example.Collectors;

import java.util.*;
import java.util.stream.*;

class Order {
    private String customer;
    private double amount;

    public Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public String getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }
}

public class OrderRevenue {
    public static void main(String[] args) {
        List<Order> orders = List.of(
            new Order("Anmol", 1200),
            new Order("Ravi", 800),
            new Order("Anmol", 500),
            new Order("Ravi", 700)
        );

        Map<String, Double> revenueByCustomer =
            orders.stream()
                  .collect(Collectors.groupingBy(
                      Order::getCustomer,
                      Collectors.summingDouble(Order::getAmount)
                  ));

        System.out.println(revenueByCustomer);
    }
}
