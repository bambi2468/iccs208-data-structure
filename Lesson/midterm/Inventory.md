# Assignment: The Smart Inventory System

## Context

You have been hired to build a backend inventory management module for a local electronics store. The store needs a flexible system to track products, look them up by their unique ID (SKU), and perform calculations on specific subsets of their stock (e.g., calculating the total value of only expensive items).

## Objectives

By completing this assignment, you will demonstrate understanding of:

* Java Class encapsulation (Fields, Constructors, Getters).
* Interfaces and implementation.
* Java Collections (`ArrayList`).
* Functional Programming basics using the `Predicate` interface.

---

## Requirements

### Part 1: The Product Class

Create a concrete class named `Product`. This class represents a physical item in the store.

* **Fields:** It must have three **private** fields:
* `name` (String)
* `sku` (String) - Stands for "Stock Keeping Unit" (a unique ID).
* `price` (int) - We will store the price in whole numbers (e.g., cents or dollars).


* **Constructor:** A public constructor that initializes all three fields.
* **Methods:** Public getter methods for all three fields (`getName`, `getSku`, `getPrice`).

### Part 2: The Inventory Interface

Create an interface named `IInventory`. This defines the contract for any inventory system we might build. It must declare the following methods:

1. `addProduct`: Takes a `Product` and adds it to the inventory.
2. `getItemCount`: Returns the total number of items currently in stock (int).
3. `getProductBySku`: Takes a `sku` (String) and returns the corresponding `Product`.
4. `totalValueMatching`: Takes a `Predicate<Product>` and returns the sum (int) of the prices of all products that satisfy the predicate's condition.
* *Note: You will need to import `java.util.function.Predicate`.*



### Part 3: The Inventory Implementation

Create a class named `Inventory` that implements the `IInventory` interface.

* **Storage:** Use a `private List<Product>` to store the items. Initialize this list as an `ArrayList` inside the constructor.
* **Method Logic:**
* `addProduct`: Append the product to your list.
* `getItemCount`: Return the size of the list.
* `getProductBySku`: Iterate through the list. If a product's SKU matches the input string, return that product. If the loop finishes without finding a match, return `null`.
* `totalValueMatching`: Iterate through the list. Apply the predicate's `test()` method to each product. If it returns true, add that product's price to a running total. Return the final sum.



### Part 4: The Driver Class (Main Method)

Inside the `Inventory` class, write a `main` method to test your system. You must perform the exact steps below to verify your logic:

1. **Setup:**
* Create three products:
* Laptop (SKU: "TECH-001", Price: 1200)
* Mouse (SKU: "TECH-002", Price: 25)
* Monitor (SKU: "TECH-003", Price: 300)


* Instantiate your `Inventory` and add these three products to it.


2. **Basic Operations:**
* Print the current inventory size (Expected: 3).


3. **Search Operations:**
* Search for SKU "TECH-002". If found, print "Found product: [Name]".
* Search for SKU "TECH-999" (which does not exist).
* Handle the potential `null` return safely. If null, print "Product not found."


4. **Advanced Calculation (Lambdas):**
* Create a `Predicate<Product>` called `isExpensive` that returns true if a product's price is greater than 100.
* Call `totalValueMatching` using this predicate.
* Print the result (Expected: 1500, which is the sum of the Laptop and Monitor).



---

## Expected Console Output

```text
Inventory size: 3
Found product: Mouse
Product not found.
Total value of expensive items: 1500

```