public class Person {
    String name;
    String gender;
    int age;

    Person(String name,String gender,int age){
        this.name=name;
        this.gender=gender;
        this.age=age;
    }

    Person(Person other){
        this.name=other.name;
        this.gender=other.gender;
        this.age=other.age;
    }
}
