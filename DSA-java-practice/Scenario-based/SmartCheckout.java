import java.util.*;

class Item{
    final int itemId;
    String name;
    double price;
    int stock;

    Item(int itemId,String name,double price,int stock)
    {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

class Customer{
    String name;
    final int CustomerId;
    HashMap<Integer,Integer> cart=new HashMap<>();
    
    Customer(String name,int CustomerId,HashMap<Integer,Integer> cart)
    {
        this.name=name;
        this.CustomerId=CustomerId;
        this.cart=cart;
    }
}


public class SmartCheckout{
    public static void main(String[] args) {
        
        HashMap<Integer,Item> inventory=new HashMap<>();
        inventory.put(101, new Item(101, "Milk", 50, 10));
    inventory.put(102, new Item(102, "Bread", 30, 5));


        Queue<Customer> queue=new LinkedList<>();

        addCoustomerQueue(queue);

        while(!queue.isEmpty()){
            Customer current=queue.poll();
            processCustomer(current, inventory);
        }
    }

    public static void addCoustomerQueue(Queue<Customer> queue){

    HashMap<Integer,Integer> cart=new HashMap<>();
    cart.put(101,2);
    cart.put(102,1);
        Customer c1=new Customer("Amit", 1,cart);
        queue.add(c1);
    }

    public static void processCustomer(Customer c, HashMap<Integer,Item> inventory){

        double total=0;

        for(Map.Entry<Integer,Integer> entry:c.cart.entrySet()){
            int itemId=entry.getKey();
            int qty=entry.getValue();

            Item item=inventory.get(itemId);

            if(item==null){
                System.out.println("Item"+itemId+"not found");
                continue;
            }

            if(item.stock<qty){
                System.out.println("Not enough stock for item"+item.name);
                continue;
            }

            item.stock-=qty;
            total+=item.price*qty;
        }
        System.out.println("Total bill for " + c.name + ": " + total);
    }
}