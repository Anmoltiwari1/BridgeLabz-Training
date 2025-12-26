package Ecapsulation_Plymorphism;
import java.util.*;

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPatientDetails() {
        return "Patient ID: " + patientId + " | Name: " + name + " | Age: " + age;
    }

    public abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> medicalRecords;

    InPatient(int patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : medicalRecords) {
            System.out.println(record);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalRecords;

    OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String record : medicalRecords) {
            System.out.println(record);
        }
    }
}

interface MedicalRecord {
    void addRecord(String record);

    void viewRecords();
}

class PatientManager {
    public static void processPatientBill(Patient patient) {
        System.out.println(patient.getPatientDetails());
        System.out.println("Bill Amount: " + patient.calculateBill());
        if (patient instanceof MedicalRecord) {
            MedicalRecord record = (MedicalRecord) patient;
            record.viewRecords();
        }
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient(1, "John Doe", 45, 5, 1000);
        inPatient.addRecord("Admitted with fever and fatigue.");
        inPatient.addRecord("Undergoing tests for viral infection.");

        OutPatient outPatient = new OutPatient(2, "Jane Smith", 30, 200);
        outPatient.addRecord("Consulted for routine check-up.");

        System.out.println("Processing In-Patient:");
        PatientManager.processPatientBill(inPatient);

        System.out.println("\nProcessing Out-Patient:");
        PatientManager.processPatientBill(outPatient);
    }
}
