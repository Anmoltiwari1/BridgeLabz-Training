//package Classes_And_Objects;
public class Circle {
    double radius;

    Circle(double radius){
        this.radius=radius;
    }

    public void areaCircle(){
        System.out.println("Area of Circle is "+(3.14*radius*radius));
    }

    public void circumferenceCircle() {
        System.out.println("Circumference of Circle is "+ 2*3.14*radius);
    }

    public static void main(String[] args) {
        Circle circle=new Circle(2.5);
        circle.areaCircle();
        circle.circumferenceCircle();
    }
}
