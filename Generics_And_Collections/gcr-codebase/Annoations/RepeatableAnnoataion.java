import java.lang.annotation.*;
import java.lang.reflect.Method;

/*
 * STEP 1: Container Annotation
 * This holds multiple BugReport annotations
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

/*
 * STEP 2: Repeatable Annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

/*
 * STEP 3: Apply the repeatable annotation multiple times
 */
class IssueTracker {

    @BugReport(description = "NullPointerException when input is null")
    @BugReport(description = "Performance issue for large data sets")
    void fixIssue() {
        System.out.println("Fixing issues...");
    }
}

/*
 * STEP 4: Retrieve and print all BugReport annotations
 */
public class RepeatableAnnotationExample {

    public static void main(String[] args) {
        try {
            Method method = IssueTracker.class.getMethod("fixIssue");

            BugReport[] reports = method.getAnnotationsByType(BugReport.class);

            for (BugReport report : reports) {
                System.out.println("Bug: " + report.description());
            }

        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }
}
