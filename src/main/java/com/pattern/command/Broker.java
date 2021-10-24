package com.pattern.command;

import java.util.LinkedList;

public class Broker {

  private LinkedList<Order> orders = new LinkedList<>();

  public void takeOrder(Order order) {
    orders.add(order);
  }

  public void placeOrder() {
    while (!orders.isEmpty()) {
      orders.pollFirst().execute();
    }
  }
}
