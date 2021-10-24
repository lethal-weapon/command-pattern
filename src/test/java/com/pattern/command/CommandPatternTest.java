package com.pattern.command;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CommandPatternTest {

  static ByteArrayOutputStream output;

  @BeforeEach
  void setUp() {
    output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));
  }

  String systemOut() {
    return output.toString();
  }

  @Test
  void ShouldBuyStockWhenPlaceOrderGivenABrokerABuyOrder() {
    Order order = new BuyOrder(new Stock("AAPL", 99));
    Broker broker = new Broker();
    broker.takeOrder(order);
    String expected = "Brought stock AAPL with a quantity of 99";

    broker.placeOrder();

    assertEquals(expected, systemOut());
  }

  @Test
  void ShouldSellStockWhenPlaceOrderGivenABrokerASellOrder() {
    Order order = new SellOrder(new Stock("BABA", 199));
    Broker broker = new Broker();
    broker.takeOrder(order);
    String expected = "Sold stock BABA with a quantity of 199";

    broker.placeOrder();

    assertEquals(expected, systemOut());
  }

  @Test
  void ShouldHandleOrdersInSequenceWhenPlaceOrderGivenABrokerMultipleOrders() {
    Order order1 = new SellOrder(new Stock("MSFT", 299));
    Order order2 = new BuyOrder(new Stock("TSLA", 399));
    Order order3 = new SellOrder(new Stock("INTC", 499));
    String expected1 = "Sold stock MSFT with a quantity of 299";
    String expected2 = "Brought stock TSLA with a quantity of 399";
    String expected3 = "Sold stock INTC with a quantity of 499";
    Broker broker = new Broker();
    broker.takeOrder(order1);
    broker.takeOrder(order2);
    broker.takeOrder(order3);

    broker.placeOrder();

    assertTrue(systemOut().startsWith(expected1));
    assertTrue(systemOut().contains(expected2));
    assertTrue(systemOut().endsWith(expected3));
  }
}
