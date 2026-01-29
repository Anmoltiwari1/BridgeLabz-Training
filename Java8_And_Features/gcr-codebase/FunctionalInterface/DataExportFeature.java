interface DataExporter {
    void exportToCSV(String data);
    void exportToPDF(String data);
    
    default void exportToJSON(String data) {
        System.out.println("Exporting to JSON: {\"data\": \"" + data + "\"}");
    }
}

class ReportExporter implements DataExporter {
    public void exportToCSV(String data) {
        System.out.println("CSV Export: " + data);
    }
    
    public void exportToPDF(String data) {
        System.out.println("PDF Export: " + data);
    }
}

class AdvancedExporter implements DataExporter {
    public void exportToCSV(String data) {
        System.out.println("Advanced CSV Export: " + data);
    }
    
    public void exportToPDF(String data) {
        System.out.println("Advanced PDF Export: " + data);
    }
    
    @Override
    public void exportToJSON(String data) {
        System.out.println("Custom JSON Export: {\"advanced\": \"" + data + "\"}");
    }
}

public class DataExportFeature {
    public static void main(String[] args) {
        DataExporter basic = new ReportExporter();
        DataExporter advanced = new AdvancedExporter();
        
        String sampleData = "Sales Report Data";
        
        basic.exportToCSV(sampleData);
        basic.exportToPDF(sampleData);
        basic.exportToJSON(sampleData);
        
        System.out.println("---");
        
        advanced.exportToCSV(sampleData);
        advanced.exportToPDF(sampleData);
        advanced.exportToJSON(sampleData);
    }
}