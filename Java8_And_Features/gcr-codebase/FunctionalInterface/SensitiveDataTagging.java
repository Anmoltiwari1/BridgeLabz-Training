interface SensitiveData {
}

class PersonalInfo implements SensitiveData {
    private String ssn;
    private String creditCard;
    private String address;
    
    public PersonalInfo(String ssn, String creditCard, String address) {
        this.ssn = ssn;
        this.creditCard = creditCard;
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "PersonalInfo{ssn='" + ssn + "', creditCard='" + creditCard + "', address='" + address + "'}";
    }
}

class MedicalRecord implements SensitiveData {
    private String patientId;
    private String diagnosis;
    private String treatment;
    
    public MedicalRecord(String patientId, String diagnosis, String treatment) {
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }
    
    @Override
    public String toString() {
        return "MedicalRecord{patientId='" + patientId + "', diagnosis='" + diagnosis + "', treatment='" + treatment + "'}";
    }
}

class PublicInfo {
    private String name;
    private String email;
    
    public PublicInfo(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "PublicInfo{name='" + name + "', email='" + email + "'}";
    }
}

class EncryptionService {
    public static String encrypt(String data) {
        return "ENCRYPTED[" + data + "]";
    }
    
    public static void processData(Object data) {
        if (data instanceof SensitiveData) {
            System.out.println("🔒 Encrypting sensitive data: " + encrypt(data.toString()));
        } else {
            System.out.println("📄 Processing public data: " + data.toString());
        }
    }
}

public class SensitiveDataTagging {
    public static void main(String[] args) {
        PersonalInfo personal = new PersonalInfo("123-45-6789", "4532-1234-5678-9012", "123 Main St");
        MedicalRecord medical = new MedicalRecord("P001", "Hypertension", "Medication XYZ");
        PublicInfo publicInfo = new PublicInfo("John Doe", "john@example.com");
        
        EncryptionService.processData(personal);
        EncryptionService.processData(medical);
        EncryptionService.processData(publicInfo);
    }
}