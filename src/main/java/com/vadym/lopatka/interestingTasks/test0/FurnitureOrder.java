package com.vadym.lopatka.interestingTasks.test0;

import java.util.HashMap;
import java.util.Optional;

public class FurnitureOrder implements FurnitureOrderInterface {
    private HashMap<Furniture, Integer> order;

    public static void main(String[] args) {
        FurnitureOrder furnitureFactory = new FurnitureOrder();
        System.out.println(Furniture.CHAIR.cost());
        furnitureFactory.addToOrder(Furniture.CHAIR, 4);

        System.out.println(furnitureFactory.getTypeCost(Furniture.CHAIR));//400.0f,
    }

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        order = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        Integer integer = order.get(type);
        order.put(type, (integer != null) ? integer + furnitureCount : furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return order;
    }

    public float getTotalOrderCost() {
//        order.keySet().stream().reduce(0.0f, (a, b) -> getTypeCost(a) + getTypeCost(b));
        float result = 0.0f;
        for (Furniture item : order.keySet())
            result += getTypeCost(item);

        return result;
    }

    public int getTypeCount(Furniture type) {
        return order.get(type) != null ? order.get(type) : 0;
    }

    public float getTypeCost(Furniture type) {
//        if (order.get(type) == null)
//            return 0.0f;
//
//        return type.cost() * order.get(type).floatValue();

        return Optional.ofNullable(order.get(type))
                .map(c -> c * type.cost())
                .orElse(0.0f);
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        return order.values()
                .stream()
                .reduce(Integer::sum)
                .orElse(0);
    }
}