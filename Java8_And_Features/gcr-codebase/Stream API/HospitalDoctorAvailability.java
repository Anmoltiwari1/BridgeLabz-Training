import java.util.*;

class Doctor {
    private String name;
    private String specialty;
    private boolean availableWeekends;
    
    public Doctor(String name, String specialty, boolean availableWeekends) {
        this.name = name;
        this.specialty = specialty;
        this.availableWeekends = availableWeekends;
    }
    
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
    public boolean isAvailableWeekends() { return availableWeekends; }
    
    @Override
    public String toString() {
        return "Dr. " + name + " - " + specialty;
    }
}

public class HospitalDoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Smith", "Cardiology", true),
            new Doctor("Johnson", "Emergency", true),
            new Doctor("Williams", "Neurology", false),
            new Doctor("Brown", "Emergency", true),
            new Doctor("Davis", "Orthopedics", true),
            new Doctor("Miller", "Cardiology", false),
            new Doctor("Wilson", "Pediatrics", true),
            new Doctor("Moore", "Dermatology", false),
            new Doctor("Taylor", "Emergency", true),
            new Doctor("Anderson", "Psychiatry", true)
        );
        
        System.out.println("Doctors available on weekends (sorted by specialty):");
        
        doctors.stream()
            .filter(Doctor::isAvailableWeekends)
            .sorted(Comparator.comparing(Doctor::getSpecialty)
                .thenComparing(Doctor::getName))
            .forEach(System.out::println);
        
        System.out.println("\nWeekend availability by specialty:");
        doctors.stream()
            .filter(Doctor::isAvailableWeekends)
            .collect(java.util.stream.Collectors.groupingBy(Doctor::getSpecialty))
            .forEach((specialty, doctorList) -> {
                System.out.println(specialty + ": " + doctorList.size() + " doctors");
                doctorList.forEach(doctor -> System.out.println("  " + doctor));
            });
    }
}