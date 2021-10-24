package com.pattern.command;

public class SellOrder
  implements Order {

  private final Stock stock;

  public SellOrder(Stock stock) {
    this.stock = stock;
  }

  @Override
  public void execute() {
    stock.sell();
  }
}
