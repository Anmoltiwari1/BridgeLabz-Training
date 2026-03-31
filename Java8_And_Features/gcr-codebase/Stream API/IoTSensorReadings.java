import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class SensorReading {
    private String sensorId;
    private double value;
    private String unit;
    private LocalDateTime timestamp;
    
    public SensorReading(String sensorId, double value, String unit) {
        this.sensorId = sensorId;
        this.value = value;
        this.unit = unit;
        this.timestamp = LocalDateTime.now();
    }
    
    public String getSensorId() { return sensorId; }
    public double getValue() { return value; }
    public String getUnit() { return unit; }
    public LocalDateTime getTimestamp() { return timestamp; }
    
    @Override
    public String toString() {
        return String.format("[%s] %s: %.2f %s", 
            timestamp.format(DateTimeFormatter.ofPattern("HH:mm:ss")), 
            sensorId, value, unit);
    }
}

public class IoTSensorReadings {
    public static void main(String[] args) {
        List<SensorReading> sensorReadings = Arrays.asList(
            new SensorReading("TEMP_001", 25.5, "°C"),
            new SensorReading("TEMP_002", 32.8, "°C"),
            new SensorReading("HUMIDITY_001", 65.2, "%"),
            new SensorReading("PRESSURE_001", 1013.25, "hPa"),
            new SensorReading("TEMP_003", 28.9, "°C"),
            new SensorReading("HUMIDITY_002", 78.5, "%"),
            new SensorReading("PRESSURE_002", 1008.7, "hPa"),
            new SensorReading("TEMP_004", 35.2, "°C")
        );
        
        double temperatureThreshold = 30.0;
        double humidityThreshold = 70.0;
        double pressureThreshold = 1010.0;
        
        System.out.println("=== All IoT Sensor Readings ===");
        sensorReadings.forEach(System.out::println);
        
        System.out.println("\n=== High Temperature Alerts (>" + temperatureThreshold + "°C) ===");
        sensorReadings.stream()
            .filter(reading -> reading.getSensorId().startsWith("TEMP"))
            .filter(reading -> reading.getValue() > temperatureThreshold)
            .forEach(reading -> 
                System.out.println("🔥 ALERT: " + reading));
        
        System.out.println("\n=== High Humidity Alerts (>" + humidityThreshold + "%) ===");
        sensorReadings.stream()
            .filter(reading -> reading.getSensorId().startsWith("HUMIDITY"))
            .filter(reading -> reading.getValue() > humidityThreshold)
            .forEach(reading -> 
                System.out.println("💧 ALERT: " + reading));
        
        System.out.println("\n=== Low Pressure Alerts (<" + pressureThreshold + " hPa) ===");
        sensorReadings.stream()
            .filter(reading -> reading.getSensorId().startsWith("PRESSURE"))
            .filter(reading -> reading.getValue() < pressureThreshold)
            .forEach(reading -> 
                System.out.println("⬇️ ALERT: " + reading));
        
        System.out.println("\n=== Sensor Status Summary ===");
        sensorReadings.stream()
            .collect(java.util.stream.Collectors.groupingBy(
                reading -> reading.getSensorId().split("_")[0]))
            .forEach((sensorType, readings) -> {
                System.out.println(sensorType + " sensors: " + readings.size() + " readings");
                readings.forEach(reading -> System.out.println("  " + reading));
            });
    }
}