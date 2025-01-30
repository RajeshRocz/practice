package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    public static void main(String[] args) {
        MenuRecommendation menuRecommendation = new MenuRecommendation();

        System.out.println(menuRecommendation.getRecommendedItem());
        menuRecommendation.addItem(1,"Item1");
        menuRecommendation.rateItem(1,5);
        System.out.println(menuRecommendation.getRecommendedItem());
        menuRecommendation.outOfStockItem(1);
        menuRecommendation.rateItem(1,4);
        menuRecommendation.rateItem(1,4);
        menuRecommendation.addItem(2,"Item2");
        menuRecommendation.makeDealOfTheDayItem(2);
        System.out.println(menuRecommendation.getRecommendedItem());
    }
}

class MenuRecommendation {

    private final Map<Integer, Item> itemMap;
    private Item dealOfTheDayItem;

    public MenuRecommendation() {
        this.itemMap = new HashMap<>();
        this.dealOfTheDayItem = null;
    }

    public void addItem(int itemId, String displayName) {
        Item item = new Item(itemId, displayName);
        itemMap.put(itemId, item);
    }

    public Item getRecommendedItem() {

        if (dealOfTheDayItem != null && dealOfTheDayItem.isInStock) {
            return dealOfTheDayItem;
        }

        Item recommendedItem = null;
        for (Item item : itemMap.values()) {
            if (item.isInStock) {
                if (recommendedItem == null || (item.getAverageRatting() > recommendedItem.getAverageRatting())
                        || (item.getAverageRatting() == recommendedItem.getAverageRatting() && item.rattingCount > recommendedItem.rattingCount)
                        || (item.getAverageRatting() == recommendedItem.getAverageRatting() && item.rattingCount == recommendedItem.rattingCount && item.id > recommendedItem.id)
                ) {
                    recommendedItem = item;
                }
            }
        }

        return recommendedItem;
    }

    public void outOfStockItem(int itemId) {
        Item item = itemMap.get(itemId);
        if(null!=item) {
            item.isInStock = false;
            if (dealOfTheDayItem != null && dealOfTheDayItem.id == itemId) {
                dealOfTheDayItem = null;
            }
        }
    }

    public void restockItem(int itemId) {
        Item item = itemMap.get(itemId);
        if (null != item) {
            item.isInStock = true;
        }
    }

    public void makeDealOfTheDayItem(int itemId) {
        Item item = itemMap.get(itemId);
        if (null != item && item.isInStock) {
            dealOfTheDayItem = item;
        }
    }

    public void rateItem(int itemId, int ratting) {
        Item item = itemMap.get(itemId);
        if(item!=null && item.isInStock) {
            item.rateItem(ratting);
        }
    }

}

class Item {
    Integer id;
    String name;
    boolean isInStock;
    boolean isDealOfTheDay;
    Integer rattingTotal;
    Integer rattingCount;


    public Item(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.isInStock = true;
        this.isDealOfTheDay = false;
        this.rattingTotal = 0;
        this.rattingCount = 0;
    }

    public void rateItem(int rattingValue) {

            rattingCount++;
            rattingTotal += rattingValue;

    }

    public double getAverageRatting() {
        return rattingTotal == 0 ? 0 : (double) rattingTotal / rattingCount;
    }

    @Override
    public String toString() {
        return id+" "+name+" "+rattingTotal;
    }
}
