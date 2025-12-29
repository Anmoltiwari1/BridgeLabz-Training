# Java Object-Oriented Programming Guide

A comprehensive guide to Object-Oriented Programming concepts in Java, featuring practical examples including Vehicle Rental System, Banking Application, and School Management System.

## 📋 Table of Contents

- [Classes vs Objects](#classes-vs-objects)
- [Banking System Example](#banking-system-example)
- [School Management System](#school-management-system)
- [Vehicle Rental Application](#vehicle-rental-application)
- [UML Diagrams](#uml-diagrams)
- [OOP Concepts](#oop-concepts)
- [Installation](#installation)
- [Contributing](#contributing)

## 🎯 Classes vs Objects

### Definition

**Class**: A class is a blueprint or template that defines the structure and behavior of objects. It specifies the properties (attributes) and methods (functions) that the objects created from it will have.

**Object**: An object is an instance of a class. It represents a specific entity with actual values for the properties defined in the class.

### Purpose

**Class**: Classes are used to define the structure and behavior of objects. They encapsulate data and methods into a single unit, promoting reusability and organization.

**Object**: Objects are used to represent real-world entities. Each object contains state (attributes) and behavior (methods) defined by its class.

### Memory Allocation

**Class**: When a class is defined, memory is not allocated until an object of that class is created. The class itself is stored in the method area of the Java Virtual Machine (JVM).

**Object**: When an object is created, memory is allocated for it in the heap. Each object has its own memory space for storing instance variables.

### Summary of Differences

| Feature | Class | Object |
|---------|-------|--------|
| Definition | Blueprint for creating objects | Instance of a class |
| Purpose | Defines structure and behavior | Represents a specific entity |
| Memory Allocation | No memory allocated until an object is created | Memory allocated in the heap for each object |
| Syntax | Defined using the `class` keyword | Created using the `new` keyword |
| Encapsulation | Contains attributes and methods | Holds actual values for the attributes |
| Reusability | Promotes code reusability | Represents unique instances |

## 🏦 Banking System Example

### BankAccount Class

**Attributes:**
- `accountNumber`: A unique identifier for the account
- `accountHolder`: The name of the account holder
- `balance`: The current balance in the account

**Methods:**
- `deposit(double amount)`: Adds a specified amount to the account balance
- `withdraw(double amount)`: Deducts a specified amount from the account balance
- `getBalance()`: Returns the current balance

```java
public class BankAccount {
    // Attributes
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    // Method to get current balance
    public double getBalance() {
        return balance;
    }

    // Method to display account details
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: " + balance);
    }
}
```

### Creating Objects

```java
public class Main {
    public static void main(String[] args) {
        // Creating objects of BankAccount
        BankAccount johnsAccount = new BankAccount("123456789", "John Doe", 1000.00);
        BankAccount janesAccount = new BankAccount("987654321", "Jane Smith", 1500.00);

        // Using the objects
        johnsAccount.deposit(500);            // John deposits $500
        johnsAccount.withdraw(200);           // John withdraws $200
        System.out.println("John's balance: " + johnsAccount.getBalance()); // Check John's balance

        janesAccount.withdraw(2000);          // Attempt to withdraw more than the balance
        janesAccount.deposit(300);             // Jane deposits $300
        janesAccount.displayAccountInfo();     // Display Jane's account details
    }
}
```

### Explanation

**Class Definition**: The BankAccount class contains attributes and methods that define the structure and behavior of a bank account.

**Creating Objects**: In the Main class, we create two objects: `johnsAccount` and `janesAccount`. Each object represents a specific bank account with its unique data.

**Using the Objects**: Methods are called on these objects to manipulate their states.

## 🏫 School Management System

In this system, we have several classes: Student, Teacher, Course, and School. Let's explore their relationships and communication.

### Student Class

```java
public class Student {
    private String name;
    private String studentId;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }
}
```

### Teacher Class

```java
public class Teacher {
    private String name;
    private String teacherId;

    public Teacher(String name, String teacherId) {
        this.name = name;
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public String getTeacherId() {
        return teacherId;
    }
}
```

### Course Class

```java
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private Teacher instructor;
    private List<Student> enrolledStudents;

    public Course(String courseName, Teacher instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        System.out.println(student.getName() + " has been enrolled in " + courseName);
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }

    public Teacher getInstructor() {
        return instructor;
    }
}
```

### School Class

```java
import java.util.ArrayList;
import java.util.List;

public class School {
    private String schoolName;
    private List<Course> courses;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course " + course.courseName + " has been added to " + schoolName);
    }

    public void showCourses() {
        System.out.println("Courses offered by " + schoolName + ":");
        for (Course course : courses) {
            System.out.println("- " + course.courseName + " (Instructor: " + course.getInstructor().getName() + ")");
        }
    }
}
```

### Example Usage

```java
public class Main {
    public static void main(String[] args) {
        // Create a school
        School school = new School("Sunnyvale High School");

        // Create teachers
        Teacher teacher1 = new Teacher("Mr. Smith", "T001");
        Teacher teacher2 = new Teacher("Ms. Johnson", "T002");

        // Create courses
        Course mathCourse = new Course("Mathematics", teacher1);
        Course scienceCourse = new Course("Science", teacher2);

        // Add courses to the school
        school.addCourse(mathCourse);
        school.addCourse(scienceCourse);

        // Create students
        Student student1 = new Student("Alice", "S001");
        Student student2 = new Student("Bob", "S002");

        // Enroll students in courses
        mathCourse.enrollStudent(student1);
        mathCourse.enrollStudent(student2);
        scienceCourse.enrollStudent(student1);

        // Show enrolled students for each course
        mathCourse.showEnrolledStudents();
        scienceCourse.showEnrolledStudents();

        // Show all courses offered by the school
        school.showCourses();
    }
}
```

### Object Relationships

**Association**: A Course is associated with a Teacher (one-to-one relationship). A Course can have multiple Student objects enrolled (one-to-many relationship).

**Aggregation**: The School aggregates Course objects. The school can exist independently of the courses it offers.

**Communication**: Objects communicate through method calls, such as enrolling students in courses or showing enrolled students.

## 🚗 Vehicle Rental Application

A Java-based vehicle rental system demonstrating core Object-Oriented Programming (OOP) concepts.

### Features

- **Multi-vehicle Support**: Rent bikes, cars, and trucks
- **Dynamic Rent Calculation**: Different rates for different vehicle types
- **Customer Management**: Track customer information and rentals
- **Object-Oriented Design**: Clean, maintainable code structure

### Vehicle Class

```java
public class Vehicle {
    protected String manufacturedDate;
    protected String model;
    protected int year;
    protected double baseRate;
    
    public Vehicle(String manufacturedDate, String model, int year, double baseRate) {
        this.manufacturedDate = manufacturedDate;
        this.model = model;
        this.year = year;
        this.baseRate = baseRate;
    }
    
    public double calculateRent(int days) {
        return baseRate * days;
    }
    
    public String toString() {
        return "Mfd: " + manufacturedDate + ", Model: " + model + ", Year: " + year;
    }
}
```

### Rentable Interface

```java
public interface Rentable {
    double calculateRent(int days);
}
```

## 📈 UML Diagrams

### 1. Class Diagram

A Class Diagram is a static diagram in UML that describes the structure of a system by showing its classes, their attributes, methods, and relationships.

**Key Components:**
- **Class**: Represented by a rectangle divided into three sections (name, attributes, methods)
- **Attributes**: Variables that define the state of the object
- **Methods**: Functions that define the behavior of the class
- **Relationships**: Association, Aggregation, Composition, Inheritance, Interface realization

#### Vehicle System Class Diagram
 ![Class_Diagram](https://github.com/hritiksingh66/BridgeLabz-SIPP-Training/blob/OOPs/Java_Object_Oriented_Design/Sequence_Diagram.png)

### 2. Sequence Diagram

A Sequence Diagram shows how objects interact in a particular scenario, highlighting the order of method calls between objects.

**Key Components:**
- **Objects**: Represented by boxes at the top
- **Lifelines**: Vertical dashed lines representing object existence over time
- **Messages**: Horizontal arrows showing interactions
- **Activation bars**: Rectangular boxes showing when an object is active
- **Return messages**: Dashed arrows showing return of control

#### Online Shopping Sequence Diagram Example

![Sequence_Diagram](https://github.com/hritiksingh66/BridgeLabz-SIPP-Training/blob/OOPs/Java_Object_Oriented_Design/Sequence_Diagram.png)

## 🎯 OOP Concepts

### 1. Abstraction
- `Rentable` interface abstracts rental behavior
- Hides complex rent calculation logic behind simple methods

### 2. Inheritance
- `Car`, `Bike`, and `Truck` classes inherit from `Vehicle` base class
- Shared attributes and methods are inherited from parent class

### 3. Polymorphism
- Rent calculation differs by vehicle type
- Same method signature with different implementations

### 4. Encapsulation
- All fields are hidden behind getters and setters
- Protected access modifiers for controlled subclass access

## 🚀 Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/java-oop-guide.git
   cd java-oop-guide
   ```

2. **Compile the Java files**
   ```bash
   javac *.java
   ```

3. **Run the applications**
   ```bash
   java Vehicle
   java BankAccount
   java School
   ```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

⭐ **Star this repository if you found it helpful!**
