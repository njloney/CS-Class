import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {

    private int orderNumber;
    private String orderTime;
    private String orderDay;
    private Customer customer;
    private List<Beverage> beverageList;

    public Order(String orderTime, String orderDay, Customer customer) {
        this.orderNumber = generateOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // deep copy of the customer
        this.beverageList = new ArrayList<>();
    }

    private int generateOrderNumber() {
        Random random = new Random();
        return 10000 + random.nextInt(80000);
    }

    public void addNewBeverage(Beverage beverage) {
        beverageList.add(beverage);
    }

    public void addNewBeverage(String name, String type, String size) {
        Beverage beverage = null;
        switch (type.toLowerCase()) {
            case "alcohol":
                beverage = new Alcohol(name, type, size);
                break;
            // add more cases for other types of beverages here
        }
        if (beverage != null) {
            addNewBeverage(beverage);
        }
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getOrderDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer); // return a deep copy of the customer
    }

    public List<Beverage> getBeverageList() {
        return new ArrayList<>(beverageList); // return a copy of the beverage list
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Beverage beverage : beverageList) {
            totalPrice += beverage.calcPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ").append(orderNumber).append(" (").append(orderTime).append(" on ").append(orderDay).append(")\n");
        sb.append("Customer: ").append(customer).append("\n");
        sb.append("Beverages:\n");
        for (Beverage beverage : beverageList) {
            sb.append("- ").append(beverage).append("\n");
        }
        sb.append("Total price: $").append(getTotalPrice());
        return sb.toString();
    }

    @Override
    public int compareTo(Order o) {
        return Integer.compare(orderNumber, o.orderNumber);
    }
}
