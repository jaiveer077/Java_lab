package food.service;

import food.model.FoodOrder;

public class OrderService {

    public static double calculateFinalAmount(FoodOrder order) {

        double amount = order.getAmount();
        double deliveryCharge = order.calculateDeliveryCharge();

        double discount = 0;

        if (order instanceof food.model.Discountable) {
            food.model.Discountable d =
                    (food.model.Discountable) order;

            discount = d.applyDiscount();
        }

        return amount - discount + deliveryCharge;
    }
}
