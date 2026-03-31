import java.util.*;

class Patient {
    String name;
    int severity;
    
    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> triage = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.severity, p1.severity));
        
        triage.add(new Patient("John", 3));
        triage.add(new Patient("Alice", 5));
        triage.add(new Patient("Bob", 2));
        triage.add(new Patient("Carol", 4));
        
        System.out.println("Treatment Order:");
        while (!triage.isEmpty()) {
            System.out.println(triage.poll());
        }
    }
}