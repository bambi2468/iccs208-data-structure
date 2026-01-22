class Pizza {
    String type;
    static String shop;
    int slices;

    Pizza(String type, int slices) {
        this.type = type;
        this.slices = slices;
    }
}

public class PizzaMain {

    static void swapPizzas(Pizza a, Pizza b) {
        Pizza temp = a;
        a = b;
        b = temp;
    }

    static void sliceUp(Pizza p) {
        p.slices = p.slices * 2;
    }

    static void refreshPizza(Pizza z) {
        z = new Pizza(z.type, 12);
        z.shop = "LittleCaesars";
    }

    public static void main(String[] args) {
        Pizza p1 = new Pizza("Pepperoni", 6);
        Pizza p2 = new Pizza("Cheese", 4);
        Pizza p3 = new Pizza("Pep" + "peroni", 3 * 2);

        Pizza[] orderA = { p1, p2, p3 };
        Pizza[] orderB = { p1, p2, p3 };

        p1.shop = "Dominos";
        p2.shop = "PizzaHut";

        // --- Question 1 ---
        System.out.println(" 1: " + p1.shop);

        // --- Question 2 ---
        System.out.println(" 2: " + (orderA == orderB));

        // --- Question 3 ---
        System.out.println(" 3: " + (p1.shop.equals(p3.shop)));

        // --- Question 4 ---
        sliceUp(orderA[1]);
        System.out.println(" 4: " + p2.slices);

        // --- Question 5 & 6 ---
        swapPizzas(p1, p2);
        System.out.println(" 5: " + p1.type);
        System.out.println(" 6: " + p2.type);

        // --- Question 7 ---
        System.out.println(" 7: " + (p1.slices == p3.slices));

        // --- Question 8 ---
        orderB[0] = p2;
        System.out.println(" 8: " + orderB[0].slices);

        // --- Question 9 & 10 ---
        refreshPizza(p1);
        System.out.println(" 9: " + p1.slices);
        System.out.println("10: " + p2.shop);
    }
}