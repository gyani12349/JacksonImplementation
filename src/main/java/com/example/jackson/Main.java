package com.example.jackson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Main {

  // Optional - Prsing the JSOn manually without using Jackson/ any 3rd party library
  public void parseJsonManually(File file) throws JsonParseException, JsonMappingException, IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            
            while ((line = br.readLine()) != null) {
                jsonBuilder.append(line.trim());
            }
            
            String jsonString = jsonBuilder.toString();
            parseJsonString(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }

  }

  //Helper Method
  private void parseJsonString(String jsonString) {
    jsonString = jsonString.substring(1, jsonString.length() - 1); // Remove curly braces

    String[] keyValuePairs = jsonString.split(",");
    for (String pair : keyValuePairs) {
        String[] entry = pair.split(":");
        String key = entry[0].trim().replaceAll("\"", "");
        String value = entry[1].trim().replaceAll("\"", "");

        System.out.println(key + ": " + value);
    }
}



  //Automatic parsing of JSON file using Jackson
  public void parseJsonJacksomatically(File inputFile, File outputFile) throws JsonParseException, JsonMappingException, IOException {

    //Initialize objectMapper (a part of jackson library)
    ObjectMapper objectMapper = new ObjectMapper();

    //De-serialize json to java object
    Trade[] trades = objectMapper.readValue(inputFile, Trade[].class);
    System.out.println("Deserialized(read) successfully");

    //Printing the Deserialized output
    for (Trade trade : trades) {
      System.out.println(trade);
    }

    // Uncomment these past Milestone 1 to serialize the JSON read
    // Serialize back the Java Trade objects to a JSON file
    objectMapper.writeValue(outputFile, trades);
    System.out.println("Serialized(wrote) successfully");
  }

  // Milestone 1
  public void writeImportantPurchasesToFile(int threshold, File inputFile, File outputFile) 
      throws JsonParseException, JsonMappingException, IOException {
    List<Trade> impTrades = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

    Trade[] trades = objectMapper.readValue(inputFile, Trade[].class);
    
    for (Trade trade : trades) {
      if (trade.quantity > threshold) {
        impTrades.add(trade);
      }
    }

    // TODO: Add method arguments
    // Whats happening is impTrades has all the values where qty is >50 and is getting added to impTrades.json file (outputFile)
    objectMapper.writeValue(outputFile, impTrades);
  }

  // Milestone 4
  public void parseJsonJacksomaticallyPrivate(File inputFile, File outputFile) 
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    TradePrivate[] trades = objectMapper.readValue(inputFile, TradePrivate[].class);
    System.out.println("Deserialized(read) successfully");
    
    for (TradePrivate trade : trades) {
      System.out.println(trade);
    }

    objectMapper.writeValue(outputFile, trades);
    System.out.println("Serialized(wrote) successfully");
  }

  public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    Main main = new Main();

    // Input JSON files to be deserialized
    File trades = new File("C:\\Users\\Ipsita\\Desktop\\Crio\\Jackson\\jackson\\src\\main\\java\\com\\example\\jackson\\trades.json");
    File tradesFancy = new File("C:\\Users\\Ipsita\\Desktop\\Crio\\Jackson\\jackson\\src\\main\\java\\com\\example\\jackson\\tradesFancy.json");
    File tradesFancier = new File("C:\\Users\\Ipsita\\Desktop\\Crio\\Jackson\\jackson\\src\\main\\java\\com\\example\\jackson\\tradesFancier.json");

    // Serialized output JSON files
    File impTrades = new File("C:\\Users\\Ipsita\\Desktop\\Crio\\Jackson\\jackson\\src\\main\\java\\com\\example\\jackson\\impTrades.json");
    File outputFile = new File("C:\\Users\\Ipsita\\Desktop\\Crio\\Jackson\\jackson\\src\\main\\java\\com\\example\\jackson\\readOutput.json");

    // uncomment below line to run your manual json parsing logic
    //main.parseJsonManually(trades);

    /* 
    /* uncomment below line to use Jackson
    /* use json input files as said in instructions
    /* Files - trades/tradesFancy/tradesFancier
    */
    //main.parseJsonJacksomatically(tradesFancier, outputFile);

    // uncomment this to execute writeImportantPurchasesToFile()
     //main.writeImportantPurchasesToFile(50,trades, impTrades);

    // Uncomment in Milestone 4
    main.parseJsonJacksomaticallyPrivate(trades, outputFile);

    System.out.println("Running completed");
  }
}
