package com.pattern.command;

public class BuyOrder
  implements Order {

  private final Stock stock;

  public BuyOrder(Stock stock) {
    this.stock = stock;
  }

  @Override
  public void execute() {
    stock.buy();
  }
}
