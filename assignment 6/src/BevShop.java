import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class BevShop implements BevShopInterface {
    private ArrayList<Order> orders;

    public BevShop() {
        orders = new ArrayList<Order>();
    }

    @Override
    public void createOrder(Order order) {
        orders.add(order);
    }

    @Override
    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public double getOrderTotal(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                return order.calcOrderTotal();
            }
        }
        return 0.0;
    }

    @Override
    public int getTotalMonthlyOrders() {
        int count = 0;
        for (Order order : orders) {
            if (order.getOrderDate().getMonth() == new Date().getMonth()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public double getMonthlySales() {
        double totalSales = 0.0;
        for (Order order : orders) {
            if (order.getOrderDate().getMonth() == new Date().getMonth()) {
                totalSales += order.calcOrderTotal();
            }
        }
        return totalSales;
    }

    @Override
    public ArrayList<Order> searchOrdersByName(String name) {
        ArrayList<Order> matchingOrders = new ArrayList<Order>();
        for (Order order : orders) {
            if (order.getCustomer().getName().equals(name)) {
                matchingOrders.add(order);
            }
        }
        return matchingOrders;
    }

    @Override
    public void sortOrdersByCost() {
        Collections.sort(orders);
    }

    @Override
    public void sortOrdersByDate() {
        Collections.sort(orders, new OrderDateComparator());
    }

    private class OrderDateComparator implements java.util.Comparator<Order> {
        public int compare(Order order1, Order order2) {
            return order1.getOrderDate().compareTo(order2.getOrderDate());
        }
    }
}
