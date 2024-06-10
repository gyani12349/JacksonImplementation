
//POJO Class


package com.example.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// This annotation will ignore any unknown property in trades.json here for example it is "4.rainyDay"
@JsonIgnoreProperties(ignoreUnknown=true)

public class Trade {
  
  // This annotation will map the property "1.symbol" to "symbol" i.e, in trades.json it is "symbol" but in tradesFancier.json it is "1. symbol" so it'll work for both
  @JsonProperty("1. symbol")
  public String symbol;

  @JsonProperty("2. quantity")
  public int quantity;

  @JsonProperty("3. purchaseDate")
  public String purchaseDate;
  
  
  public Trade() {
  }
  
  public Trade(String symbol, int quantity, String purchaseDate) {
    this.symbol = symbol;
    this.quantity = quantity;
    this.purchaseDate = purchaseDate;
  }

  @Override
  public String toString() {
    return "Trade [purchaseDate=" + purchaseDate + ", quantity=" + quantity + ", symbol=" + symbol + "]";
  }
}
