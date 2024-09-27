import java.util.*;

class MenuItem {
    private String category;
    private String name;
    private String description;
    private double price;

    public MenuItem(String category, String name, String description, double price) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + description + " - $" + price;
    }
}

class TurkishMenu {
    private List<MenuItem> menuItems;

    public TurkishMenu() {
        menuItems = new ArrayList<>();
        // Adding appetizers
        menuItems.add(new MenuItem("Appetisers", "Hummus", "Creamy chickpea dip with tahini, olive oil, and garlic, served with pita bread.", 7.00));
        menuItems.add(new MenuItem("Appetisers", "Falafel", "Crispy chickpea patties served with tahini sauce and a side of salad.", 8.00));
        menuItems.add(new MenuItem("Appetisers", "Baba Ganoush", "Smoky roasted eggplant dip with tahini, olive oil, and lemon juice, served with pita bread.", 8.00));
        menuItems.add(new MenuItem("Appetisers", "Dolma", "Grape leaves stuffed with rice, pine nuts, and herbs, served with yogurt.", 9.00));

        // Adding salads
        menuItems.add(new MenuItem("Salads", "Shepherd's Salad", "Fresh diced tomatoes, cucumbers, onions, and bell peppers with a lemon-olive oil dressing.", 9.00));
        menuItems.add(new MenuItem("Salads", "Turkish Salad", "Mixed greens with olives, feta cheese, and a red wine vinaigrette.", 10.00));

        // Adding kebabs
        menuItems.add(new MenuItem("Kebabs", "Doner Kebab", "Thinly sliced lamb or chicken served with pita bread, salad, and a choice of sauces.", 13.00));
        menuItems.add(new MenuItem("Kebabs", "Shish Kebab", "Marinated chunks of grilled lamb or beef served with rice, grilled vegetables, and a side of yogurt.", 15.00));
        menuItems.add(new MenuItem("Kebabs", "Adana Kebab", "Spicy minced lamb skewers served with rice, grilled vegetables, and a side of flatbread.", 14.00));
        menuItems.add(new MenuItem("Kebabs", "Iskender Kebab", "Sliced doner kebab served over pieces of pita bread, topped with tomato sauce, melted butter, and yogurt.", 16.00));
        menuItems.add(new MenuItem("Kebabs", "Chicken Kebab", "Grilled marinated chicken skewers served with rice, grilled vegetables, and a side of garlic sauce.", 13.00));

        // Adding side dishes
        menuItems.add(new MenuItem("Side Dishes", "Rice Pilaf", "Flavoured rice with herbs and vegetables.", 5.00));
        menuItems.add(new MenuItem("Side Dishes", "Grilled Vegetables", "Assorted seasonal vegetables grilled and seasoned.", 6.00));
        menuItems.add(new MenuItem("Side Dishes", "Pita Bread", "Freshly baked pita bread.", 6.00));

        // Adding desserts
        menuItems.add(new MenuItem("Desserts", "Baklava", "Sweet pastry layers with honey and nuts.", 7.00));
        menuItems.add(new MenuItem("Desserts", "Rice Pudding", "Creamy and lightly sweetened rice pudding.", 6.00));

        // Adding beverages
        menuItems.add(new MenuItem("Beverages", "Turkish Tea", "Traditional black tea served hot.", 3.00));
        menuItems.add(new MenuItem("Beverages", "Ayran", "Chilled yogurt drink with a hint of salt.", 4.00));
        menuItems.add(new MenuItem("Beverages", "Turkish Coffee", "Strong and aromatic coffee served in small cups.", 4.00));
    }

    public void printFullMenu() {
        System.out.println("Turkish_menu:");
        System.out.printf("%-15s %-20s %-50s %-5s%n", "Category", "Dish", "Description", "Price");
        for (MenuItem item : menuItems) {
            System.out.printf("%-15s %-20s %-50s $%.2f%n", item.getCategory(), item.getName(), item.getDescription(), item.getPrice());
        }
    }

    public void printMenuByCategory(String category) {
        System.out.println("Category: " + category);
        for (MenuItem item : menuItems) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                System.out.println(item);
            }
        }
    }

    public MenuItem getMenuItemByName(String name, String category) {
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(name) && item.getCategory().equalsIgnoreCase(category)) {
                return item;
            }
        }
        return null;
    }
}

public class RestaurantOrderingSystem {
    public static void main(String[] args) {
        TurkishMenu menu = new TurkishMenu();
        Scanner scanner = new Scanner(System.in);

        List<MenuItem> orderedItems = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();

        // Step 1: Display full menu
        menu.printFullMenu();

        // List of categories to iterate through
        String[] categories = {"Appetisers", "Salads", "Kebabs", "Side Dishes", "Desserts", "Beverages"};

        // Step 2: Repeating for all categories
        for (String category : categories) {
            System.out.println("\nWhat " + category + " would you like to order?");
            menu.printMenuByCategory(category);

            String chosenItem;
            int quantity = 0;
            MenuItem selectedItem = null;

            do {
                System.out.println("Please enter a valid " + category + " from the list or type 'none' to skip:");
                chosenItem = scanner.nextLine();

                if (chosenItem.equalsIgnoreCase("none")) {
                    break;
                }

                // Validate the dish name
                selectedItem = menu.getMenuItemByName(chosenItem, category);
                if (selectedItem == null) {
                    System.out.println("Invalid " + category + ". Please choose again.");
                    continue;
                }

                // Validate quantity
                System.out.println("How many " + chosenItem + "(s) would you like to order?");
                while (true) {
                    try {
                        quantity = Integer.parseInt(scanner.nextLine());
                        if (quantity > 0) {
                            break; // Valid quantity
                        } else {
                            System.out.println("Quantity must be positive. Please enter again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity. Please enter a positive number.");
                    }
                }

                // Add the selected item and quantity to the order
                orderedItems.add(selectedItem);
                quantities.add(quantity);

            } while (selectedItem == null || quantity <= 0);
        }

        // Step 7: Generate Invoice
        System.out.println("\n------- Invoice -------");
        System.out.printf("%-15s %-20s %-10s %-10s%n", "Category", "Dish", "Quantity", "Subtotal");
        double totalBill = 0;
        for (int i = 0; i < orderedItems.size(); i++) {
            MenuItem item = orderedItems.get(i);
            int qty = quantities.get(i);
            double subtotal = item.getPrice() * qty;
            totalBill += subtotal;
            System.out.printf("%-15s %-20s %-10d $%-10.2f%n", item.getCategory(), item.getName(), qty, subtotal);
        }
        System.out.println("-----------------------");
        System.out.printf("Total Bill: $%.2f%n", totalBill);
        System.out.println("-----------------------");

        // Step 9: Program exits after invoice
        System.out.println("Thank you for dining with us!");
        scanner.close();
    }
}
