package JavaOOP.Practice.OrderAndItems;

public class TestOrder {
    public static void main(String[] args) {
        
        //Items : 
        Item item1 = new Item();
        item1.setName("mocha");
        item1.setPrice(2.5);

        Item item2 = new Item();
        item2.setName("latte");
        item2.setPrice(5.5);

        Item item3 = new Item();
        item3.setName("drip coffee");
        item3.setPrice(1.5);

        Item item4 = new Item();
        item4.setName("cappuccino");
        item4.setPrice(9.5);


        //Orders : 
        Order order1 = new Order();
        order1.setName("Cindhuri");

        Order order2 = new Order();
        order2.setName("Jimmy");

        Order order3 = new Order();
        order3.setName("Noah");

        Order order4 = new Order();
        order4.setName("Sam");

        System.out.println(order1.getTotal()); // => output : 0.0
        
        // Add the item1 to order2's item list and increment the order's total.
        order2.getItems().add(item1);
        order2.setTotal(order2.getTotal() + item1.getPrice());

        //Noah ordered a cappuccino. Add the cappuccino to their order list and to their tab.
        order3.getItems().add(item4);
        order3.setTotal(order3.getTotal() + item4.getPrice());
        

        //Sam added a latte. Update the order accordingly.
        order4.getItems().add(item2);
        order4.setTotal(order4.getTotal() + item2.getPrice());


        //Cindhuri’s order is now ready. Update her status.
        order1.setReady(true);

        //Sam ordered more drinks - 2 lattes. Update their order as well.
        order4.getItems().add(item2);
        order4.getItems().add(item2);
        order4.setTotal(order4.getTotal() + item3.getPrice() * 2);

        //Jimmy’s order is now ready. Update his status.
        order2.setReady(true);


        // Application Simulations
        System.out.printf("Name: %s\n", order1.getName());
        System.out.printf("Total: %s\n", order1.getTotal());
        System.out.printf("Ready: %s\n", order1.getReady());

        System.out.printf("Name: %s\n", order2.getName());
        System.out.printf("Total: %s\n", order2.getTotal());
        System.out.printf("Ready: %s\n", order2.getReady());

        System.out.printf("Name: %s\n", order3.getName());
        System.out.printf("Total: %s\n", order3.getTotal());
        System.out.printf("Ready: %s\n", order3.getReady());

        System.out.printf("Name: %s\n", order4.getName());
        System.out.printf("Total: %s\n", order4.getTotal());
        System.out.printf("Ready: %s\n", order4.getReady());
    }
}
