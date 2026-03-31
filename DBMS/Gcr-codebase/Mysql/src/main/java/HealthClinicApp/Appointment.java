package HealthClinicApp;

import java.time.LocalDateTime;

public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private LocalDateTime appointmentTime;
    private String status;
    
    public Appointment() {}
    
    public Appointment(int patientId, int doctorId, LocalDateTime appointmentTime) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentTime = appointmentTime;
        this.status = "SCHEDULED";
    }
    
    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }
    public LocalDateTime getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(LocalDateTime appointmentTime) { this.appointmentTime = appointmentTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
