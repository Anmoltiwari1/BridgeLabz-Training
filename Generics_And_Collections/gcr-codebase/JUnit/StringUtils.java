public class StringUtils {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    public boolean isPalindrome(String str) {
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        return cleaned.equals(reverse(cleaned));
    }
    
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}