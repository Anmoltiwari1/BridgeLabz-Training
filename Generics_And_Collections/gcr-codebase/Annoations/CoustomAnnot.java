import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) 
@interface TaskInfo{
    String priority();
    String assignedTo();
}

class TaskManager{

     @TaskInfo(priority = "HIGH", assignedTo = "Anmol")
    void completeTask(){
        System.out.println("Task Completed");
    }
}

public class CoustomAnnot {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Class<?> c = tm.getClass();
        try {
            Method method=c.getMethod("completeTask");
            if(method.isAnnotationPresent(TaskInfo.class)){
    TaskInfo info = method.getAnnotation(TaskInfo.class);
    System.out.println("Priority: " + info.priority());
    System.out.println("Assigned to: " + info.assignedTo());
            }
        } catch (Exception e) {
            System.out.println("Exception is :"+e.getMessage());
        }
        
    }
}
