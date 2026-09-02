package assignment2.model;

public abstract class FoodOrder {

    private int orderId;
    private String customerName;
    private double amount;

    protected static int orderCount = 0;

    public static String restaurantName = "Food Express";

    public FoodOrder(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        orderCount++;
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    // Setters
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Abstract method
    public abstract double calculateDeliveryCharge();

    // Static method
    public static void displayTotalOrders() {
        System.out.println("Total Orders Created: " + orderCount);
    }

    public void displayBill() {
        System.out.println("Order ID      : " + orderId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Amount        : Rs. " + amount);
    }
}