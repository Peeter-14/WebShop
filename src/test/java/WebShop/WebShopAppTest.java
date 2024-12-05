package WebShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebShopAppTest {

    private Cart cart;
    private Product product;

    @BeforeEach
    void setUp() {
         cart = new Cart();
        product = new Product("Laptop", 1200.0);
    }

    @Test
    void testAddProductToCart() {
        // Hozzáadunk egy terméket a kosárhoz
        cart.addProduct(product);

        // Ellenőrizzük, hogy a kosár tartalmazza-e amit hozzáadtunk
        assertEquals(1200.0, cart.calculateTotal(), "Product should be added to the cart");
    }

    @Test
    void testRemoveProductFromCart() {
        // Hozzáadunk egy terméket, majd eltávolítjuk
        cart.addProduct(product);
        cart.removeProduct("Laptop");

        // Ellenőrizzük, hogy a kosár üres, és a termék eltávolításra került-e
        assertEquals(0.0, cart.calculateTotal(), "Product should be removed from the cart");
    }

    @Test
    void testViewCart() {
        // Hozzáadunk egy terméket és ellenőrizzük a kosár tartalmát
        cart.addProduct(product);

        // Ellenőrizzük, hogy a kosár tartalma megfelelő-e
        assertTrue(cart.calculateTotal() > 0, "Cart should contain products");
    }
}
