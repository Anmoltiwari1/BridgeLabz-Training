package HealthClinicApp;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class BillingDAO {
    
    public int generateBill(int visitId, double amount) throws SQLException {
        String sql = "INSERT INTO bills (visit_id, amount, payment_status) VALUES (?, ?, 'UNPAID')";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, visitId);
            stmt.setDouble(2, amount);
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }
    
    public void recordPayment(int billId, String paymentMode) throws SQLException {
        String sql = "UPDATE bills SET payment_status = 'PAID', payment_date = NOW(), payment_mode = ? WHERE bill_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paymentMode);
            stmt.setInt(2, billId);
            stmt.executeUpdate();
        }
    }
    
    public Map<String, Object> getOutstandingBills() throws SQLException {
        String sql = "SELECT p.name, SUM(b.amount) as total, COUNT(*) as count " +
                     "FROM bills b JOIN visits v ON b.visit_id = v.visit_id " +
                     "JOIN patients p ON v.patient_id = p.patient_id " +
                     "WHERE b.payment_status = 'UNPAID' " +
                     "GROUP BY p.patient_id, p.name";
        Map<String, Object> result = new HashMap<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.put(rs.getString("name"), 
                    "Total: " + rs.getDouble("total") + ", Count: " + rs.getInt("count"));
            }
        }
        return result;
    }
    
    public Map<String, Double> generateRevenueReport(Date startDate, Date endDate) throws SQLException {
        String sql = "SELECT DATE(payment_date) as date, SUM(amount) as revenue " +
                     "FROM bills WHERE payment_status = 'PAID' AND payment_date BETWEEN ? AND ? " +
                     "GROUP BY DATE(payment_date)";
        Map<String, Double> report = new HashMap<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, startDate);
            stmt.setDate(2, endDate);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                report.put(rs.getDate("date").toString(), rs.getDouble("revenue"));
            }
        }
        return report;
    }
}
