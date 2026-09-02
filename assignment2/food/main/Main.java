package food.main;

import food.model.*;
import food.service.OrderService;
import food.utility.OrderUtility;

public class Main {

    public static void main(String[] args) {

        FoodOrder[] orders = new FoodOrder[6];

        orders[0] = new RegularOrder(101, "Rahul", 500);
        orders[1] = new PremiumOrder(102, "Aman", 1000);
        orders[2] = new RegularOrder(103, "Priya", 750);
        orders[3] = new PremiumOrder(104, "Neha", 1200);
        orders[4] = new RegularOrder(105, "Rohan", 900);
        orders[5] = new PremiumOrder(106, "Simran", 1500);

        for (FoodOrder order : orders) {

            System.out.println("\n==============================");

            // Display bill
            order.displayBill();

            // Display discount
            double discount = 0;

            if (order instanceof Discountable) {
                discount =
                    ((Discountable) order).applyDiscount();
            }

            System.out.println("Discount      : Rs. " + discount);

            // Display delivery charge
            double delivery =
                    order.calculateDeliveryCharge();

            System.out.println("Delivery      : Rs. " + delivery);

            // Display final amount
            double finalAmount =
                    OrderService.calculateFinalAmount(order);

            System.out.println("Final Payable : Rs. " + finalAmount);

            // Summary
            System.out.println(
                    OrderUtility.generateOrderSummary(order)
            );
        }

        System.out.println("\n==============================");

        FoodOrder.displayTotalOrders();
    }
}