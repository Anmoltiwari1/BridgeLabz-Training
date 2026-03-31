class Chef extends Thread {
    private String dish;
    private int cookingTime;
    
    public Chef(String name, String dish, int cookingTimeSeconds) {
        super(name);
        this.dish = dish;
        this.cookingTime = cookingTimeSeconds * 1000;
    }
    
    @Override
    public void run() {
        System.out.println(getName() + " started preparing " + dish);
        
        int[] progressPoints = {25, 50, 75, 100};
        
        for (int progress : progressPoints) {
            try {
                Thread.sleep(cookingTime / 4);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println(getName() + " preparing " + dish + ": " + progress + "% complete");
        }
    }
}

public class RestaurantOrderSystem {
    public static void main(String[] args) {
        Chef chef1 = new Chef("Chef-1", "Pizza", 3);
        Chef chef2 = new Chef("Chef-2", "Pasta", 2);
        Chef chef3 = new Chef("Chef-3", "Salad", 1);
        Chef chef4 = new Chef("Chef-4", "Burger", 2);
        
        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();
        
        try {
            chef1.join();
            chef2.join();
            chef3.join();
            chef4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Kitchen closed - All orders completed");
    }
}