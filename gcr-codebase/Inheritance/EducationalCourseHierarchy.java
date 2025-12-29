class Course{
	String courseName;
	int duration;
	
	Course(String courseName, int duration){
		this.courseName = courseName;
		this.duration = duration;
	}
	
	void Display() {
		System.out.print("Course Name: " + courseName + " | Duration (in hours): " + duration);
	}
}

class OnlineCourse extends Course{
	String platform;
	boolean isRecorded;
	
	OnlineCourse(String courseName, int duration, String platform, boolean isRecorded){
		super(courseName, duration);
		this.platform = platform;
		this.isRecorded = isRecorded;
	}
	
	void Display() {
		super.Display();
		System.out.print(" | Platform: " + platform + " | Recorded: " + isRecorded);
	}
}

class PaidOnlineCourse extends OnlineCourse{
	int fee;
	int discount;
	
	PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, int fee, int discount){
		super(courseName, duration, platform, isRecorded);
		this.fee = fee;
		this.discount = discount;
	}
	
	void Display() {
		super.Display();
		System.out.print(" | Fees: " + fee + " | Discount(%): " + discount);
	}
}

public class EducationalCourseHierarchy {
	public static void main(String[] args) {
		OnlineCourse oc1 = new OnlineCourse("Java Programming Masterclass", 40, "Udemy", true);
		PaidOnlineCourse poc2 = new PaidOnlineCourse("Full Stack Web Development", 60, "Coursera", false, 300, 75);
		System.out.println("Online Course");
		oc1.Display();
		System.out.println();
		System.out.println("Paid Online Course");
		poc2.Display();
	}
}
