package HealthClinicApp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class HealthClinicApp {
    private static Scanner scanner = new Scanner(System.in);
    private static PatientDAO patientDAO = new PatientDAO();
    private static DoctorDAO doctorDAO = new DoctorDAO();
    private static AppointmentDAO appointmentDAO = new AppointmentDAO();
    private static BillingDAO billingDAO = new BillingDAO();
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Health Clinic Management System ===");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Billing");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            try {
                switch (choice) {
                    case 1: patientMenu(); break;
                    case 2: doctorMenu(); break;
                    case 3: appointmentMenu(); break;
                    case 4: billingMenu(); break;
                    case 5: System.exit(0);
                    default: System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    private static void patientMenu() throws Exception {
        System.out.println("\n1. Register Patient");
        System.out.println("2. Update Patient");
        System.out.println("3. Search Patient");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("DOB (YYYY-MM-DD): ");
                LocalDate dob = LocalDate.parse(scanner.nextLine());
                System.out.print("Phone: ");
                String phone = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                System.out.print("Blood Group: ");
                String bloodGroup = scanner.nextLine();
                
                Patient patient = new Patient(name, dob, phone, email, address, bloodGroup);
                int id = patientDAO.registerPatient(patient);
                System.out.println("Patient registered with ID: " + id);
                break;
                
            case 2:
                System.out.print("Patient ID: ");
                int patientId = scanner.nextInt();
                scanner.nextLine();
                Patient p = patientDAO.getPatientById(patientId);
                if (p != null) {
                    System.out.print("New Phone: ");
                    p.setPhone(scanner.nextLine());
                    patientDAO.updatePatient(p);
                    System.out.println("Patient updated");
                }
                break;
                
            case 3:
                System.out.print("Search term: ");
                String term = scanner.nextLine();
                List<Patient> patients = patientDAO.searchPatients(term);
                patients.forEach(pt -> System.out.println(pt.getPatientId() + ": " + pt.getName() + " - " + pt.getPhone()));
                break;
        }
    }
    
    private static void doctorMenu() throws Exception {
        System.out.println("\n1. Add Doctor");
        System.out.println("2. View Doctors by Specialty");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Specialty ID: ");
                int specialtyId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Phone: ");
                String phone = scanner.nextLine();
                System.out.print("Consultation Fee: ");
                double fee = scanner.nextDouble();
                
                Doctor doctor = new Doctor(name, specialtyId, phone, fee);
                int id = doctorDAO.addDoctor(doctor);
                System.out.println("Doctor added with ID: " + id);
                break;
                
            case 2:
                System.out.print("Specialty name: ");
                String specialty = scanner.nextLine();
                List<Doctor> doctors = doctorDAO.getDoctorsBySpecialty(specialty);
                doctors.forEach(d -> System.out.println(d.getDoctorId() + ": " + d.getName() + " - Fee: " + d.getConsultationFee()));
                break;
        }
    }
    
    private static void appointmentMenu() throws Exception {
        System.out.println("\n1. Book Appointment");
        System.out.println("2. Cancel Appointment");
        System.out.println("3. View Daily Schedule");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.print("Patient ID: ");
                int patientId = scanner.nextInt();
                System.out.print("Doctor ID: ");
                int doctorId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Appointment Time (YYYY-MM-DDTHH:MM): ");
                LocalDateTime time = LocalDateTime.parse(scanner.nextLine());
                
                Appointment appointment = new Appointment(patientId, doctorId, time);
                int id = appointmentDAO.bookAppointment(appointment);
                System.out.println("Appointment booked with ID: " + id);
                break;
                
            case 2:
                System.out.print("Appointment ID: ");
                int appointmentId = scanner.nextInt();
                appointmentDAO.cancelAppointment(appointmentId);
                System.out.println("Appointment cancelled");
                break;
                
            case 3:
                System.out.print("Date (YYYY-MM-DD): ");
                LocalDate date = LocalDate.parse(scanner.nextLine());
                System.out.print("Doctor ID: ");
                int docId = scanner.nextInt();
                List<Appointment> appointments = appointmentDAO.getDailySchedule(date, docId);
                appointments.forEach(a -> System.out.println(a.getAppointmentId() + ": " + a.getAppointmentTime() + " - " + a.getStatus()));
                break;
        }
    }
    
    private static void billingMenu() throws Exception {
        System.out.println("\n1. Generate Bill");
        System.out.println("2. Record Payment");
        System.out.println("3. View Outstanding Bills");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.print("Visit ID: ");
                int visitId = scanner.nextInt();
                System.out.print("Amount: ");
                double amount = scanner.nextDouble();
                int billId = billingDAO.generateBill(visitId, amount);
                System.out.println("Bill generated with ID: " + billId);
                break;
                
            case 2:
                System.out.print("Bill ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Payment Mode: ");
                String mode = scanner.nextLine();
                billingDAO.recordPayment(id, mode);
                System.out.println("Payment recorded");
                break;
                
            case 3:
                billingDAO.getOutstandingBills().forEach((k, v) -> System.out.println(k + ": " + v));
                break;
        }
    }
}
