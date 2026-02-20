import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.Predicate;
import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    private Inventory inv;
    private Product laptop;
    private Product mouse;
    private Product monitor;

    @BeforeEach
    void setUp() {
        inv = new Inventory();
        laptop = new Product("Laptop", "TECH-001", 1200);
        mouse = new Product("Mouse", "TECH-002", 25);
        monitor = new Product("Monitor", "TECH-003", 300);
    }

    // --- Part 1: Product class (constructor & getters) ---

    @Test
    void testProductConstructorAndGetters() {
        Product p = new Product("Keyboard", "ACC-010", 75);
        assertEquals("Keyboard", p.getName());
        assertEquals("ACC-010", p.getSku());
        assertEquals(75, p.getPrice());
    }

    // --- Part 2: Inventory implements IInventory ---

    @Test
    void testInventoryImplementsIInventory() {
        assertInstanceOf(IInventory.class, inv);
    }

    // --- Part 3: addProduct & getItemCount ---

    @Test
    void testEmptyInventoryHasZeroItems() {
        assertEquals(0, inv.getItemCount());
    }

    @Test
    void testAddOneProduct() {
        inv.addProduct(laptop);
        assertEquals(1, inv.getItemCount());
    }

    @Test
    void testAddThreeProducts() {
        inv.addProduct(laptop);
        inv.addProduct(mouse);
        inv.addProduct(monitor);
        assertEquals(3, inv.getItemCount());
    }

    // --- Part 3: getProductBySku ---

    @Test
    void testGetProductBySkuFound() {
        inv.addProduct(laptop);
        inv.addProduct(mouse);
        inv.addProduct(monitor);

        Product found = inv.getProductBySku("TECH-002");
        assertNotNull(found);
        assertEquals("Mouse", found.getName());
        assertEquals("TECH-002", found.getSku());
        assertEquals(25, found.getPrice());
    }

    @Test
    void testGetProductBySkuNotFound() {
        inv.addProduct(laptop);
        inv.addProduct(mouse);
        inv.addProduct(monitor);

        Product notFound = inv.getProductBySku("TECH-999");
        assertNull(notFound);
    }

    @Test
    void testGetProductBySkuFromEmptyInventory() {
        assertNull(inv.getProductBySku("TECH-001"));
    }

    @Test
    void testGetProductBySkuReturnsFirstMatch() {
        inv.addProduct(laptop);
        inv.addProduct(new Product("Laptop v2", "TECH-001", 1500));

        Product found = inv.getProductBySku("TECH-001");
        assertNotNull(found);
        assertEquals("Laptop", found.getName());
    }

    // --- Part 4: totalValueMatching (Lambdas/Predicates) ---

    @Test
    void testTotalValueMatchingExpensiveItems() {
        inv.addProduct(laptop);
        inv.addProduct(mouse);
        inv.addProduct(monitor);

        Predicate<Product> isExpensive = p -> p.getPrice() > 100;
        assertEquals(1500, inv.totalValueMatching(isExpensive));
    }

    @Test
    void testTotalValueMatchingAllItems() {
        inv.addProduct(laptop);
        inv.addProduct(mouse);
        inv.addProduct(monitor);

        Predicate<Product> all = p -> true;
        assertEquals(1525, inv.totalValueMatching(all));
    }

    @Test
    void testTotalValueMatchingNoItems() {
        inv.addProduct(laptop);
        inv.addProduct(mouse);
        inv.addProduct(monitor);

        Predicate<Product> none = p -> false;
        assertEquals(0, inv.totalValueMatching(none));
    }

    @Test
    void testTotalValueMatchingOnEmptyInventory() {
        Predicate<Product> all = p -> true;
        assertEquals(0, inv.totalValueMatching(all));
    }

    @Test
    void testTotalValueMatchingByName() {
        inv.addProduct(laptop);
        inv.addProduct(mouse);
        inv.addProduct(monitor);

        Predicate<Product> isMouse = p -> p.getName().equals("Mouse");
        assertEquals(25, inv.totalValueMatching(isMouse));
    }
}
