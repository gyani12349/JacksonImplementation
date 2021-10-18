
package com.example.jackson;

public class TradePrivate {

  private String symbol;

  private int quantity;

  private String purchaseDate;

  public TradePrivate() {
  }

  public TradePrivate(String symbol, int quantity, String purchaseDate) {
    this.symbol = symbol;
    this.quantity = quantity;
    this.purchaseDate = purchaseDate;
  }
  
  

  @Override
  public String toString() {
    return "TradePrivate [purchaseDate=" + purchaseDate + ", quantity=" + quantity + ", symbol=" + symbol + "]";
  }
}
