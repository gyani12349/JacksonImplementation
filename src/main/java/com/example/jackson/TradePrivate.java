
package com.example.jackson;

public class TradePrivate {

  private String symbol;

  private int quantity;

  private String purchaseDate;

  public TradePrivate() {
  }

  public String getSymbol() {

    return symbol;

}


public void setSymbol(String symbol) {

    this.symbol = symbol;

}

public int getQuantity() {

  return quantity;

}


public void setQuantity(int quantity) {

  this.quantity = quantity;

}

public String getPurchaseDate() {

  return purchaseDate;

}


public void setPurchaseDate(String purchaseDate) {

  this.purchaseDate = purchaseDate;

}

  public TradePrivate(String symbol, int quantity, String purchaseDate) {
    setSymbol(symbol);
    setQuantity(quantity);
    setPurchaseDate(purchaseDate);


    this.symbol = getSymbol();
    this.quantity = getQuantity();
    this.purchaseDate = getPurchaseDate();
    
  }
  
  

  @Override
  public String toString() {
    return "TradePrivate [purchaseDate=" + purchaseDate + ", quantity=" + quantity + ", symbol=" + symbol + "]";
  }
}
