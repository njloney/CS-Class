import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();

        System.out.println("The current order in process can have at most " + bevShop.getMaxOrder() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAge() + "\n");

        while (true) {
            System.out.println("Start please a new order:");
            System.out.println("Your Total Order for now is " + bevShop.getOrderPrice() + "\n");

            System.out.print("Would you please enter your name ");
            String name = scanner.nextLine();

            System.out.print("Would you please enter your age ");
            int age = scanner.nextInt();
            scanner.nextLine();

            Customer customer = new Customer(name, age);

            if (customer.isAllowedToOrderAlcohol()) {
                System.out.println("Your age is above " + (bevShop.getMinAge() - 1) + " and you are eligible to order alcohol\n");
            } else {
                System.out.println("Your Age is not appropriate for alcohol drink!!\n");
            }

            while (true) {
                System.out.print("Would you please add a drink (COFFEE/SMOOTHIE/ALCOHOL) ");
                String drinkType = scanner.nextLine().toUpperCase();

                if (drinkType.equals("COFFEE")) {
                    bevShop.addNewOrder(new Coffee());
                } else if (drinkType.equals("SMOOTHIE")) {
                    bevShop.addNewOrder(new Smoothie());
                } else if (drinkType.equals("ALCOHOL")) {
                    if (!customer.isAllowedToOrderAlcohol()) {
                        System.out.println("Your Age is not appropriate for alcohol drink!!");
                        continue;
                    }

                    if (bevShop.getOrderAlcoholCount() == bevShop.getMaxOrder()) {
                        System.out.println("You have a maximum alcohol drinks for this order");
                        continue;
                    }

                    bevShop.addNewOrder(new Alcohol());
                }

                System.out.println("The current order of drinks is " + bevShop.getOrderItemsCount());
                System.out.println("The Total Price on the Order: " + bevShop.getOrderPrice() + "\n");

                if (bevShop.getOrderItemsCount() == bevShop.getMaxOrder() + bevShop.getMaxFruits()) {
                    break;
                }
            }

            System.out.println("Total items on your order is " + bevShop.getOrderItemsCount());
            System.out.println("The Total Price on the Order: " + bevShop.getOrderPrice() + "\n");

            bevShop.createNewOrder();

            System.out.print("Would you like to start a new order? (yes/no) ");
            String choice = scanner.nextLine();

            if (!choice.equals("yes")) {
                break;
            }
        }
    }
}
