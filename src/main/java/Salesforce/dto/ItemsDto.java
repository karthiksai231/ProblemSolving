package Salesforce.dto;

public class ItemsDto {
  private String itemName;
  private String costPrice;
  private String sellingPrice;

  public ItemsDto (String itemName, String costPrice, String sellingPrice) {
    this.itemName = itemName;
    this.costPrice = costPrice;
    this.sellingPrice = sellingPrice;
  }

  public String getItemName() {
    return itemName;
  }

  public String getCostPrice() {
    return costPrice;
  }

  public String getSellingPrice() {
    return sellingPrice;
  }
}
