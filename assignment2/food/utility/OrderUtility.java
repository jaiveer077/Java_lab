package food.utility;

import food.model.FoodOrder;
import food.model.Discountable;

public class OrderUtility {

    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static String generateOrderSummary(FoodOrder order) {

        double discount = 0;

        if (order instanceof Discountable) {
            discount = ((Discountable) order).applyDiscount();
        }

        double delivery = order.calculateDeliveryCharge();

        double finalAmount =
                order.getAmount() - discount + delivery;

        return "Order ID: " + order.getOrderId()
                + ", Customer: " + order.getCustomerName()
                + ", Amount: Rs. " + order.getAmount()
                + ", Discount: Rs. " + discount
                + ", Delivery: Rs. " + delivery
                + ", Final Amount: Rs. " + finalAmount;
    }
}
