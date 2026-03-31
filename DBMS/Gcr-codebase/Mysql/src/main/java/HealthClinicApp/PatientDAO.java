package HealthClinicApp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    
    public int registerPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO patients (name, dob, phone, email, address, blood_group) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, patient.getName());
            stmt.setDate(2, Date.valueOf(patient.getDob()));
            stmt.setString(3, patient.getPhone());
            stmt.setString(4, patient.getEmail());
            stmt.setString(5, patient.getAddress());
            stmt.setString(6, patient.getBloodGroup());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }
    
    public void updatePatient(Patient patient) throws SQLException {
        String sql = "UPDATE patients SET name=?, dob=?, phone=?, email=?, address=?, blood_group=? WHERE patient_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, patient.getName());
            stmt.setDate(2, Date.valueOf(patient.getDob()));
            stmt.setString(3, patient.getPhone());
            stmt.setString(4, patient.getEmail());
            stmt.setString(5, patient.getAddress());
            stmt.setString(6, patient.getBloodGroup());
            stmt.setInt(7, patient.getPatientId());
            stmt.executeUpdate();
        }
    }
    
    public List<Patient> searchPatients(String searchTerm) throws SQLException {
        String sql = "SELECT * FROM patients WHERE name LIKE ? OR phone = ? OR patient_id = ?";
        List<Patient> patients = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + searchTerm + "%");
            stmt.setString(2, searchTerm);
            try {
                stmt.setInt(3, Integer.parseInt(searchTerm));
            } catch (NumberFormatException e) {
                stmt.setInt(3, -1);
            }
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setDob(rs.getDate("dob").toLocalDate());
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
                p.setAddress(rs.getString("address"));
                p.setBloodGroup(rs.getString("blood_group"));
                patients.add(p);
            }
        }
        return patients;
    }
    
    public Patient getPatientById(int patientId) throws SQLException {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, patientId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setDob(rs.getDate("dob").toLocalDate());
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
                p.setAddress(rs.getString("address"));
                p.setBloodGroup(rs.getString("blood_group"));
                return p;
            }
        }
        return null;
    }
}
