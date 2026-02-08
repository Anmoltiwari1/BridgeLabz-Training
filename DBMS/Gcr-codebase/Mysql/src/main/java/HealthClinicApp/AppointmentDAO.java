package HealthClinicApp;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    
    public int bookAppointment(Appointment appointment) throws SQLException {
        String checkSql = "SELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND appointment_time = ? AND status = 'SCHEDULED'";
        String insertSql = "INSERT INTO appointments (patient_id, doctor_id, appointment_time, status) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                    checkStmt.setInt(1, appointment.getDoctorId());
                    checkStmt.setTimestamp(2, Timestamp.valueOf(appointment.getAppointmentTime()));
                    ResultSet rs = checkStmt.executeQuery();
                    if (rs.next() && rs.getInt(1) > 0) {
                        throw new SQLException("Time slot not available");
                    }
                }
                
                try (PreparedStatement insertStmt = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
                    insertStmt.setInt(1, appointment.getPatientId());
                    insertStmt.setInt(2, appointment.getDoctorId());
                    insertStmt.setTimestamp(3, Timestamp.valueOf(appointment.getAppointmentTime()));
                    insertStmt.setString(4, appointment.getStatus());
                    insertStmt.executeUpdate();
                    
                    ResultSet rs = insertStmt.getGeneratedKeys();
                    if (rs.next()) {
                        conn.commit();
                        return rs.getInt(1);
                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
        return -1;
    }
    
    public void cancelAppointment(int appointmentId) throws SQLException {
        String sql = "UPDATE appointments SET status = 'CANCELLED' WHERE appointment_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, appointmentId);
            stmt.executeUpdate();
        }
    }
    
    public void rescheduleAppointment(int appointmentId, LocalDateTime newTime, int newDoctorId) throws SQLException {
        String checkSql = "SELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND appointment_time = ? AND status = 'SCHEDULED'";
        String updateSql = "UPDATE appointments SET appointment_time = ?, doctor_id = ? WHERE appointment_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                    checkStmt.setInt(1, newDoctorId);
                    checkStmt.setTimestamp(2, Timestamp.valueOf(newTime));
                    ResultSet rs = checkStmt.executeQuery();
                    if (rs.next() && rs.getInt(1) > 0) {
                        throw new SQLException("Time slot not available");
                    }
                }
                
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                    updateStmt.setTimestamp(1, Timestamp.valueOf(newTime));
                    updateStmt.setInt(2, newDoctorId);
                    updateStmt.setInt(3, appointmentId);
                    updateStmt.executeUpdate();
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }
    
    public List<Appointment> getDailySchedule(LocalDate date, int doctorId) throws SQLException {
        String sql = "SELECT a.*, p.name as patient_name FROM appointments a " +
                     "JOIN patients p ON a.patient_id = p.patient_id " +
                     "WHERE DATE(a.appointment_time) = ? AND a.doctor_id = ? " +
                     "ORDER BY a.appointment_time";
        List<Appointment> appointments = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(date));
            stmt.setInt(2, doctorId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Appointment a = new Appointment();
                a.setAppointmentId(rs.getInt("appointment_id"));
                a.setPatientId(rs.getInt("patient_id"));
                a.setDoctorId(rs.getInt("doctor_id"));
                a.setAppointmentTime(rs.getTimestamp("appointment_time").toLocalDateTime());
                a.setStatus(rs.getString("status"));
                appointments.add(a);
            }
        }
        return appointments;
    }
}
