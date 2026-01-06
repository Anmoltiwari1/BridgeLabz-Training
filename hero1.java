interface Hero {
    void attack();
    void defence();
    void run();
    void heal();
    void speak();
}

class GameHero implements Hero {
    public void attack() {
        System.out.println("Hero can Attack");
    }
    
    public void defence() {
        System.out.println("Hero can defence");
    }
    
    public void run() {
        System.out.println("Hero can run");
    }
    
    public void heal() {
        System.out.println("Hero can heal");
    }
    
    public void speak() {
        System.out.println("Hero can speak");
    }
}

public class hero1 {
    public static void main(String[] args) {
        GameHero hero = new GameHero();
        
        hero.attack();
        hero.defence();
        hero.run();
        hero.heal();
        hero.speak();
    }
}