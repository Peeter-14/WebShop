package WebShop;

import java.util.Scanner;

public class WebShopApp {
    static Cart cart = new Cart();
    static Scanner scanner = new Scanner(System.in);
    static boolean isLoggedIn = false;

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    addProductToCart();
                    break;
                case 3:
                    removeProductFromCart();
                    break;
                case 4:
                    viewCart();
                    break;
                case 5:
                    checkout();
                    break;
                case 6:
                    logout();
                    break;
                case 7:
                    System.out.println("Thank you for visiting our webshop. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== WebShop Menu =====");
        System.out.println("1. Log in");
        System.out.println("2. Add product to cart");
        System.out.println("3. Remove product from cart");
        System.out.println("4. View cart");
        System.out.println("5. Checkout");
        System.out.println("6. Log out");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void login() {  // Módosítva: public hozzáférés
        if (isLoggedIn) {
            System.out.println("You are already logged in.");
            return;
        }
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals("user") && password.equals("pass")) {
            isLoggedIn = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private static void addProductToCart() {
        if (!isLoggedIn) {
            System.out.println("Please log in first.");
            return;
        }
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter product price: ");
        double productPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        Product product = new Product(productName, productPrice);
        cart.addProduct(product);
    }

    private static void removeProductFromCart() {
        if (!isLoggedIn) {
            System.out.println("Please log in first.");
            return;
        }
        System.out.print("Enter the name of the product to remove: ");
        String productName = scanner.nextLine();
        cart.removeProduct(productName);
    }

    private static void viewCart() {
        if (!isLoggedIn) {
            System.out.println("Please log in first.");
            return;
        }
        cart.viewCart();
    }


    private static void checkout() {
        if (!isLoggedIn) {
            System.out.println("Please log in first.");
            return;
        }
        double total = cart.calculateTotal();
        System.out.println("Your total is: $" + total);
        System.out.println("Thank you for your purchase!");
        cart = new Cart(); // Reset cart after checkout
    }

    private static void logout() {
        if (!isLoggedIn) {
            System.out.println("You are not logged in.");
            return;
        }
        isLoggedIn = false;
        System.out.println("You have logged out.");
    }
}
