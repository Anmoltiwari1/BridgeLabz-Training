public class DateFormatter {
    public String formatDate(String inputDate) {
        if (inputDate == null || !inputDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("Invalid date format. Expected yyyy-MM-dd");
        }
        
        String[] parts = inputDate.split("-");
        return parts[2] + "-" + parts[1] + "-" + parts[0];
    }
}