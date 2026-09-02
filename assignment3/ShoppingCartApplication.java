import java.util.*;

class ApplicationException extends Exception {
    public ApplicationException(String message) {
        super(message);
    }
}

class ProductException extends ApplicationException {
    public ProductException(String message) {
        super(message);
    }
}

class ProductNotFoundException extends ProductException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

class OutOfStockException extends ProductException {
    public OutOfStockException(String message) {
        super(message);
    }
}

class PaymentException extends ApplicationException {
    public PaymentException(String message) {
        super(message);
    }
}

class InvalidPaymentException extends PaymentException {
    public InvalidPaymentException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends PaymentException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class OrderException extends ApplicationException {
    public OrderException(String message) {
        super(message);
    }
}

class EmptyCartException extends OrderException {
    public EmptyCartException(String message) {
        super(message);
    }
}

class Product {
    String name;
    double price;
    int stock;

    Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

class ShoppingCart {
    ArrayList<Product> products = new ArrayList<>();

    void searchProduct(ArrayList<Product> inventory, String name)
            throws ProductNotFoundException {

        for (Product p : inventory) {
            if (p.name.equalsIgnoreCase(name)) {
                System.out.println("Product found: " + p.name +
                        " | Price: " + p.price +
                        " | Stock: " + p.stock);
                return;
            }
        }

        throw new ProductNotFoundException("Product not found.");
    }

    void addProduct(ArrayList<Product> inventory, String name)
            throws ProductNotFoundException, OutOfStockException {

        for (Product p : inventory) {
            if (p.name.equalsIgnoreCase(name)) {

                if (p.stock <= 0)
                    throw new OutOfStockException("Product is out of stock.");

                products.add(p);
                p.stock--;
                System.out.println("Product added to cart.");
                return;
            }
        }

        throw new ProductNotFoundException("Product not found.");
    }

    void removeProduct(String name)
            throws ProductNotFoundException {

        for (Product p : products) {
            if (p.name.equalsIgnoreCase(name)) {
                products.remove(p);
                System.out.println("Product removed from cart.");
                return;
            }
        }

        throw new ProductNotFoundException("Product not found in cart.");
    }

    double getTotal() {
        double total = 0;

        for (Product p : products)
            total += p.price;

        return total;
    }

    void displayCart() throws EmptyCartException {

        if (products.isEmpty())
            throw new EmptyCartException("Cart is empty.");

        System.out.println("\nCart:");

        for (Product p : products)
            System.out.println(p.name + " - " + p.price);

        System.out.println("Total: " + getTotal());
    }

    void payment(double amount)
            throws EmptyCartException, InvalidPaymentException,
            InsufficientFundsException {

        if (products.isEmpty())
            throw new EmptyCartException("Cannot make payment. Cart is empty.");

        if (amount <= 0)
            throw new InvalidPaymentException("Invalid payment amount.");

        double total = getTotal();

        if (amount < total)
            throw new InsufficientFundsException("Insufficient funds.");

        System.out.println("Payment successful.");
        System.out.println("Change: " + (amount - total));
        products.clear();
    }
}

public class ShoppingCartApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Product> inventory = new ArrayList<>();

        inventory.add(new Product("Laptop", 50000, 2));
        inventory.add(new Product("Phone", 25000, 3));
        inventory.add(new Product("Headphones", 2000, 1));

        ShoppingCart cart = new ShoppingCart();

        while (true) {

            System.out.println("\n1. Search Product");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Display Cart");
            System.out.println("5. Payment");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {

                switch (choice) {

                    case 1:
                        System.out.print("Enter product name: ");
                        cart.searchProduct(inventory, sc.nextLine());
                        break;

                    case 2:
                        System.out.print("Enter product name: ");
                        cart.addProduct(inventory, sc.nextLine());
                        break;

                    case 3:
                        System.out.print("Enter product name: ");
                        cart.removeProduct(sc.nextLine());
                        break;

                    case 4:
                        cart.displayCart();
                        break;

                    case 5:
                        System.out.print("Enter payment amount: ");
                        double amount = sc.nextDouble();
                        cart.payment(amount);
                        break;

                    case 6:
                        System.out.println("Thank you.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (ProductNotFoundException e) {
                System.out.println("Product Error: " + e.getMessage());

            } catch (OutOfStockException e) {
                System.out.println("Stock Error: " + e.getMessage());

            } catch (InvalidPaymentException e) {
                System.out.println("Payment Error: " + e.getMessage());

            } catch (InsufficientFundsException e) {
                System.out.println("Payment Error: " + e.getMessage());

            } catch (EmptyCartException e) {
                System.out.println("Order Error: " + e.getMessage());

            } catch (ApplicationException e) {
                System.out.println("Application Error: " + e.getMessage());
            }
        }
    }
}