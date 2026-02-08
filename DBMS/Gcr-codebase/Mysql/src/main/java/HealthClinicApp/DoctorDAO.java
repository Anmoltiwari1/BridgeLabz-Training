package HealthClinicApp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    
    public int addDoctor(Doctor doctor) throws SQLException {
        String sql = "INSERT INTO doctors (name, specialty_id, phone, consultation_fee, is_active) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, doctor.getName());
            stmt.setInt(2, doctor.getSpecialtyId());
            stmt.setString(3, doctor.getPhone());
            stmt.setDouble(4, doctor.getConsultationFee());
            stmt.setBoolean(5, doctor.isActive());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }
    
    public void updateDoctorSpecialty(int doctorId, int specialtyId) throws SQLException {
        String sql = "UPDATE doctors SET specialty_id = ? WHERE doctor_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, specialtyId);
            stmt.setInt(2, doctorId);
            stmt.executeUpdate();
        }
    }
    
    public List<Doctor> getDoctorsBySpecialty(String specialtyName) throws SQLException {
        String sql = "SELECT d.* FROM doctors d JOIN specialties s ON d.specialty_id = s.specialty_id WHERE s.name = ? AND d.is_active = true";
        List<Doctor> doctors = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, specialtyName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Doctor d = new Doctor();
                d.setDoctorId(rs.getInt("doctor_id"));
                d.setName(rs.getString("name"));
                d.setSpecialtyId(rs.getInt("specialty_id"));
                d.setPhone(rs.getString("phone"));
                d.setConsultationFee(rs.getDouble("consultation_fee"));
                d.setActive(rs.getBoolean("is_active"));
                doctors.add(d);
            }
        }
        return doctors;
    }
    
    public void deactivateDoctor(int doctorId) throws SQLException {
        String checkSql = "SELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND appointment_time > NOW() AND status = 'SCHEDULED'";
        String updateSql = "UPDATE doctors SET is_active = false WHERE doctor_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setInt(1, doctorId);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    throw new SQLException("Cannot deactivate doctor with future appointments");
                }
            }
            
            try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                updateStmt.setInt(1, doctorId);
                updateStmt.executeUpdate();
            }
        }
    }
}
