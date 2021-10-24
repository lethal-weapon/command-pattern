package com.pattern.command;

public class Stock {

  private final String code;
  private final int quantity;

  public Stock(String code, int quantity) {
    this.code = code;
    this.quantity = quantity;
  }

  public void buy() {
    System.out.printf(
      "Brought stock %s with a quantity of %d",
      code, quantity
    );
  }

  public void sell() {
    System.out.printf(
      "Sold stock %s with a quantity of %d",
      code, quantity
    );
  }
}
