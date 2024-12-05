package WebShop;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to the cart.");
    }

    public void removeProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                products.remove(product);
                System.out.println(productName + " removed from the cart.");
                return;
            }
        }
        System.out.println("Product not found in the cart.");
    }

    public void viewCart() {
        if (products.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Cart contents:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}
