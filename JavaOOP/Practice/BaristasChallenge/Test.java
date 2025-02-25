public class Test {
    public static void main(String[] args) {

        //Menu Items
        Item item1 = new Item("drip coffee", 1.60);
        Item item2 = new Item("capuccino", 2.45);
        Item item3 = new Item("iced coffee", 2.15);
        Item item4 = new Item("mocha", 3.10);
        
        //Create 2 orders for unspecified guests. Do not specify a name.
        Order order1 = new Order();
        Order order2 = new Order();


        //Create 3 orders using the overloaded constructor to give each a name for the order.
        Order order3 = new Order("Ali");
        Order order4 = new Order("Molka");
        Order order5 = new Order("Yaya");

        //Add at least 2 items to each of the orders using the addItem method.
        order1.addItem(item1);
        order1.addItem(item3);

        order2.addItem(item2);
        order2.addItem(item4);

        order3.addItem(item3);
        order3.addItem(item2);

        order4.addItem(item4);
        order4.addItem(item1);

        order5.addItem(item1);
        order5.addItem(item4);

        //Test your getStatusMessage method by setting some orders to ready and printing the messages for each order.
        System.out.println(order1.getStatusMessage());
        order1.setReady(true);
        System.out.println(order1.getStatusMessage());

        System.out.println(order3.getStatusMessage());
        order3.setReady(true);
        System.out.println(order3.getStatusMessage());


        //Test the total by printing the return value
        System.out.println(order1.getOrderTotal());
        System.out.println(order2.getOrderTotal());
        System.out.println(order3.getOrderTotal());
        System.out.println(order4.getOrderTotal());
        System.out.println(order5.getOrderTotal());

        //Finally, call the display method on all of your orders.
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();


   }
}
