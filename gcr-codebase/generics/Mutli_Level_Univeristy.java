abstract class CourseType{
    
    abstract String getEvaluationMethod();
}

class ExamCourse extends CourseType {
    @Override
    String getEvaluationMethod() {
        return "Exam Based";
    }
}

class AssignmentCourse extends CourseType {
    @Override
    String getEvaluationMethod() {
        return "Assignment Based";
    }
}

class ResearchCourse extends CourseType {
    @Override
    String getEvaluationMethod() {
        return "Research Based";
    }
}



public class Mutli_Level_Univeristy {
    class Course<T extends CourseType> {

    private String courseId;
    private String courseName;
    private String duration;
    private T courseType;

    Course(String courseId, String courseName, String duration, T courseType) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    public String getDetails() {
        return courseName + " (" + courseType.getEvaluationMethod() + ")";
    }
}
}
