package University_Management_System;
public class PostgraduateStudent extends Student {
    
    PostgraduateStudent(int rollNumber,String name,double CGPA){
        super(rollNumber, name, CGPA);
    }

    public void showName() {
        System.out.println("Student name: " + name); // name is protected
    }
}
