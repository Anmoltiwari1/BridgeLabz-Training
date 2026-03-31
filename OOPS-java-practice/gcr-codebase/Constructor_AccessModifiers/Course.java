public class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName;

    Course(String courseName,int duration,double fee){
        this.courseName=courseName;
        this.duration=duration;
        this.fee=fee;
    }

    public void displayCourseDetails(){
        System.out.println("Institute name :" + instituteName);
        System.out.println("CourseName is :"+courseName);
        System.out.println("Duration of the course will be:"+duration);
        System.out.println("fee will be :"+fee);
    }

    public void updateInstituteName(String newInstitueName){
        instituteName=newInstitueName;
    }

}
