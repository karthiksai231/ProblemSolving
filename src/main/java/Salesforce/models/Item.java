package Salesforce.models;

public class Item {
  private String itemName;
  private double costPrice;
  private double sellingPrice;

  public Item(String itemName, double costPrice, double sellingPrice) {
    this.itemName = itemName;
    this.costPrice = costPrice;
    this.sellingPrice = sellingPrice;
  }

  public String getItemName() {
    return itemName;
  }

  public double getCostPrice() {
    return costPrice;
  }

  public double getSellingPrice() {
    return sellingPrice;
  }
}
