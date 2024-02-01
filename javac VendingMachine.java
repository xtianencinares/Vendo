import java.util.Scanner;

public class VendingMachine {
    private static String[] items = {"Cola", "Chips", "Candy"};
    private static double[] prices = {55.0, 21.0, 1.75};
    private static double totalAmount = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
  
        while (true) {
            displayMenu();
 
            System.out.print("Insert money (0 to exit): "); 
            double moneyInserted = scanner.nextDouble();  

            if (moneyInserted == 0) {
                System.out.println("Exiting the vending machine. Goodbye!");
                break;
            }
  
            totalAmount += moneyInserted;

            selectItem(scanner); 
        }

        scanner.close(); 
    }

    private static void displayMenu() {
        System.out.println("\n=== Vending Machine ===");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i] + " - $" + prices[i]);
        }
        System.out.println("================================");
    }

    private static void selectItem(Scanner scanner) {
        System.out.print("Enter the number of the item you want to buy: ");
        int itemNumber = scanner.nextInt();

        if (itemNumber >= 1 && itemNumber <= items.length) {
            double itemPrice = prices[itemNumber - 1];

            if (totalAmount >= itemPrice) {
                System.out.println("You have purchased " + items[itemNumber - 1] + ".");
                totalAmount -= itemPrice;
                System.out.println("Remaining balance: $" + totalAmount);
            } else {
                System.out.println("Not enough money. Please insert more money.");
            }
        } else {
            System.out.println("Invalid item number. Please try again.");
        }
    }
}
