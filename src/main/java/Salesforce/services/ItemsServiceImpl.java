package Salesforce.services;

import Salesforce.dto.ItemsDto;
import Salesforce.models.Item;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ItemsServiceImpl {
  public Map<String, Item> itemsMap = new HashMap<>();

  public static void main(String[] args) {
    addItem(null);
  }

  public static void addItem(ItemsDto itemsDto) {
    try {
      DecimalFormat df = new DecimalFormat("0.00");
      // df.setMaximumFractionDigits(2);
      // df.setMinimumFractionDigits(2);
      double d1 = 2.123;
      double d2 = 2;
      System.out.println(df.format(d1));
      System.out.println(df.format(d2));
//      Item item = new Item(
//          itemsDto.getItemName(),
//          Double.parseDouble(itemsDto.getCostPrice()),
//          Double.parseDouble(itemsDto.getSellingPrice()));
    } catch (Exception ex) {
      System.out.println("Unable to add data for item name " + itemsDto.getItemName());
    }
  }
}
