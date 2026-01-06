class Animal{
    void eat(){
        System.out.println("eating");;
    }

    void walk(){
        System.out.println("Walking");
    }

    void legs(){
        System.out.println("Have 4 legs");
    }
}

class Dog extends Animal{
    void bark(){
        System.out.println("Dog barks");
    }


     void type(){
        System.out.println("Carnivores");
    }
}

class Lion extends Animal{
    void roar(){
        System.out.println("Lion roars");
    }

    void type(){
        System.out.println("Carnivores");
    }
}

class Elephant extends Animal{
    void type(){
        System.out.println("Herbivores");
    }
}



public class Main {
    public static void main(String[] args) {
        Animal dog=new Dog();
        dog.eat();
        Dog dog2=new Dog();
        dog2.bark();
        Animal lion=new Lion();
        lion.walk();
        Elephant elephant=new Elephant();
        elephant.legs();
    }
}
